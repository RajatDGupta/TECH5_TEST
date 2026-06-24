package com.tech5.test.tvshows.data.remote.dto.details

import kotlinx.serialization.Serializable

@Serializable

data class Network(
    val id: Int?,
    val logo_path: String?,
    val name: String?,
    val origin_country: String?
)