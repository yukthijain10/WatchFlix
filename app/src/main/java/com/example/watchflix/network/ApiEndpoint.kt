package com.example.watchflix.network

import com.example.watchflix.network.Data.Popular
import com.example.watchflix.network.Data.Toprated
import com.example.watchflix.network.Data.Upcoming
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiEndpoint {
    @GET("popular")
    suspend fun getPopular(
        @Query("api_key") apiKey:String
    ): Response<Popular>

    @GET("top_rated")
    suspend fun getTopRated(
        @Query("api_key") apiKey:String
    ): Response<Toprated>

    @GET("upcoming")
    suspend fun getUpComing(
        @Query("api_key") apiKey:String
    ): Response<Upcoming>

}