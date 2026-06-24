package com.tech5.test.tvshows.domain.repository

import androidx.paging.PagingData
import com.tech5.test.tvshows.domain.model.TvShow
import com.tech5.test.tvshows.domain.model.TvShowDetails
import kotlinx.coroutines.flow.Flow

interface TvShowRepository {
    fun getTrendingTvShows(): Flow<PagingData<TvShow>>
    fun getPopularTvShows(): Flow<PagingData<TvShow>>
    fun getTopRatedTvShows(): Flow<PagingData<TvShow>>
    fun getAiringTodayTvShows(): Flow<PagingData<TvShow>>
    suspend fun getTvShowDetails(seriesId: Int): TvShowDetails
}
