package com.tech5.test.people.domain.usecase

import androidx.paging.PagingData
import com.tech5.test.people.domain.model.Person
import com.tech5.test.people.domain.repository.PersonRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GetPeopleUseCaseTest {

    private lateinit var getPeopleUseCase: GetPeopleUseCase
    private val repository: PersonRepository = mockk()

    @Before
    fun setUp() {
        getPeopleUseCase = GetPeopleUseCase(repository)
    }

    @Test
    fun `invoke should call getPopularPeople from repository`() {
        // Given
        val pagingData = PagingData.from(listOf(
            Person(1, "John", "Acting", 1.0, null, null)
        ))
        val expectedFlow = flowOf(pagingData)
        every { repository.getPopularPeople() } returns expectedFlow

        // When
        val result = getPeopleUseCase()

        // Then
        verify { repository.getPopularPeople() }
        assertEquals(expectedFlow, result)
    }
}
