package com.skysoft.kindfilms.domain

import java.util.ArrayList

object MoviesRepo {
    private val cache = mutableListOf<Movie>()

    init{
        cache.add(Movie("Какое-то описание 1"))
        cache.add(Movie( "Какое-то описание 2"))
        cache.add(Movie("Какое-то описание 3"))
        cache.add(Movie("Какое-то описание 4"))
    }

    fun getMovies(): List<Movie?>? {
        return ArrayList<Movie?>(cache)
    }
}