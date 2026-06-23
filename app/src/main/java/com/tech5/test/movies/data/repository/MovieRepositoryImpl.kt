package com.tech5.test.movies.data.repository

import com.tech5.test.movies.domain.model.Movie
import com.tech5.test.movies.domain.repository.MovieRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ViewModelScoped
class MovieRepositoryImpl @Inject constructor() : MovieRepository {
    override fun getMovies(): Flow<List<Movie>> = flow {
        // Mock data
        emit(
            listOf(
                Movie(1, "Movie 1", "Overview 1", null),
                Movie(2, "Movie 2", "Overview 2", null)
            )
        )
    }
}
