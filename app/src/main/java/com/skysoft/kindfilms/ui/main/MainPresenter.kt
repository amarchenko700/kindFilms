package com.skysoft.kindfilms.ui.main

import com.skysoft.kindfilms.domain.Movie

class MainPresenter: MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun attach(view: MainContract.View) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }

    override fun onMovieClick(item: Movie) {
        TODO("Not yet implemented")
    }
}