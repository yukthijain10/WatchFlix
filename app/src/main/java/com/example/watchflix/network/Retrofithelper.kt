package com.example.watchflix.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object Retrofithelper {
    val baseUrl="https://api.themoviedb.org/3/movie/"
    val getInstance1 : ApiEndpoint by lazy {
        Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiEndpoint::class.java)
    }
}