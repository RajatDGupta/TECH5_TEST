package com.tech5.test.people.data.remote

import com.tech5.test.people.data.remote.dto.PersonResponseDTO
import retrofit2.http.GET

interface PersonApi{

    @GET("person/popular")
    suspend fun getPopularPeople(
        @retrofit2.http.Query("page") page: Int
    ): PersonResponseDTO

}