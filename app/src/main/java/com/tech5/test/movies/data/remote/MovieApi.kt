package com.tech5.test.movies.data.remote

import com.tech5.test.movies.data.remote.dto.MoviesResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("trending/movie/day")
    suspend fun getTrendingMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ): MoviesResponseDTO

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ): MoviesResponseDTO

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ): MoviesResponseDTO

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ): MoviesResponseDTO
}
