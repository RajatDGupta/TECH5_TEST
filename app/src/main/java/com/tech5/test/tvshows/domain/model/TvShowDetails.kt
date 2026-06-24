package com.tech5.test.tvshows.domain.model

import com.tech5.test.tvshows.data.remote.dto.details.Genre

data class TvShowDetails(
    val backdrop_path: String?,
    val poster_path: String?,
    val title: String?,
    val tagline: String?,
    val overview: String?,
    val genres: List<Genre?>?,
    val number_of_episodes: Int?,
    val vote_average: Double?,
)
