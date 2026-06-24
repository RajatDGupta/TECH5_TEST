package com.tech5.test.people.domain.model

data class Person(
    val id: Int,
    val name: String,
    val known_for_department: String,
    val popularity: Double?,
    val profilePath: String?
)
