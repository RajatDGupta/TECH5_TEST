package com.tech5.test.tvshows.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.tech5.test.tvshows.domain.model.TvShow
import com.tech5.test.tvshows.domain.usecase.GetPopularTvShowsUseCase
import com.tech5.test.tvshows.domain.usecase.GetTrendingTvShowsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class TvShowsViewModel @Inject constructor(
    private val getTrendingTvShowsUseCase: GetTrendingTvShowsUseCase,
    private val getPopularTvShowsUseCase: GetPopularTvShowsUseCase
) : ViewModel() {

    val trendingTvShows: Flow<PagingData<TvShow>> = getTrendingTvShowsUseCase()
        .cachedIn(viewModelScope)

    val popularTvShows: Flow<PagingData<TvShow>> = getPopularTvShowsUseCase()
        .cachedIn(viewModelScope)
}
