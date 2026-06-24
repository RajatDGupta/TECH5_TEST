package com.tech5.test.tvshows.data.remote.dto.details

import kotlinx.serialization.Serializable

@Serializable

data class Genre(
    val id: Int?= null,
    val name: String? = null
)