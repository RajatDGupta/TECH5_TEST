package com.tech5.test.movies.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tech5.test.movies.data.mapper.toMovie
import com.tech5.test.movies.domain.model.Movie

class MoviePagingSource(
    private val movieApi: MovieApi,
    private val isPopular: Boolean = false
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key ?: 1
        return try {
            val response = if (isPopular) {
                movieApi.getPopularMovies(page = page)
            } else {
                movieApi.getTrendingMovies(page = page)
            }
            val movies = response.results.map { it.toMovie() }
            LoadResult.Page(
                data = movies,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (movies.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
