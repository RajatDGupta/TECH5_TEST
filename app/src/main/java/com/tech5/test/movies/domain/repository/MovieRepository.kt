package com.tech5.test.movies.domain.repository

import androidx.paging.PagingData
import com.tech5.test.movies.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getTrendingMovies(): Flow<PagingData<Movie>>
}
