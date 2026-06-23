package com.tech5.test.people.data.repository

import com.tech5.test.people.domain.model.Person
import com.tech5.test.people.domain.repository.PersonRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ViewModelScoped
class PersonRepositoryImpl @Inject constructor() : PersonRepository {
    override fun getPeople(): Flow<List<Person>> = flow {
        // Mock data
        emit(
            listOf(
                Person(1, "Person 1", "Acting", null),
                Person(2, "Person 2", "Directing", null)
            )
        )
    }
}
