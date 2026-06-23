package com.tech5.test.movies.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TrendingMoviesResponseDTO(
    val page: Int,
    val results: List<MovieDTO>,
    val total_pages: Int,
    val total_results: Int
)
