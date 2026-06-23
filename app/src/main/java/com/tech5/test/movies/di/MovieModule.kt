package com.tech5.test.movies.di

import com.tech5.test.movies.data.remote.MovieApi
import com.tech5.test.movies.data.repository.MovieRepositoryImpl
import com.tech5.test.movies.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class MovieModule {

    @Binds
    @ViewModelScoped
    abstract fun bindMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository

    companion object {
        @Provides
        @ViewModelScoped
        fun provideMovieApi(retrofit: Retrofit): MovieApi {
            return retrofit.create(MovieApi::class.java)
        }
    }
}
