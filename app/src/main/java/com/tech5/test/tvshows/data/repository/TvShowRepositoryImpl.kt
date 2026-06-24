package com.tech5.test.tvshows.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.tech5.test.tvshows.data.mapper.toTvShow
import com.tech5.test.tvshows.data.mapper.toTvShowDetails
import com.tech5.test.tvshows.data.remote.TvShowApi
import com.tech5.test.tvshows.data.remote.TvShowCategory
import com.tech5.test.tvshows.data.remote.TvShowPagingSource
import com.tech5.test.tvshows.data.remote.dto.details.TVShowDetailDTO
import com.tech5.test.tvshows.domain.model.TvShow
import com.tech5.test.tvshows.domain.model.TvShowDetails
import com.tech5.test.tvshows.domain.repository.TvShowRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class TvShowRepositoryImpl @Inject constructor(
    private val tvShowApi: TvShowApi
) : TvShowRepository {
    override fun getTrendingTvShows(): Flow<PagingData<TvShow>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { TvShowPagingSource(tvShowApi, TvShowCategory.TRENDING) }
        ).flow
    }

    override fun getPopularTvShows(): Flow<PagingData<TvShow>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { TvShowPagingSource(tvShowApi, TvShowCategory.POPULAR) }
        ).flow
    }

    override fun getTopRatedTvShows(): Flow<PagingData<TvShow>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { TvShowPagingSource(tvShowApi, TvShowCategory.TOP_RATED) }
        ).flow
    }

    override fun getAiringTodayTvShows(): Flow<PagingData<TvShow>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { TvShowPagingSource(tvShowApi, TvShowCategory.AIRING_TODAY) }
        ).flow
    }

    override suspend fun getTvShowDetails(seriesId: Int): TvShowDetails = withContext(Dispatchers.IO) {
        tvShowApi.getTvShowDetails(seriesId).toTvShowDetails()
    }

    override suspend fun searchTvShows(query: String): List<TvShow> = withContext(Dispatchers.IO) {
        tvShowApi.searchTvShows(query).results?.map { it.toTvShow() } ?: emptyList()
    }
}


