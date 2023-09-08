package com.example.watchflix.network

import com.example.watchflix.Util.Utilities.baseUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object Retrofithelper {

    val getInstance1 : ApiEndpoint by lazy {
        Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiEndpoint::class.java)
    }
}