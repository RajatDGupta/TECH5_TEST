package com.tech5.test.movies.data.remote.dto.details

import kotlinx.serialization.Serializable

@Serializable
data class ProductionCompany(
    val id: Int? = null,
    val logo_path: String? = null,
    val name: String? = null,
    val origin_country: String? = null
)