package com.tech5.test.movies.domain.repository

import com.tech5.test.movies.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovies(): Flow<List<Movie>>
}
