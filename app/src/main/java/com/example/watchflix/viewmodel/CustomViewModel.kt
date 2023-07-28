package com.example.watchflix.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.watchflix.network.Retrofithelper
import com.example.watchflix.network.Data.Popular
import com.example.watchflix.network.Data.Result
import com.example.watchflix.network.Data.ResultX
import com.example.watchflix.network.Data.ResultXX
import com.example.watchflix.network.Data.Toprated
import com.example.watchflix.network.Data.Upcoming
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CustomViewModel : ViewModel() {

    private var popular = MutableLiveData<List<com.example.watchflix.network.Data.ResultX>>()
    val popularMovies : LiveData<List<ResultX>>
        get()= popular
    fun getdataFromPopularApi() {
        GlobalScope.launch(Dispatchers.IO) {
            val result = Retrofithelper.getInstance1.getPopular()
            if (result != null) {
                val popular_movies: Popular ?= result.body()
                popular.postValue (popular_movies?.results)
            }
        }
    }

    private var toprated = MutableLiveData<List<com.example.watchflix.network.Data.Result>>()
    val topRated : LiveData<List<Result>>
        get()= toprated
    fun getdataFromTopRatedApi() {
        GlobalScope.launch(Dispatchers.IO) {
            val result = Retrofithelper.getInstance1.getTopRated()
            if (result != null) {
                val toprated_movies: Toprated?= result.body()
                toprated.postValue (toprated_movies?.results)
            }
        }
    }

    private var upcoming = MutableLiveData<List<com.example.watchflix.network.Data.ResultXX>>()
    val upcomingMovies : LiveData<List<ResultXX>>
        get()= upcoming
    fun getdataFromUpcomingApi() {
        GlobalScope.launch(Dispatchers.IO) {
            val result = Retrofithelper.getInstance1.getUpComing()
            if (result != null) {
//                Log.d("Api response",result.body().toString())
                val upcoming_movies: Upcoming ?= result.body()
                upcoming.postValue(upcoming_movies?.results)
            }
        }
    }

}
