package com.tech5.test.tvshows.data.remote

import com.tech5.test.tvshows.data.remote.dto.TVShowResponseDTO
import com.tech5.test.tvshows.data.remote.dto.details.TVShowDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path
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

    @GET("tv/top_rated")
    suspend fun getTopRatedTvShows(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ): TVShowResponseDTO

    @GET("tv/airing_today")
    suspend fun getAiringTodayTvShows(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ): TVShowResponseDTO

    @GET("tv/{series_id}")
    suspend fun getTvShowDetails(
        @Path("series_id") seriesId: Int
    ): TVShowDetailDTO

    @GET("search/tv")
    suspend fun searchTvShows(
        @Query("query") query: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ): TVShowResponseDTO
}
