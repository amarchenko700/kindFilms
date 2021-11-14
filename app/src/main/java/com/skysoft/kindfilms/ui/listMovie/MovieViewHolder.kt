package com.skysoft.kindfilms.ui.listMovie

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.skysoft.kindfilms.R

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var bannerImageView = itemView.findViewById<ImageView>(R.id.banner_image_view)
    var nameMovieTextView = itemView.findViewById<TextView>(R.id.name_movie_text_view)
    var yearTextView = itemView.findViewById<TextView>(R.id.year_text_view)
    var rankTextView = itemView.findViewById<TextView>(R.id.rank_text_view)
}
