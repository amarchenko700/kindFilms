package com.skysoft.kindfilms.ui.listMovie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.domain.Movie
import java.util.ArrayList

class ListMovieAdapter: RecyclerView.Adapter<MovieViewHolder>() {
    private var data: List<Movie> = ArrayList<Movie>()
    private var clickListener: onItemClickListener? = null
    private var contextClickListener: onItemContextClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.nameMovieTextView.setText(movie.getTitle())
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun getItem(position: Int): Movie{
        return data.get(position)
    }

    fun setData(data: List<Movie>){
        this.data = data
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        clickListener = listener
    }

    fun setOnItemContextClickListener(contextListener: onItemContextClickListener) {
        contextClickListener = contextListener
    }

    interface onItemClickListener {
        fun onItemClick(item: Movie?, position: Int)
    }

    interface onItemContextClickListener {
        fun onItemContextClick(v: View?, item: Movie?, position: Int): Boolean
    }
}