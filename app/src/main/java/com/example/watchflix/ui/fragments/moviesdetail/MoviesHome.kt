package com.example.watchflix.ui.fragments.moviesdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.watchflix.R
import com.example.watchflix.databinding.FragmentMoviesHomeBinding
import com.example.watchflix.network.Data.Result
import com.example.watchflix.network.Data.ResultX
import com.example.watchflix.network.Data.ResultXX
import com.example.watchflix.ui.Adapter.Popularmovies
import com.example.watchflix.ui.Adapter.Topratedmovies
import com.example.watchflix.ui.Adapter.Upcomingmovies
import com.example.watchflix.viewmodel.CustomViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class MoviesHome : Fragment() {
    lateinit var binding: FragmentMoviesHomeBinding
    private val viewmodel by viewModel<CustomViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies_home, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch() {
            viewmodel.popularlist.collect{
                it?.let{
                    PopularRecycler(it)
                }
            }
        }

        lifecycleScope.launch() {
            viewmodel.toplist.collect{
                it?.let{
                    TopratedRecycler(it)
                }
            }
        }
        lifecycleScope.launch() {
            viewmodel.uplist.collect{
                it?.let{
                    UpcomingRecycler(it)
                }
            }
        }
    }
        fun PopularRecycler(results: List<ResultX>) {
            binding.recyclerView2.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.recyclerView2.adapter =  Popularmovies(results)
        }

        fun TopratedRecycler(results: List<Result>) {
            binding.recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            binding.recyclerView.adapter = results.let { Topratedmovies(it) }
        }

        fun UpcomingRecycler(results: List<ResultXX>) {
            binding.recyclerView3.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, true)
            binding.recyclerView3.adapter = results.let { Upcomingmovies(it) }

        }

    }




