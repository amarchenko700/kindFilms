package com.skysoft.kindfilms.ui.main

import android.os.Parcelable
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.domain.Movie
import com.skysoft.kindfilms.ui.bottomNavigationFragments.AboutFragment
import com.skysoft.kindfilms.ui.bottomNavigationFragments.ProfileFragment
import com.skysoft.kindfilms.ui.bottomNavigationFragments.SettingsFragment
import com.skysoft.kindfilms.ui.listMovie.ListMovieFragment
import kotlinx.android.parcel.Parcelize

@Parcelize
class MainPresenter: Parcelable, MainContract.Presenter {

    private var view: MainContract.View? = null
    private var idScreen = 0
    private lateinit var fragmentManager: FragmentManager
    private lateinit var clickedMovie: Movie

    companion object {
        private const val TAG_LIST_MOVIE_FRAGMENT = "TAG_LIST_MOVIE_FRAGMENT"
    }

    override fun attach(view: MainContract.View) {
        this.view = view
        this.fragmentManager = view.getSupportFragmentManagerMainActivity()
        openScreen()
    }

    fun openScreen(){
        when (idScreen){
            0 -> openPopularMovieList()
            1 -> openProfile()
            2 -> openSettings()
            3 -> openAboutApp()
        }
    }

    override fun detach() {
        this.view = null
    }

    override fun onMovieClick(item: Movie) {
        Toast.makeText((view as MainActivity), item?.getTitle(), Toast.LENGTH_SHORT).show()
    }

    override fun onContextMovieClick() {
        Toast.makeText((view as MainActivity), "Удаляем " + clickedMovie.getTitle(), Toast.LENGTH_SHORT).show()
    }

    override fun onBottomNavigationClick(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_home_bottom_navigation) {
            idScreen = 0
        } else if (item.itemId == R.id.item_profile_bottom_navigation) {
            idScreen = 1
        } else if (item.itemId == R.id.item_settings_bottom_navigation) {
            idScreen = 2
        } else if (item.itemId == R.id.item_about_bottom_navigation) {
            idScreen = 3
        }
        openScreen()
        return true
    }

    override fun setClickedMovie(item: Movie) {
        this.clickedMovie = item
    }

    override fun getClickedMovie(): Movie {
        return clickedMovie
    }

    private fun openProfile() {
        fragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, ProfileFragment())
            .commit()
    }

    private fun openSettings() {
        fragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, SettingsFragment())
            .commit()
    }

    private fun openAboutApp() {
        fragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, AboutFragment())
            .commit()
    }

    private fun openPopularMovieList() {
        var existingListMovieFragment = fragmentManager.findFragmentByTag(TAG_LIST_MOVIE_FRAGMENT)
        if(existingListMovieFragment == null){
            existingListMovieFragment = ListMovieFragment()
        }

        fragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, existingListMovieFragment, TAG_LIST_MOVIE_FRAGMENT)
            .commit()
    }

}