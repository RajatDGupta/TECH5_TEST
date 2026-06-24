package com.tech5.test.people.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PersonResponseDTO (
    val page: Int,
    val results: List<PersonDTO>,
    val total_pages: Int,
    val total_results: Int
)