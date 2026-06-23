package com.tech5.test.movies.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.tech5.test.movies.data.remote.MovieApi
import com.tech5.test.movies.data.remote.MoviePagingSource
import com.tech5.test.movies.domain.model.Movie
import com.tech5.test.movies.domain.repository.MovieRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
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
                MoviePagingSource(movieApi)
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
                MoviePagingSource(movieApi, isPopular = true)
            }
        ).flow
    }
}
