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
import java.util.*

class ListMovieAdapter : RecyclerView.Adapter<ListMovieAdapter.ListMovieViewHolder>() {
    private var data: List<Movie> = ArrayList<Movie>()
    private lateinit var clickListener: onItemClickListener
    private lateinit var contextClickListener: onItemContextClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMovieViewHolder {
        return ListMovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false), this
        )
    }

    override fun getItemCount() = data.size

    fun getItem(position: Int) = data.get(position)
    fun getClickListener() = clickListener
    fun getContextClickListener() = contextClickListener

    fun setClickListener(clickListener: onItemClickListener) {
        this.clickListener = clickListener
    }

    fun setContextClickListener(contextClickListener: onItemContextClickListener) {
        this.contextClickListener = contextClickListener
    }

    fun setData(data: List<Movie>) {
        this.data = data
    }

    interface onItemClickListener {
        fun onItemClick(item: Movie?, position: Int)
    }

    interface onItemContextClickListener {
        fun onItemContextClick(v: View?, item: Movie?, position: Int): Boolean
    }

    override fun onBindViewHolder(holder: ListMovieViewHolder, position: Int) {
        holder.fillMovie(getItem(position))
    }

    class ListMovieViewHolder(itemView: View, adapter: ListMovieAdapter) :
        RecyclerView.ViewHolder(itemView) {
        private var bannerImageView = itemView.findViewById<ImageView>(R.id.banner_image_view)
        private var nameMovieTextView = itemView.findViewById<TextView>(R.id.name_movie_text_view)
        private var yearTextView = itemView.findViewById<TextView>(R.id.year_text_view)
        private var rankTextView = itemView.findViewById<TextView>(R.id.rank_text_view)

        init {

            itemView.setOnClickListener(View.OnClickListener {
                if (adapter.getClickListener() != null) {
                    adapter.getClickListener()
                        .onItemClick(adapter.getItem(adapterPosition), adapterPosition)
                }
            })
            itemView.setOnLongClickListener(View.OnLongClickListener {
                if (adapter.getContextClickListener() != null) {
                    adapter.getContextClickListener().onItemContextClick(
                        itemView,
                        adapter.getItem(adapterPosition),
                        adapterPosition
                    )
                } else {
                    false
                }
            })
        }

        fun fillMovie(movie: Movie) {
            nameMovieTextView.text = movie.getTitle()

            Glide
                .with(bannerImageView.context)
                .load(movie.getImageURL())
                .optionalCenterInside()
                .into(bannerImageView)
        }
    }
}