package com.skysoft.kindfilms.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.skysoft.kindfilms.databinding.FragmentCardMovieBinding
import com.skysoft.kindfilms.domain.Movie

class CardMovieFragment() : Fragment() {

    private lateinit var binding: FragmentCardMovieBinding
    private lateinit var movie: Movie

    constructor(movie: Movie) : this() {
        this.movie = movie
    }

    fun setMovie(movie: Movie){
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

    fun fillCardMovie(movie: Movie) {
        binding.cardMovieTitleTextView.setText(movie.getTitle())
        binding.cardMovieYearTextView.setText(movie.getReleaseYear())
        binding.cardMovieBudgetTextView.setText(movie.getBudget().toString())
        binding.cardMovieGenresTextView.setText(movie.getGenresString())
        binding.cardMovieRuntimeTextView.setText(movie.getRunTime().toString())
        binding.cardMovieCountryTextView.setText(movie.getCountry().name)
        binding.cardMovieStatusTextView.setText(movie.getStatus().synonym)
        binding.cardMovieOverviewTextView.setText(movie.getOverview())
        binding.cardMovieRateTextView.setText(movie.getVoteAverage().toString())
        binding.cardMovieBannerImageView.load(movie.getImageURL())
//        Glide
//            .with(binding.cardMovieBannerImageView.context)
//            .load(movie.getImageURL())
//            .optionalCenterInside()
//            .diskCacheStrategy(DiskCacheStrategy.NONE)
//            .skipMemoryCache(true)
//            .into(binding.cardMovieBannerImageView)
    }
}