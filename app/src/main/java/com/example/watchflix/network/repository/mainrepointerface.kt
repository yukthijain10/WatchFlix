package com.example.watchflix.network.repository

import com.example.watchflix.network.Data.Popular
import com.example.watchflix.network.Data.Toprated
import com.example.watchflix.network.Data.Upcoming
import retrofit2.Response

interface mainrepointerface {
    suspend fun getPopular() : Response<Popular>
    suspend fun getTopRated() : Response<Toprated>
    suspend fun getUpComing() : Response<Upcoming>
}