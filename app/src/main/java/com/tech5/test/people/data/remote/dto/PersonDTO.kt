package com.tech5.test.people.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PersonDTO(
    val adult: Boolean?,
    val gender: Int?,
    val id: Int?,
    val known_for: List<KnownFor?>?,
    val known_for_department: String?,
    val name: String?,
    val original_name: String?,
    val popularity: Double?,
    val profile_path: String?
)