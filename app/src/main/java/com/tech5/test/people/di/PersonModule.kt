package com.tech5.test.people.di

import com.tech5.test.movies.data.remote.MovieApi
import com.tech5.test.people.data.remote.PersonApi
import com.tech5.test.people.data.repository.PersonRepositoryImpl
import com.tech5.test.people.domain.repository.PersonRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class PersonModule {

    @Binds
    @ViewModelScoped
    abstract fun bindPersonRepository(
        personRepositoryImpl: PersonRepositoryImpl
    ): PersonRepository

    companion object {
        @Provides
        @ViewModelScoped
        fun providePersonApi(retrofit: Retrofit): PersonApi {
            return retrofit.create(PersonApi::class.java)
        }
    }
}
