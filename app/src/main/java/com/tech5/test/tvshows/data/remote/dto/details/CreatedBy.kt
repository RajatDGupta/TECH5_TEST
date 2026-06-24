package com.tech5.test.tvshows.data.remote.dto.details

import kotlinx.serialization.Serializable

@Serializable
data class CreatedBy(
    val credit_id: String?,
    val gender: Int?,
    val id: Int?,
    val name: String?,
    val profile_path: String?
)