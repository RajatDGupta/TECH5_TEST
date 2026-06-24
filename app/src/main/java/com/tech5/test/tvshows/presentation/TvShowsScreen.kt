package com.tech5.test.tvshows.presentation

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
import com.tech5.test.tvshows.presentation.components.TvShowCarousel

@Composable
fun TvShowsScreen(
    viewModel: TvShowsViewModel = hiltViewModel()
) {
    val trendingTvShows = viewModel.trendingTvShows.collectAsLazyPagingItems()
    val popularTvShows = viewModel.popularTvShows.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        TvShowCarousel(
            title = "Trending Tv Shows",
            tvShows = trendingTvShows
        )

        TvShowCarousel(
            title = "Popular Tv Shows",
            tvShows = popularTvShows
        )
    }
}
