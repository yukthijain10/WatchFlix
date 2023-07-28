package com.example.watchflix.ui.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.watchflix.ui.fragments.Categories
import com.example.watchflix.ui.fragments.Documentaries
import com.example.watchflix.ui.fragments.Movies
import com.example.watchflix.ui.fragments.TvSeries

class tabadapter(var context: Context, fm: FragmentManager, var totalTabs:Int) : FragmentPagerAdapter(fm) {
   override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Movies()
            }

            1 -> {
                TvSeries()
            }

            2 -> {
                Documentaries()
            }

            3 -> {
                Categories()
            }

            else -> getItem(position)
        }
    }

   override fun getCount(): Int {
        return totalTabs
    }
}