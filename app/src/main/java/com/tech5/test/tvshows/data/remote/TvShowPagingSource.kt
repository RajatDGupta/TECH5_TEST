package com.tech5.test.tvshows.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tech5.test.tvshows.data.mapper.toTvShow
import com.tech5.test.tvshows.domain.model.TvShow

class TvShowPagingSource(
    private val tvShowApi: TvShowApi
) : PagingSource<Int, TvShow>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TvShow> {
        val page = params.key ?: 1
        return try {
            val response = tvShowApi.getTrendingTvShows(page = page)
            val tvShows = response.results.map { it.toTvShow() }
            LoadResult.Page(
                data = tvShows,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (tvShows.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, TvShow>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
