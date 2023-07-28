package com.example.watchflix.network

import com.example.watchflix.network.Data.Popular
import com.example.watchflix.network.Data.Toprated
import com.example.watchflix.network.Data.Upcoming
import retrofit2.Response
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("popular?api_key=56c49c7050604cbba16a4c9c84594633")
    suspend fun getPopular(): Response<Popular>

    @GET("top_rated?api_key=56c49c7050604cbba16a4c9c84594633")
    suspend fun getTopRated(): Response<Toprated>

    @GET("upcoming?api_key=56c49c7050604cbba16a4c9c84594633")
    suspend fun getUpComing(): Response<Upcoming>

}