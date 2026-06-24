package com.tech5.test.tvshows.data.remote.dto.details

import kotlinx.serialization.Serializable

@Serializable
data class LastEpisodeToAir(
    val air_date: String? = null ,
    val episode_number: Int? = null,
    val id: Int? = null,
    val name: String? = null,
    val overview: String? = null,
    val production_code: String? = null,
    val runtime: Int? = null,
    val season_number: Int? = null,
    val show_id: Int? = null,
    val still_path: String? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null
)