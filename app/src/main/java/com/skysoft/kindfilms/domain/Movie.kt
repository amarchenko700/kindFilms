package com.skysoft.kindfilms.domain

import android.icu.text.CaseMap
import java.util.*

class Movie{
    private var adult: Boolean = false
    private var budget: Int = 0
    private lateinit var genres: List<Genres>
    private lateinit var homepage: String
    private var id: Int = 0
    private lateinit var imdbId: String
    private lateinit var originalTitle: String
    private lateinit var overview: String
    private var popularity: Float = 0f
    private lateinit var production_countries: Country
    private lateinit var releaseDate: Date
    private var revenue: Int = 0
    private var runtime: Int = 0
    private lateinit var status: statusMovie
    private var title: String
    private var voteAverage: Float = 0f
    private var voteCount: Int = 0

    constructor(title: String){
        this.title = title
    }

    fun getTitle(): String = title

}

data class Country(var iso: String, var name: String)

data class Genres(var id: Int, var name: String)

enum class statusMovie {
    Released
}