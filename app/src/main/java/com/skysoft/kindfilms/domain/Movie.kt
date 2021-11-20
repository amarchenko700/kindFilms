package com.skysoft.kindfilms.domain

import java.util.*

class Movie {
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
    private var imageURL: String

    constructor(title: String, imageURL: String) {
        this.title = title
        this.imageURL = imageURL
    }

    fun getTitle(): String = title
    fun getImageURL(): String = imageURL

}

data class Country(var iso: String, var name: String)

data class Genres(var id: Int, var name: String)

enum class statusMovie {
    Released
}