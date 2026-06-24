package com.tech5.test.tvshows.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.tech5.test.tvshows.domain.model.TvShowDetails
import com.tech5.test.tvshows.domain.usecase.GetTvShowDetailsUseCase
import com.tech5.test.ui.navigation.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowDetailViewModel @Inject constructor(
    private val getTvShowDetailsUseCase: GetTvShowDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val tvShowId = savedStateHandle.toRoute<Route.TvShowDetail>().seriesId

    private val _uiState = MutableStateFlow<TvShowDetailUiState>(TvShowDetailUiState.Loading)
    val uiState: StateFlow<TvShowDetailUiState> = _uiState.asStateFlow()

    init {
        getTvShowDetails()
    }

    private fun getTvShowDetails() {
        viewModelScope.launch {
            try {
                val details = getTvShowDetailsUseCase(tvShowId)
                _uiState.value = TvShowDetailUiState.Success(details)
            } catch (e: Exception) {
                _uiState.value = TvShowDetailUiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}

sealed interface TvShowDetailUiState {
    data object Loading : TvShowDetailUiState
    data class Success(val tvShowDetails: TvShowDetails) : TvShowDetailUiState
    data class Error(val message: String) : TvShowDetailUiState
}
