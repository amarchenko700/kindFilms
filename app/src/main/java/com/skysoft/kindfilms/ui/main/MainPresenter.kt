package com.skysoft.kindfilms.ui.main

import android.os.Parcelable
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.domain.Movie
import com.skysoft.kindfilms.ui.bottomNavigationFragments.AboutFragment
import com.skysoft.kindfilms.ui.bottomNavigationFragments.ProfileFragment
import com.skysoft.kindfilms.ui.bottomNavigationFragments.SettingsFragment
import com.skysoft.kindfilms.ui.listMovie.ListMovieFragment
import com.skysoft.kindfilms.ui.movie.CardMovieFragment
import kotlinx.android.parcel.Parcelize

@Parcelize
class MainPresenter : Parcelable, MainContract.Presenter {

    private var view: MainContract.View? = null
    private var idScreen = 0
    private lateinit var fragmentManager: FragmentManager
    private lateinit var clickedMovie: Movie

    companion object {
        private const val TAG_LIST_MOVIE_FRAGMENT = "TAG_LIST_MOVIE_FRAGMENT"
        private const val TAG_ABOUT_FRAGMENT = "TAG_ABOUT_FRAGMENT"
        private const val TAG_PROFILE_FRAGMENT = "TAG_PROFILE_FRAGMENT"
        private const val TAG_SETTINGS_FRAGMENT = "TAG_SETTINGS_FRAGMENT"
        private const val TAG_CARD_MOVIE_FRAGMENT = "TAG_CARD_MOVIE_FRAGMENT"
    }

    override fun attach(view: MainContract.View) {
        this.view = view
        this.fragmentManager = view.getSupportFragmentManagerMainActivity()
        openScreen()
    }

    override fun detach() {
        this.view = null
    }

    fun openScreen() {
        when (idScreen) {
            0 -> openFragment(ListMovieFragment(), TAG_LIST_MOVIE_FRAGMENT)
            1 -> openFragment(ProfileFragment(), TAG_PROFILE_FRAGMENT)
            2 -> openFragment(SettingsFragment(), TAG_SETTINGS_FRAGMENT)
            3 -> openFragment(AboutFragment(), TAG_ABOUT_FRAGMENT)
        }
    }

    override fun onMovieClick(item: Movie) {
        openFragment(CardMovieFragment(item), TAG_CARD_MOVIE_FRAGMENT, true)
        Toast.makeText((view as MainActivity), item.getTitle(), Toast.LENGTH_SHORT).show()
    }

    override fun onContextMovieClick() {
        Toast.makeText(
            (view as MainActivity),
            "Удаляем " + clickedMovie.getTitle(),
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onBottomNavigationClick(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item_home_bottom_navigation -> idScreen = 0
            R.id.item_profile_bottom_navigation -> idScreen = 1
            R.id.item_settings_bottom_navigation -> idScreen = 2
            R.id.item_about_bottom_navigation -> idScreen = 3
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

    private fun openFragment(fragment: Fragment, tag: String, addToBackStack : Boolean = false) {
        var fragmentToOpen = fragmentManager.findFragmentByTag(tag)
        if (fragmentToOpen == null) {
            fragmentToOpen = fragment
        }
        if(addToBackStack){
        fragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragmentToOpen, tag)
            .addToBackStack(null)
            .commit()
        }else{
            fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragmentToOpen, tag)
                .commit()
        }
    }
}