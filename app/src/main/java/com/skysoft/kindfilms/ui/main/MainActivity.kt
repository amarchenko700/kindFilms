package com.skysoft.kindfilms.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.skysoft.kindfilms.R
import com.skysoft.kindfilms.databinding.ActivityMainBinding
import com.skysoft.kindfilms.domain.MoviesRepo
import com.skysoft.kindfilms.ui.listMovie.ListMovieFragment
import com.skysoft.kindfilms.ui.movie.MovieFragment

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var presenter: MainContract.Presenter
    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter()
        presenter.attach(this)

        var repo = MoviesRepo
        fragmentManager = supportFragmentManager
        fragmentManager
            .beginTransaction()
            .replace(R.id.list_movie_container, ListMovieFragment())
            .commit()
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun showError(errorCode: ErrorCode) {
        Toast.makeText(baseContext, errorCode.toString(), Toast.LENGTH_LONG).show()
    }

    private fun ErrorCode.toString(): String{
        return when (this){
            ErrorCode.NO_INTERNET -> getString(R.string.error_no_internet)
            else -> getString(R.string.unknown_error)
        }
    }

}

