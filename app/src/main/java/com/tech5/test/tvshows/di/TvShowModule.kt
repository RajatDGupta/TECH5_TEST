package com.tech5.test.tvshows.di

import com.tech5.test.tvshows.data.repository.TvShowRepositoryImpl
import com.tech5.test.tvshows.domain.repository.TvShowRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class TvShowModule {

    @Binds
    @ViewModelScoped
    abstract fun bindTvShowRepository(
        tvShowRepositoryImpl: TvShowRepositoryImpl
    ): TvShowRepository
}
