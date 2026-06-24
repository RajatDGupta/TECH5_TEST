package com.tech5.test.people.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class KnownFor(
    val adult: Boolean?  = null,
    val backdrop_path: String?  = null,
    val first_air_date: String? = null,
    val genre_ids: List<Int?>? = null,
    val id: Int? = null,
    val media_type: String? = null,
    val name: String? = null,
    val origin_country: List<String?>? = null,
    val original_language: String? = null,
    val original_name: String? = null,
    val original_title: String? = null ,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val release_date: String? = null,
    val softcore: Boolean? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null
)