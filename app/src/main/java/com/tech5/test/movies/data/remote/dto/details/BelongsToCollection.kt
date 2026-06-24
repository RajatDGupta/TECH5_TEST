package com.tech5.test.movies.data.remote.dto.details

import kotlinx.serialization.Serializable

@Serializable
data class BelongsToCollection(
    val backdrop_path: String?,
    val id: Int?,
    val name: String?,
    val poster_path: String?
)