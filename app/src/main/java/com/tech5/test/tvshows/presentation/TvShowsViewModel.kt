package com.tech5.test.tvshows.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech5.test.tvshows.domain.model.TvShow
import com.tech5.test.tvshows.domain.usecase.GetTvShowsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

data class TvShowsUiState(
    val tvShows: List<TvShow> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

@HiltViewModel
class TvShowsViewModel @Inject constructor(
    private val getTvShowsUseCase: GetTvShowsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(TvShowsUiState())
    val uiState: StateFlow<TvShowsUiState> = _uiState.asStateFlow()

    init {
        getTvShows()
    }

    private fun getTvShows() {
        _uiState.value = _uiState.value.copy(isLoading = true)
        getTvShowsUseCase()
            .onEach { tvShows ->
                _uiState.value = _uiState.value.copy(
                    tvShows = tvShows,
                    isLoading = false
                )
            }
            .launchIn(viewModelScope)
    }
}
