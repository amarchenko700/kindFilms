package com.skysoft.kindfilms.ui.main

import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.databinding.ActivityMainBinding

import com.google.android.material.tabs.TabLayout

import com.skysoft.kindfilms.ui.SampleFragmentPagerAdapter

import androidx.viewpager.widget.ViewPager




class MainActivity : AppCompatActivity(), MainContract.View {

    private val KEY_PRESENTER = "KEY_PRESENTER"
    private lateinit var presenter: MainPresenter
    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentManager = supportFragmentManager

        initBottomNavigation()

        if (savedInstanceState == null) {
            presenter = MainPresenter()
        } else {
            presenter = savedInstanceState.getParcelable<MainPresenter>(KEY_PRESENTER)!!
        }
        presenter.attach(this)

    }

    override fun getSupportFragmentManagerMainActivity(): FragmentManager {
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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_PRESENTER, presenter)
    }

}

