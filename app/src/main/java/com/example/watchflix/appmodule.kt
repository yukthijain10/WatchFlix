package com.example.watchflix


import com.example.watchflix.network.Util.Utilities.baseUrl
import com.example.watchflix.network.ApiEndpoint
import com.example.watchflix.network.repository.mainrepo
import com.example.watchflix.network.repository.mainrepointerface
import com.example.watchflix.viewmodel.CustomViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appmodule = module {
    single{
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiEndpoint::class.java)
    }
    single <mainrepointerface>{
        mainrepo(get())
    }
    viewModel {
        CustomViewModel(get())
    }
}