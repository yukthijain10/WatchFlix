package com.example.watchflix.ui.Adapter

import android.os.Bundle
import com.example.watchflix.R





import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.watchflix.network.Data.Result
import com.example.watchflix.network.Data.ResultX
import com.example.watchflix.network.Data.ResultXX


class Popularmovies(private val results:List<ResultX>): RecyclerView.Adapter<Popularmovies.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemarrangements, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w220_and_h330_face"+results.get(position).backdrop_path)
            .placeholder(R.mipmap.ic_launcher)
            .error(android.R.drawable.ic_menu_camera)
            .into(holder.imgView)
        var bundle1 = Bundle()
        val poster = results.get(position).poster_path
        val title = results.get(position).original_title
        val overview = results.get(position).overview
        val rating = results.get(position).vote_average
        val releasedate=results.get(position).release_date

        holder.imgView.setOnClickListener {
            bundle1.putString("poster", poster)
            bundle1.putString("title", title)
            bundle1.putString("overview", overview)
            bundle1.putDouble("rating", rating)
            bundle1.putString("date",releasedate)
            Navigation.findNavController(it).navigate(R.id.action_moviesHome_to_moviesDeatails,bundle1)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return 15
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imgView: ImageView = itemView.findViewById(R.id.image1)
    }

}

class Topratedmovies(private val results:List<Result>): RecyclerView.Adapter<Topratedmovies.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemarrangements, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w220_and_h330_face"+results.get(position).backdrop_path)
            .placeholder(R.mipmap.ic_launcher)
            .error(android.R.drawable.ic_menu_camera)
            .into(holder.imgView)
        holder.imgView.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_moviesHome_to_moviesDeatails)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return 15
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imgView: ImageView = itemView.findViewById(R.id.image1)
    }

}

class Upcomingmovies(private val results:List<ResultXX>): RecyclerView.Adapter<Upcomingmovies.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemarrangements, parent, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w220_and_h330_face"+results.get(position).backdrop_path)
            .placeholder(R.mipmap.ic_launcher)
            .error(android.R.drawable.ic_menu_camera)
            .into(holder.imgView)
        holder.imgView.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_moviesHome_to_moviesDeatails)
        }
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return 15
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imgView: ImageView = itemView.findViewById(R.id.image1)
    }

}

class myAdapter2: RecyclerView.Adapter<myAdapter2.ViewHolder2>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder2 {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemarrangements2, parent, false)

        return ViewHolder2(view)
    }


    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {
//        holder.imgView.setImageResource(R.drawable.yjhd)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return 15
    }

    // Holds the views for adding it to image and text
    class ViewHolder2(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imgView: ImageView = itemView.findViewById(R.id.imageView3)
    }

}



