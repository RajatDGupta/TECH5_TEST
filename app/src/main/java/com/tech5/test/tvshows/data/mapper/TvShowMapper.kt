package com.tech5.test.tvshows.data.mapper

import com.tech5.test.tvshows.data.remote.dto.TVShowDTO
import com.tech5.test.tvshows.domain.model.TvShow

fun TVShowDTO.toTvShow(): TvShow {
    return TvShow(
        id = id ?: 0,
        name = name ?: "",
        overview = overview ?: "",
        posterPath = "https://image.tmdb.org/t/p/w500${poster_path}",
        firstAirDate = first_air_date,
        rating = vote_average ?: 0.0
    )
}
