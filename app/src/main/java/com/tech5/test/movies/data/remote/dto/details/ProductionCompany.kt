package com.tech5.test.movies.data.remote.dto.details

import kotlinx.serialization.Serializable

@Serializable
data class ProductionCompany(
    val id: Int?,
    val logo_path: String?,
    val name: String?,
    val origin_country: String?
)