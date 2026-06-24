package com.tech5.test.movies.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tech5.test.movies.domain.model.MovieDetails
import com.tech5.test.movies.domain.usecase.GetMovieDetailsUseCase
import com.tech5.test.core.utils.toErrorMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(MovieDetailsState())
    val state: State<MovieDetailsState> = _state

    init {
        savedStateHandle.get<Int>("movieId")?.let { movieId ->
            getMovieDetails(movieId)
        }
    }

    private fun getMovieDetails(movieId: Int) {
        viewModelScope.launch {
            _state.value = MovieDetailsState(isLoading = true)
            try {
                val movieDetails = getMovieDetailsUseCase(movieId)
                _state.value = MovieDetailsState(movieDetails = movieDetails)
            } catch (e: Exception) {
                _state.value = MovieDetailsState(error = e.toErrorMessage())
            }
        }
    }
}

data class MovieDetailsState(
    val isLoading: Boolean = false,
    val movieDetails: MovieDetails? = null,
    val error: String = ""
)
