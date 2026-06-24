package com.tech5.test.tvshows.presentation

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
import com.tech5.test.tvshows.presentation.components.TvShowCarousel

@Composable
fun TvShowsScreen(
    onTvShowClick: (Int) -> Unit,
    viewModel: TvShowsViewModel = hiltViewModel()
) {
    val trendingTvShows = viewModel.trendingTvShows.collectAsLazyPagingItems()
    val popularTvShows = viewModel.popularTvShows.collectAsLazyPagingItems()
    val topRatedTvShows = viewModel.topRatedTvShows.collectAsLazyPagingItems()
    val airingTodayTvShows = viewModel.airingTodayTvShows.collectAsLazyPagingItems()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        TvShowCarousel(
            title = stringResource(R.string.trending_tv_shows),
            tvShows = trendingTvShows,
            onTvShowClick = onTvShowClick
        )

        TvShowCarousel(
            title = stringResource(R.string.popular_tv_shows),
            tvShows = popularTvShows,
            onTvShowClick = onTvShowClick
        )

        TvShowCarousel(
            title = stringResource(R.string.top_rated_tv_shows),
            tvShows = topRatedTvShows,
            onTvShowClick = onTvShowClick
        )

        TvShowCarousel(
            title = stringResource(R.string.airing_today_tv_shows),
            tvShows = airingTodayTvShows,
            onTvShowClick = onTvShowClick
        )
    }
}
