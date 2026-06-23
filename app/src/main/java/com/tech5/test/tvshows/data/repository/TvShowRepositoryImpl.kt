package com.tech5.test.tvshows.data.repository

import com.tech5.test.tvshows.domain.model.TvShow
import com.tech5.test.tvshows.domain.repository.TvShowRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@ViewModelScoped
class TvShowRepositoryImpl @Inject constructor() : TvShowRepository {
    override fun getTvShows(): Flow<List<TvShow>> = flow {
        // Mock data
        emit(
            listOf(
                TvShow(1, "TV Show 1", "Overview 1", null),
                TvShow(2, "TV Show 2", "Overview 2", null)
            )
        )
    }
}
