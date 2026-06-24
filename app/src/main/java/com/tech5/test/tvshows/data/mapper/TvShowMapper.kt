package com.tech5.test.tvshows.data.mapper

import com.tech5.test.tvshows.data.remote.dto.TVShowDTO
import com.tech5.test.tvshows.data.remote.dto.details.TVShowDetailDTO
import com.tech5.test.tvshows.domain.model.TvShow
import com.tech5.test.tvshows.domain.model.TvShowDetails

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


fun TVShowDetailDTO.toTvShowDetails(): TvShowDetails {
    return TvShowDetails(
        backdrop_path ="https://image.tmdb.org/t/p/w500${backdrop_path}" ,
        poster_path = "https://image.tmdb.org/t/p/w500${poster_path}",
        title = name,
        tagline = tagline,
        overview = overview,
        genres = genres,
        number_of_episodes = number_of_episodes,
        vote_average = vote_average
    )
}