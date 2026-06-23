package com.tech5.test.movies.data.mapper

import com.tech5.test.movies.data.remote.dto.MovieDTO
import com.tech5.test.movies.domain.model.Movie

fun MovieDTO.toMovie(): Movie {
    return Movie(
        id = id ?: 0,
        title = title ?: original_title ?: "",
        posterPath = "https://image.tmdb.org/t/p/w500${poster_path}",
        releaseDate = release_date ?: "",
        rating = vote_average ?: 0.0
    )
}
