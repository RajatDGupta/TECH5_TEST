package com.tech5.test.people.presentation

import androidx.paging.PagingData
import com.tech5.test.people.domain.model.Person
import com.tech5.test.people.domain.usecase.GetPeopleUseCase
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class PeopleViewModelTest {

    private lateinit var viewModel: PeopleViewModel
    private val getPeopleUseCase: GetPeopleUseCase = mockk()
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        every { getPeopleUseCase() } returns flowOf(PagingData.empty())
        viewModel = PeopleViewModel(getPeopleUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `peopleState should call getPeopleUseCase`() = runTest {
        // Given
        val pagingData = PagingData.from(listOf(
            Person(1, "John", "Acting", 1.0, null, null)
        ))
        every { getPeopleUseCase() } returns flowOf(pagingData)

        // When
        // ViewModel is already initialized in setUp, but we can re-initialize to pick up the new mock behavior if needed
        // Or just verify it was called during init
        val viewModel = PeopleViewModel(getPeopleUseCase)
        val result = viewModel.peopleState.first()

        // Then
        verify { getPeopleUseCase() }
        assertNotNull(result)
    }
}
