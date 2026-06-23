package com.tech5.test.movies.domain.usecase

import androidx.paging.PagingData
import com.tech5.test.movies.domain.model.Movie
import com.tech5.test.movies.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    operator fun invoke(): Flow<PagingData<Movie>> {
        return repository.getTrendingMovies()
    }
}
