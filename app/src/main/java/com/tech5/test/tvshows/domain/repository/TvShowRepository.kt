package com.tech5.test.tvshows.domain.repository

import com.tech5.test.tvshows.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowRepository {
    fun getTvShows(): Flow<List<TvShow>>
}
