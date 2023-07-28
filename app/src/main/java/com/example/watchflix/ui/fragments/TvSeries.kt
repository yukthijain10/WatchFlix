package com.example.watchflix.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.watchflix.R


/**
 * A simple [Fragment] subclass.
 * Use the [TvSeries.newInstance] factory method to
 * create an instance of this fragment.
 */
class TvSeries : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tv_series, container, false)
    }



    }
