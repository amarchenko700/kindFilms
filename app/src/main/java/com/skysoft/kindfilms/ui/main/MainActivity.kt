package com.skysoft.kindfilms.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.skysoft.kindfilms.databinding.ActivityMainBinding

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
            presenter.onBottomNavigationClick(it)
        }
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_PRESENTER, presenter)
    }

    fun getPresenter(): MainPresenter {
        return presenter
    }

}

