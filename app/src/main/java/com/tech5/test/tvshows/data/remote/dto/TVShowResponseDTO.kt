package com.tech5.test.tvshows.data.remote.dto

import com.tech5.test.movies.data.remote.dto.MovieDTO
import kotlinx.serialization.Serializable

@Serializable
data class TVShowResponseDTO(
    val page: Int,
    val results: List<MovieDTO>,
    val total_pages: Int,
    val total_results: Int
)