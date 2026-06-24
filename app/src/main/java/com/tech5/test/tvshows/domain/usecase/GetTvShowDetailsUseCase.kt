package com.tech5.test.tvshows.domain.usecase

import com.tech5.test.tvshows.domain.model.TvShowDetails
import com.tech5.test.tvshows.domain.repository.TvShowRepository
import javax.inject.Inject

class GetTvShowDetailsUseCase @Inject constructor(
    private val repository: TvShowRepository
) {
    suspend operator fun invoke(seriesId: Int): TvShowDetails {
        return repository.getTvShowDetails(seriesId)
    }
}
