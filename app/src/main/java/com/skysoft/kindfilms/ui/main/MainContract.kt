package com.skysoft.kindfilms.ui.main

import com.skysoft.kindfilms.domain.Movie

enum class ErrorCode{
    NO_INTERNET
}

class MainContract {
    interface View{
        fun showError(errorCode: ErrorCode)

    }

    interface Presenter{
        fun attach(view: View)
        fun detach()
        fun onMovieClick(item: Movie)
    }
}