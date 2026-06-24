package com.tech5.test.people.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.tech5.test.people.data.remote.PersonApi
import com.tech5.test.people.data.remote.PersonPagingSource
import com.tech5.test.people.domain.model.Person
import com.tech5.test.people.domain.repository.PersonRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class PersonRepositoryImpl @Inject constructor(
    private val personApi: PersonApi
) : PersonRepository {
    override fun getPopularPeople(): Flow<PagingData<Person>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { PersonPagingSource(personApi) }
        ).flow
    }
}
