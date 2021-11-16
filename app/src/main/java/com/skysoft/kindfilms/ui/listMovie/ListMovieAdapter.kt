package com.skysoft.kindfilms.ui.listMovie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.domain.Movie
import java.util.ArrayList

class ListMovieAdapter: RecyclerView.Adapter<ListMovieAdapter.ListMovieViewHolder>() {
    private var data: List<Movie> = ArrayList<Movie>()
    private lateinit var clickListener: ListMovieAdapter.onItemClickListener
    private var contextClickListener: onItemContextClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMovieViewHolder {
        return ListMovieViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_movie, parent, false), this)
    }

    override fun getItemCount() = data.size

    fun getItem(position: Int) = data.get(position)
    fun getClickListener() = clickListener

    fun setClickListener(clickListener: onItemClickListener){
        this.clickListener = clickListener
    }

    fun setData(data: List<Movie>){
        this.data = data
    }

    interface onItemClickListener {
        fun onItemClick(item: Movie?, position: Int)
    }

    interface onItemContextClickListener {
        fun onItemContextClick(v: View?, item: Movie?, position: Int): Boolean
    }

    class ListMovieViewHolder(itemView: View, adapter: ListMovieAdapter) : RecyclerView.ViewHolder(itemView) {
        private var bannerImageView = itemView.findViewById<ImageView>(R.id.banner_image_view)
        private var nameMovieTextView = itemView.findViewById<TextView>(R.id.name_movie_text_view)
        private var yearTextView = itemView.findViewById<TextView>(R.id.year_text_view)
        private var rankTextView = itemView.findViewById<TextView>(R.id.rank_text_view)

        init {
            itemView.setOnClickListener(View.OnClickListener { v -> onClick(adapterPosition, 10) })
            itemView.setOnClickListener(View.OnClickListener {
                fun onClick(it: View){
                    if(adapter.getClickListener() != null){
                        adapter.getClickListener().onItemClick(adapter.getItem(adapterPosition), adapterPosition)
                    }
                }
            })
        }

        fun onClick(position: Int, f: Int) {
            var g = 5
        }

        fun fillMovie(movie: Movie){
            nameMovieTextView.setText(movie.getTitle())

            Glide
                .with(bannerImageView.context)
                .load(movie.getImageURL())
                .optionalCenterInside()
                .into(bannerImageView)
        }
    }

    override fun onBindViewHolder(holder: ListMovieViewHolder, position: Int) {
        holder.fillMovie(getItem(position))
    }
}