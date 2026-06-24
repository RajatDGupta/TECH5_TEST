package com.tech5.test.people.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PersonDTO(
    val adult: Boolean? =null,
    val gender: Int? = null,
    val id: Int? = null,
    val known_for: List<KnownFor?>? = null,
    val known_for_department: String? = null,
    val name: String? = null,
    val original_name: String? = null,
    val popularity: Double? = null,
    val profile_path: String? = null
)