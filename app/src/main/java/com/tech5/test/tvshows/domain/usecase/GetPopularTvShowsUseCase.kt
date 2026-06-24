package com.tech5.test.tvshows.domain.usecase

import androidx.paging.PagingData
import com.tech5.test.tvshows.domain.model.TvShow
import com.tech5.test.tvshows.domain.repository.TvShowRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPopularTvShowsUseCase @Inject constructor(
    private val repository: TvShowRepository
) {
    operator fun invoke(): Flow<PagingData<TvShow>> {
        return repository.getPopularTvShows()
    }
}
