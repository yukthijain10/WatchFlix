package com.example.watchflix.ui.fragments.moviesdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.watchflix.R
import com.example.watchflix.databinding.FragmentMoviesHomeBinding
import com.example.watchflix.network.Data.Result
import com.example.watchflix.network.Data.ResultX
import com.example.watchflix.network.Data.ResultXX
import com.example.watchflix.network.Data.Toprated
import com.example.watchflix.ui.Adapter.Popularmovies
import com.example.watchflix.ui.Adapter.Topratedmovies
import com.example.watchflix.ui.Adapter.Upcomingmovies
import com.example.watchflix.viewmodel.CustomViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [MoviesHome.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoviesHome : Fragment() {
    lateinit var binding: FragmentMoviesHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies_home, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewmodel:CustomViewModel= ViewModelProvider(this).get(CustomViewModel::class.java)
        viewmodel.getdataFromPopularApi()
        viewmodel.popularMovies.observe(viewLifecycleOwner,{
            PopularRecycler(it)
        })

        viewmodel.getdataFromTopRatedApi()
        viewmodel.topRated.observe(viewLifecycleOwner,{
            TopratedRecycler(it)
        })
        viewmodel.getdataFromUpcomingApi()
        viewmodel.upcomingMovies.observe(viewLifecycleOwner,{
            UpcomingRecycler(it)
        })

    }

    fun PopularRecycler(results: List<ResultX>){
        binding.recyclerView2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,true)
        binding.recyclerView2.adapter=Popularmovies(results)
    }

    fun TopratedRecycler(results: List<Result>){
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,true)
       binding.recyclerView.adapter= Topratedmovies(results)
    }
    fun UpcomingRecycler(list: List<ResultXX>){
        binding.recyclerView3.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,true)
        binding.recyclerView3.adapter=Upcomingmovies(list)

    }

}



