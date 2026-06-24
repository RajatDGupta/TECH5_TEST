package com.tech5.test.people.domain.model

import com.tech5.test.people.data.remote.dto.KnownFor
import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val id: Int,
    val name: String,
    val known_for_department: String,
    val popularity: Double?,
    val profilePath: String?,
    val known_for: List<KnownFor?>? = null,
)
