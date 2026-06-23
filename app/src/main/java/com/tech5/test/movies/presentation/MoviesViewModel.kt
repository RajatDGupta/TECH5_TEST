package com.tech5.test.movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.tech5.test.movies.domain.model.Movie
import com.tech5.test.movies.domain.usecase.GetPopularMoviesUseCase
import com.tech5.test.movies.domain.usecase.GetTopRatedMoviesUseCase
import com.tech5.test.movies.domain.usecase.GetTrendingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase
) : ViewModel() {

    val trendingMovies: Flow<PagingData<Movie>> = getTrendingMoviesUseCase()
        .cachedIn(viewModelScope)

    val popularMovies: Flow<PagingData<Movie>> = getPopularMoviesUseCase()
        .cachedIn(viewModelScope)

    val topRatedMovies: Flow<PagingData<Movie>> = getTopRatedMoviesUseCase()
        .cachedIn(viewModelScope)
}
