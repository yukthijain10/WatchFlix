package com.example.watchflix.ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.watchflix.R

class myAdapter2: RecyclerView.Adapter<myAdapter2.ViewHolder2> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder2 {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemarrangements2, parent, false)
        return ViewHolder2(itemView)
    }


    override fun onBindViewHolder(holder: ViewHolder2, position: Int) {
        holder.imgView.setImageResource(R.drawable.yjhd)
        holder.textView.setText("YJHD")
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return 9
    }

    // Holds the views for adding it to image and text
    class ViewHolder2(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView: ImageView = itemView.findViewById(R.id.imageView3)
        val textView: TextView = itemView.findViewById(R.id.textView5)

    }

}
