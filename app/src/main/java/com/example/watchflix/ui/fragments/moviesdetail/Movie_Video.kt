package com.example.watchflix.ui.fragments.moviesdetail

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.watchflix.R
import com.example.watchflix.databinding.MovieVideoBinding
class Movie_Video : Fragment() {
    lateinit var binding: MovieVideoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                NavHostFragment.findNavController(this@Movie_Video).navigateUp();
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner, onBackPressedCallback
        )
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.movie__video,
            container,
            false
        )   // for fragments
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var url =
            "https://zee-demo.s3.ap-south-1.amazonaws.com/Mission_+Impossible+%E2%80%93+Dead+Reckoning+Part+One+_+Official+Trailer+(2023+Movie)+-+Tom+Cruise.mp4"
        var uri: Uri = Uri.parse(url)
        binding.video.setVideoURI(uri)
        val mediaController = MediaController(context)
        mediaController.setAnchorView(binding.video)
        mediaController.setMediaPlayer(binding.video)
        binding.video.setMediaController(mediaController)
        binding.video.start()
    }
}