package com.tech5.test.movies.domain.model

import com.tech5.test.movies.data.remote.dto.details.Genre

data class MovieDetails(
    val backdrop_path: String?,
    val poster_path: String?,
    val title: String?,
    val tagline: String?,
    val overview: String?,
    val genres: List<Genre?>?,
    val runtime: Int?,
    val vote_average: Double?,

    )