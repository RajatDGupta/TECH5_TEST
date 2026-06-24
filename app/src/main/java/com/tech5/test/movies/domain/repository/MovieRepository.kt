package com.tech5.test.movies.domain.repository

import androidx.paging.PagingData
import com.tech5.test.movies.domain.model.Movie
import com.tech5.test.movies.domain.model.MovieDetails
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getTrendingMovies(): Flow<PagingData<Movie>>
    fun getPopularMovies(): Flow<PagingData<Movie>>
    fun getTopRatedMovies(): Flow<PagingData<Movie>>
    fun getUpcomingMovies(): Flow<PagingData<Movie>>

    suspend fun getMovieDetails(movieId: Int): MovieDetails
    suspend fun searchMovies(query: String): List<Movie>
}
