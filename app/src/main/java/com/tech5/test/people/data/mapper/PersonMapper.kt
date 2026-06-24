package com.tech5.test.people.data.mapper

import com.tech5.test.people.data.remote.dto.PersonDTO
import com.tech5.test.people.domain.model.Person

fun PersonDTO.toPerson(): Person {
    return Person(
        id = id ?: 0,
        name = name ?: "",
        known_for_department = known_for_department ?: "",
        popularity = popularity,
        profilePath = profile_path?.let { "https://image.tmdb.org/t/p/w500$it" },
        known_for = known_for
    )
}
