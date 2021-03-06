package com.skysoft.kindfilms.ui.main

import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import com.skysoft.kindfilms.domain.Movie

enum class ErrorCode {
    NO_INTERNET
}

class MainContract {
    interface View {
        fun getSupportFragmentManagerMainActivity(): FragmentManager
    }

    interface Presenter {
        fun attach(view: View)
        fun detach()
        fun onMovieClick(item: Movie)
        fun onContextMovieClick()
        fun onBottomNavigationClick(item: MenuItem): Boolean
        fun setClickedMovie(item: Movie)
        fun getClickedMovie(): Movie
    }
}