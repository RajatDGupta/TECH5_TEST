package com.tech5.test.tvshows.data.remote

import com.tech5.test.tvshows.data.remote.dto.TVShowResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface TvShowApi {

    @GET("trending/tv/day")
    suspend fun getTrendingTvShows(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ): TVShowResponseDTO

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ): TVShowResponseDTO
}
