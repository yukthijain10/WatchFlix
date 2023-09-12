package com.example.watchflix.ui.fragments.moviesdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.watchflix.R
import com.example.watchflix.Util.Utilities.imgUrl
import com.example.watchflix.databinding.FragmentMoviesDeatailsBinding
import com.example.watchflix.network.Data.ResultX
import com.example.watchflix.repository.mainrepointerface
import com.example.watchflix.ui.Adapter.Popularmovies
import com.example.watchflix.viewmodel.CustomViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel


class MoviesDetails : Fragment() {

    lateinit var binding: FragmentMoviesDeatailsBinding
    private val viewmodel by viewModel<CustomViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                NavHostFragment.findNavController(this@MoviesDetails).navigateUp();
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner, onBackPressedCallback
        )

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_movies_deatails, container, false)
        val view=binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        lifecycleScope.launch(Dispatchers.IO) {
            viewmodel.popular.collect { popularList ->
                if (popularList != null) {
                    withContext(Dispatchers.Main) {
                        PopularRecycler(popularList)
                    }
                }
            }
        }


        var imgUrl = imgUrl+ arguments?.getString("poster")

        Glide.with(this).load(imgUrl).into(binding.img)
        binding.tenet.text=arguments?.getString("title")
        binding.textView7.text="${arguments?.getDouble("rating").toString()} ${arguments?.getString("date")}"
        binding.textView2.text=arguments?.getString("overview")

        binding.playbutton2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_moviesDeatails_to_movie_Video)
        }
    }

    fun PopularRecycler(results: List<ResultX>){
        binding.detailsrecy.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,true)
        val recycleAdapter = results.let{Popularmovies(it)}
        binding.detailsrecy.adapter = recycleAdapter
    }

}
