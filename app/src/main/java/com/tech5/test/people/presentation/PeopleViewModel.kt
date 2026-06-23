package com.tech5.test.people.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech5.test.people.domain.model.Person
import com.tech5.test.people.domain.usecase.GetPeopleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

data class PeopleUiState(
    val people: List<Person> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeopleUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(PeopleUiState())
    val uiState: StateFlow<PeopleUiState> = _uiState.asStateFlow()

    init {
        getPeople()
    }

    private fun getPeople() {
        _uiState.value = _uiState.value.copy(isLoading = true)
        getPeopleUseCase()
            .onEach { people ->
                _uiState.value = _uiState.value.copy(
                    people = people,
                    isLoading = false
                )
            }
            .launchIn(viewModelScope)
    }
}
