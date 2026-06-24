package com.tech5.test.movies.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class MoviesResponseDTO(
    val page: Int ?= null,
    val results: List<MovieDTO?> ?= null,
    val total_pages: Int ?= null,
    val total_results: Int ?= null
)
