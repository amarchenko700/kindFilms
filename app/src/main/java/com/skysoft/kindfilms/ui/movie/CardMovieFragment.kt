package com.skysoft.kindfilms.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.databinding.FragmentCardMovieBinding
import com.skysoft.kindfilms.databinding.FragmentTabMoviesBinding
import com.skysoft.kindfilms.domain.Movie

class CardMovieFragment (movie: Movie) : Fragment() {

    private lateinit var binding: FragmentCardMovieBinding
    private var movie: Movie

    init {
        this.movie = movie
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillCardMovie(movie)
    }

    fun fillCardMovie(movie: Movie){
        binding.cardMovieTitleTextView.setText(movie.getTitle())

        Glide
            .with(binding.cardMovieBannerImageView.context)
            .load(movie.getImageURL())
            .optionalCenterInside()
            .into(binding.cardMovieBannerImageView)
    }

}