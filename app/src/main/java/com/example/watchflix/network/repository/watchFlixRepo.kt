package com.example.watchflix.network.repository

import com.example.watchflix.network.Util.Utilities.API_KEY
import com.example.watchflix.network.ApiEndpoint
import com.example.watchflix.network.Data.Popular
import com.example.watchflix.network.Data.Toprated
import com.example.watchflix.network.Data.Upcoming
import retrofit2.Response

class watchFlixRepo(
    val api:ApiEndpoint
    ) : watchFlixRepoInterface {
    override suspend fun getPopular(): Response<Popular> =
        api.getPopular(API_KEY)
    override suspend fun getTopRated(): Response<Toprated> =
        api.getTopRated(API_KEY)
    override suspend fun getUpComing(): Response<Upcoming> =
        api.getUpComing(API_KEY)
}