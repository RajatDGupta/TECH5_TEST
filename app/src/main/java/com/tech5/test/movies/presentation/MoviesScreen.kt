package com.tech5.test.movies.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            title = "Trending Movies",
            movies = trendingMovies,
            onMovieClick = onMovieClick
        )

        MovieCarousel(
            title = "Popular Movies",
            movies = popularMovies,
            onMovieClick = onMovieClick
        )

        MovieCarousel(
            title = "Top Rated Movies",
            movies = topRatedMovies,
            onMovieClick = onMovieClick
        )

        MovieCarousel(
            title = "Upcoming Movies",
            movies = upcomingMovies,
            onMovieClick = onMovieClick
        )
    }
}
