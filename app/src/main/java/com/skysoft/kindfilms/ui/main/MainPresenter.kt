package com.skysoft.kindfilms.ui.main

import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.domain.Movie
import com.skysoft.kindfilms.ui.bottomNavigationFragments.AboutFragment
import com.skysoft.kindfilms.ui.bottomNavigationFragments.ProfileFragment
import com.skysoft.kindfilms.ui.bottomNavigationFragments.SettingsFragment
import com.skysoft.kindfilms.ui.listMovie.ListMovieFragment

class MainPresenter: MainContract.Presenter {

    private var view: MainContract.View? = null
    private lateinit var fragmentManager: FragmentManager

    override fun attach(view: MainContract.View) {
        this.view = view
        fragmentManager = view.getSupportFragmentManagerMainActivity()
        openPopularMovieList()
    }

    override fun detach() {
        this.view = null
    }

    override fun onMovieClick(item: Movie) {
        TODO("Not yet implemented")
    }

    override fun onBottomNavigationClick(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_home_bottom_navigation) {
            openPopularMovieList()
        } else if (item.itemId == R.id.item_profile_bottom_navigation) {
            openProfile()
        } else if (item.itemId == R.id.item_settings_bottom_navigation) {
            openSettings()
        } else if (item.itemId == R.id.item_about_bottom_navigation) {
            openAboutApp()
        }
        return true
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
        fragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, ListMovieFragment())
            .commit()
    }
}