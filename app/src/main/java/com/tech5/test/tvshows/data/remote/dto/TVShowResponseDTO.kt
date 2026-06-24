package com.tech5.test.tvshows.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TVShowResponseDTO(
    val page: Int? = null,
    val results: List<TVShowDTO>? = null,
    val total_pages: Int? = null,
    val total_results: Int? = null
)