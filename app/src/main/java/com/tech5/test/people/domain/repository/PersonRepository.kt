package com.tech5.test.people.domain.repository

import androidx.paging.PagingData
import com.tech5.test.people.domain.model.Person
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    fun getPopularPeople(): Flow<PagingData<Person>>
}
