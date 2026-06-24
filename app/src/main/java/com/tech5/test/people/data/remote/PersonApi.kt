package com.tech5.test.people.data.remote

import com.tech5.test.people.data.remote.dto.PersonResponseDTO
import retrofit2.http.GET

interface PersonApi{

    @GET("person/popular")
    suspend fun getPopularPeople(
        @retrofit2.http.Query("page") page: Int
    ): PersonResponseDTO

    @retrofit2.http.GET("search/person")
    suspend fun searchPeople(
        @retrofit2.http.Query("query") query: String,
        @retrofit2.http.Query("language") language: String = "en-US",
        @retrofit2.http.Query("page") page: Int = 1
    ): PersonResponseDTO

}