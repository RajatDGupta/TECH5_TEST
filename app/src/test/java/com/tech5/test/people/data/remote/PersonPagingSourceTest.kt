package com.tech5.test.people.data.remote

import androidx.paging.PagingSource
import com.tech5.test.people.data.mapper.toPerson
import com.tech5.test.people.data.remote.dto.PersonDTO
import com.tech5.test.people.data.remote.dto.PersonResponseDTO
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class PersonPagingSourceTest {

    private lateinit var personPagingSource: PersonPagingSource
    private val personApi: PersonApi = mockk()

    @Before
    fun setUp() {
        personPagingSource = PersonPagingSource(personApi)
    }

    @Test
    fun `load returns success on valid data`() = runTest {
        // Given
        val personDto = PersonDTO(id = 1, name = "John")
        val response = PersonResponseDTO(
            page = 1,
            results = listOf(personDto),
            total_pages = 2,
            total_results = 1
        )
        coEvery { personApi.getPopularPeople(page = 1) } returns response

        // When
        val result = personPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 20,
                placeholdersEnabled = false
            )
        )

        // Then
        assertTrue(result is PagingSource.LoadResult.Page)
        val pageResult = result as PagingSource.LoadResult.Page
        assertEquals(1, pageResult.data.size)
        assertEquals(null, pageResult.prevKey)
        assertEquals(2, pageResult.nextKey)
        assertEquals("John", pageResult.data[0].name)
    }

    @Test
    fun `load returns error on exception`() = runTest {
        // Given
        val exception = RuntimeException("Network error")
        coEvery { personApi.getPopularPeople(any()) } throws exception

        // When
        val result = personPagingSource.load(
            PagingSource.LoadParams.Refresh(
                key = null,
                loadSize = 20,
                placeholdersEnabled = false
            )
        )

        // Then
        assertTrue(result is PagingSource.LoadResult.Error)
        assertEquals(exception, (result as PagingSource.LoadResult.Error).throwable)
    }
}
