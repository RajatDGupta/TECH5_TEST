package com.tech5.test.tvshows.data.remote.dto.details

import kotlinx.serialization.Serializable

@Serializable
data class TVShowDetailDTO(
    val adult: Boolean? = null,
    val backdrop_path: String? = null,
    val created_by: List<CreatedBy?>? = null,
    val episode_run_time: List<Int?>? = null,
    val first_air_date: String? = null,
    val genres: List<Genre?>? = null,
    val homepage: String? = null,
    val id: Int? = null,
    val in_production: Boolean? = null,
    val languages: List<String?>? = null,
    val last_air_date: String? = null,
    val last_episode_to_air: LastEpisodeToAir? = null,
    val name: String? = null,
    val networks: List<Network?>? = null,
    val number_of_episodes: Int? = null,
    val number_of_seasons: Int? = null,
    val origin_country: List<String?>? = null,
    val original_language: String? = null,
    val original_name: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val production_companies: List<ProductionCompany?>? = null,
    val production_countries: List<ProductionCountry?>? = null,
    val seasons: List<Season?>? = null,
    val spoken_languages: List<SpokenLanguage?>? = null,
    val status: String? = null,
    val tagline: String? = null,
    val type: String? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null
)