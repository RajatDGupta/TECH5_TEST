package com.tech5.test.movies.data.remote

import com.tech5.test.movies.data.remote.dto.TrendingMoviesResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("trending/movie/day")
    suspend fun getTrendingMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ): TrendingMoviesResponseDTO
}
