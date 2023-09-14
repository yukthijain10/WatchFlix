package com.example.watchflix.ui.fragments.moviesdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.bumptech.glide.Glide

import com.example.watchflix.R
import com.example.watchflix.network.Util.Utilities.imgUrl
import com.example.watchflix.databinding.FragmentMoviesDeatailsBinding
import com.example.watchflix.viewmodel.watchFlixViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MoviesDetails : Fragment() {
    lateinit var binding: FragmentMoviesDeatailsBinding
    private val viewmodel by viewModel<watchFlixViewModel>()
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
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_movies_deatails, container, false)
        val view = binding.root
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var imgUrl = imgUrl + arguments?.getString("poster")
        Glide.with(this).load(imgUrl).into(binding.img)
        binding.tenet.text = arguments?.getString("title")
        binding.textView7.text =
            "${arguments?.getDouble("rating").toString()} ${arguments?.getString("date")}"
        binding.textView2.text = arguments?.getString("overview")

        binding.playbutton2.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_moviesDeatails_to_movie_Video)
        }
    }

}
