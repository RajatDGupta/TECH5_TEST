package com.tech5.test.people.domain.model

data class Person(
    val id: Int,
    val name: String,
    val knownFor: String,
    val profilePath: String?
)
