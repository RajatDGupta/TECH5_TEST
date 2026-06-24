package com.tech5.test.movies.data.mapper

import com.tech5.test.movies.data.remote.dto.MovieDTO
import com.tech5.test.movies.data.remote.dto.details.MovieDetailsDTO
import com.tech5.test.movies.domain.model.Movie
import com.tech5.test.movies.domain.model.MovieDetails

fun MovieDTO.toMovie(): Movie {
    return Movie(
        id = id ?: 0,
        title = title ?: original_title ?: "",
        posterPath = "https://image.tmdb.org/t/p/w500${poster_path}",
        releaseDate = release_date ?: "",
        rating = vote_average ?: 0.0
    )
}

fun MovieDetailsDTO.toMovieDetails(): MovieDetails {
    return MovieDetails(
        backdrop_path = "https://image.tmdb.org/t/p/w500${backdrop_path}",
        poster_path = "https://image.tmdb.org/t/p/w500${poster_path}",
        title = title ?: original_title ?: "",
        tagline = tagline ?: "",
        overview = overview ?: "",
        genres = genres ?: emptyList(),
        runtime = runtime ?: 0,
        vote_average = vote_average ?: 0.0
    )
}
