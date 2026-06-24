package com.tech5.test.people.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PersonResponseDTO (
    val page: Int?=null,
    val results: List<PersonDTO> ?= null,
    val total_pages: Int?=null,
    val total_results: Int?=null
)