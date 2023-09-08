package com.example.watchflix.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.watchflix.R
import com.example.watchflix.databinding.CategoriesBinding

import com.example.watchflix.ui.Adapter.myAdapter2

/**
 * A simple [Fragment] subclass.
 * Use the [Categories.newInstance] factory method to
 * create an instance of this fragment.
 */
class Categories : Fragment() {

    private lateinit var binding: CategoriesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        /*val view= inflater.inflate(R.layout.categories, container, false)
        return view*/
        binding = CategoriesBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler =view.findViewById<RecyclerView>(R.id.categoryrecy)
        recycler.layoutManager=GridLayoutManager(context,3)
        val recycleadapter = myAdapter2()
        recycler.adapter= recycleadapter
    }

}