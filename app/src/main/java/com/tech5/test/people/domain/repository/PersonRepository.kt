package com.tech5.test.people.domain.repository

import com.tech5.test.people.domain.model.Person
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    fun getPeople(): Flow<List<Person>>
}
