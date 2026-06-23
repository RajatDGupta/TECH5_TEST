package com.tech5.test.people.di

import com.tech5.test.people.data.repository.PersonRepositoryImpl
import com.tech5.test.people.domain.repository.PersonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class PersonModule {

    @Binds
    @ViewModelScoped
    abstract fun bindPersonRepository(
        personRepositoryImpl: PersonRepositoryImpl
    ): PersonRepository
}
