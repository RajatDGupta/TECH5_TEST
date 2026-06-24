package com.tech5.test.people.data.repository

import com.tech5.test.people.data.remote.PersonApi
import com.tech5.test.people.data.remote.dto.PersonDTO
import com.tech5.test.people.data.remote.dto.PersonResponseDTO
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class PersonRepositoryImplTest {

    private lateinit var repository: PersonRepositoryImpl
    private val personApi: PersonApi = mockk()

    @Before
    fun setUp() {
        repository = PersonRepositoryImpl(personApi)
    }

    @Test
    fun `getPopularPeople should return a flow of paging data`() {
        // When
        val result = repository.getPopularPeople()

        // Then
        assertNotNull(result)
    }

    @Test
    fun `searchPeople should return list of persons when api call is successful`() = runTest {
        // Given
        val query = "John"
        val personDto = PersonDTO(id = 1, name = "John Doe")
        val response = PersonResponseDTO(results = listOf(personDto))
        coEvery { personApi.searchPeople(query) } returns response

        // When
        val result = repository.searchPeople(query)

        // Then
        assertEquals(1, result.size)
        assertEquals("John Doe", result[0].name)
        assertEquals(1, result[0].id)
    }

    @Test
    fun `searchPeople should return empty list when api results are null`() = runTest {
        // Given
        val query = "Unknown"
        val response = PersonResponseDTO(results = null)
        coEvery { personApi.searchPeople(query) } returns response

        // When
        val result = repository.searchPeople(query)

        // Then
        assertEquals(0, result.size)
    }
}
