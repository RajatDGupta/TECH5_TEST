package com.tech5.test.movies.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.tech5.test.movies.data.mapper.toMovieDetails
import com.tech5.test.movies.data.remote.MovieApi
import com.tech5.test.movies.data.remote.MovieCategory
import com.tech5.test.movies.data.remote.MoviePagingSource
import com.tech5.test.movies.domain.model.Movie
import com.tech5.test.movies.domain.model.MovieDetails
import com.tech5.test.movies.domain.repository.MovieRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class MovieRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi
) : MovieRepository {
    override fun getTrendingMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviePagingSource(movieApi, MovieCategory.TRENDING)
            }
        ).flow
    }

    override fun getPopularMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviePagingSource(movieApi, MovieCategory.POPULAR)
            }
        ).flow
    }

    override fun getTopRatedMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviePagingSource(movieApi, MovieCategory.TOP_RATED)
            }
        ).flow
    }

    override fun getUpcomingMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                MoviePagingSource(movieApi, MovieCategory.UPCOMING)
            }
        ).flow
    }

    override suspend fun getMovieDetails(movieId: Int): MovieDetails = withContext(Dispatchers.IO) {
        movieApi.getMovieDetails(movieId).toMovieDetails()
    }
}
