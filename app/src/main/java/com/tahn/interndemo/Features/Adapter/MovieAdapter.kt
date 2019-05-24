package com.tahn.interndemo.Features.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.tahn.interndemo.Model.Movie
import com.tahn.interndemo.R

class MovieAdapter(private val listMovies: ArrayList<Movie>, private val clickListener : (Movie?) -> Unit): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.recycleview_item_row, p0, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(listMovies[p1], clickListener)
    }

    //could using bind function
    inner class ViewHolder (itemView : View): RecyclerView.ViewHolder(itemView){
        private val textViewName = itemView.findViewById(R.id.textViewName) as TextView
        private val textViewDesc = itemView.findViewById(R.id.textViewDesc) as TextView
        private val imageView = itemView.findViewById(R.id.imageView) as ImageView
        private val isHighRated = itemView.findViewById(R.id.hasTopRated) as ImageView

        fun bind(movie : Movie?, clickListener: (Movie?) -> Unit){
            textViewName.text = movie?.title
            textViewDesc.text = movie?.overview
            Glide.with(imageView).load("https://image.tmdb.org/t/p/w500" + "${movie?.poster}")
                .apply(RequestOptions.bitmapTransform(RoundedCorners(60)))
                .into(imageView)

            if (movie?.vote_average!!.toFloat() <= 7){
                isHighRated.visibility = View.INVISIBLE
            }
            //set click event listener
            itemView.setOnClickListener{clickListener(movie)}
        }
    }
}