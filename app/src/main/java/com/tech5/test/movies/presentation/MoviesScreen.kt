package com.tech5.test.movies.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import com.tech5.test.R
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.tech5.test.movies.presentation.components.MovieCarousel

@Composable
fun MoviesScreen(
    onMovieClick: (Int) -> Unit,
    viewModel: MoviesViewModel = hiltViewModel()
) {
    val trendingMovies = viewModel.trendingMovies.collectAsLazyPagingItems()
    val popularMovies = viewModel.popularMovies.collectAsLazyPagingItems()
    val topRatedMovies = viewModel.topRatedMovies.collectAsLazyPagingItems()
    val upcomingMovies = viewModel.upcomingMovies.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        MovieCarousel(
            title = stringResource(R.string.trending_movies),
            movies = trendingMovies,
            onMovieClick = onMovieClick
        )

        MovieCarousel(
            title = stringResource(R.string.popular_movies),
            movies = popularMovies,
            onMovieClick = onMovieClick
        )

        MovieCarousel(
            title = stringResource(R.string.top_rated_movies),
            movies = topRatedMovies,
            onMovieClick = onMovieClick
        )

        MovieCarousel(
            title = stringResource(R.string.upcoming_movies),
            movies = upcomingMovies,
            onMovieClick = onMovieClick
        )
    }
}
