package com.tech5.test.tvshows.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TVShowResponseDTO(
    val page: Int,
    val results: List<TVShowDTO>,
    val total_pages: Int,
    val total_results: Int
)