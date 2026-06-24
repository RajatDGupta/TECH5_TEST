package com.tech5.test.tvshows.domain.model

data class TvShow(
    val id: Int,
    val name: String,
    val overview: String,
    val posterPath: String?,
    val firstAirDate: String?,
    val rating: Double
)
