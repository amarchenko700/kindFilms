package com.skysoft.kindfilms.ui.main

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.databinding.ActivityMainBinding
import com.skysoft.kindfilms.ui.bottomNavigationFragments.AboutFragment
import com.skysoft.kindfilms.ui.bottomNavigationFragments.ProfileFragment
import com.skysoft.kindfilms.ui.bottomNavigationFragments.SettingsFragment
import com.skysoft.kindfilms.ui.listMovie.ListMovieFragment

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var presenter: MainContract.Presenter
    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
        fragmentManager = supportFragmentManager

        presenter = MainPresenter()
        presenter.attach(this)
    }

    override fun getSupportFragmentManagerMainActivity(): FragmentManager{
        return fragmentManager
    }

    private fun initBottomNavigation() {
        binding.bottomNavigationMenu.setOnItemSelectedListener {
            return@setOnItemSelectedListener presenter.onBottomNavigationClick(it)
        }
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun showError(errorCode: ErrorCode) {
        Toast.makeText(baseContext, errorCode.toString(), Toast.LENGTH_LONG).show()
    }

    private fun ErrorCode.toString(): String {
        return when (this) {
            ErrorCode.NO_INTERNET -> getString(R.string.error_no_internet)
            else -> getString(R.string.unknown_error)
        }
    }

}

