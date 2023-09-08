package com.example.watchflix.repository

import androidx.lifecycle.viewModelScope
import com.example.watchflix.Util.Utilities.API_KEY
import com.example.watchflix.network.ApiEndpoint
import com.example.watchflix.network.Data.Popular
import com.example.watchflix.network.Data.Toprated
import com.example.watchflix.network.Data.Upcoming
import com.example.watchflix.network.Retrofithelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class mainrepo(
    val api:ApiEndpoint
    ) : mainrepointerface {
    override suspend fun getPopular(): Response<Popular> =
    api.getPopular(API_KEY)

    override suspend fun getTopRated(): Response<Toprated> =
    api.getTopRated(API_KEY)


    override suspend fun getUpComing(): Response<Upcoming> =
        api.getUpComing(API_KEY)



}