package com.tech5.test.movies.domain.usecase

import com.tech5.test.movies.domain.model.MovieDetails
import com.tech5.test.movies.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int): MovieDetails {
        return repository.getMovieDetails(movieId)
    }
}
