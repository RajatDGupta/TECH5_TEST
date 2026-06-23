package com.tech5.test.people.domain.usecase

import com.tech5.test.people.domain.model.Person
import com.tech5.test.people.domain.repository.PersonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPeopleUseCase @Inject constructor(
    private val repository: PersonRepository
) {
    operator fun invoke(): Flow<List<Person>> {
        return repository.getPeople()
    }
}
