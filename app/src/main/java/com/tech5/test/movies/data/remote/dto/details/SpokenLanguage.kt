package com.tech5.test.movies.data.remote.dto.details

import kotlinx.serialization.Serializable

@Serializable
data class SpokenLanguage(
    val english_name: String? = null,
    val iso_639_1: String? = null,
    val name: String? = null
)