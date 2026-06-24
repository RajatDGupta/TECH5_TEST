package com.tech5.test.tvshows.domain.repository

import androidx.paging.PagingData
import com.tech5.test.tvshows.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowRepository {
    fun getTrendingTvShows(): Flow<PagingData<TvShow>>
}
