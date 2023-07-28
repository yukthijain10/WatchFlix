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
import com.bumptech.glide.Glide

import com.example.watchflix.R
import com.example.watchflix.databinding.FragmentMoviesDeatailsBinding
import com.example.watchflix.network.Data.ResultX
import com.example.watchflix.ui.Adapter.Popularmovies
import com.example.watchflix.viewmodel.CustomViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [MoviesDetails.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoviesDetails : Fragment() {

    lateinit var binding: FragmentMoviesDeatailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_movies_deatails, container, false)
        val view=binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewmodel: CustomViewModel = ViewModelProvider(this).get(CustomViewModel::class.java)
        viewmodel.getdataFromPopularApi()
        viewmodel.getdataFromUpcomingApi()
        viewmodel.popularMovies.observe(viewLifecycleOwner,{
            PopularRecycler(it)
        })

        binding.morelikethis.text=arguments?.getString("title")
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w220_and_h330_face"+arguments?.getString("poster"))


            .into(binding.img)
        binding.textView7.text="${arguments?.getDouble("rating").toString()} ${arguments?.getString("date")}"
        binding.textView2.text=arguments?.getString("overview")


    }

    fun PopularRecycler(results: List<ResultX>){
        binding.detailsrecy.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,true)
        binding.detailsrecy.adapter=Popularmovies(results)
    }

}
