package com.skysoft.kindfilms.ui.main

import android.os.Parcelable
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.FragmentManager
import com.skysoft.kindfilms.domain.Movie
import kotlinx.android.parcel.Parcelize

enum class ErrorCode{
    NO_INTERNET
}

class MainContract {
    interface View{
        fun showError(errorCode: ErrorCode)
        fun getSupportFragmentManagerMainActivity(): FragmentManager
    }

    interface Presenter{
        fun attach(view: View)
        fun detach()
        fun onMovieClick(item: Movie)
        fun onContextMovieClick()
        fun onBottomNavigationClick(item: MenuItem): Boolean
        fun setClickedMovie(item: Movie)
        fun getClickedMovie(): Movie
    }
}