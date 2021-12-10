package com.skysoft.kindfilms.domain

import android.os.Build
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

@Parcelize
class Movie() : Parcelable {
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
    private lateinit var releaseDate: LocalDate
    private var revenue: Int = 0
    private var runtime: Int = 0
    private lateinit var status: StatusMovie
    private lateinit var title: String
    private var voteAverage: Float = 0f
    private var voteCount: Int = 0
    private lateinit var imageURL: String

    constructor(title: String, imageURL: String) : this() {
        this.title = title
        this.production_countries = Country("ISO 3166-2:RU", "Россия")
        this.imageURL = imageURL
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            releaseDate = LocalDate.parse("11-08-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        }
        overview = "В городе Эббинг, штат Миссури, Милдред Хейс (Фрэнсис Макдорманд) оплакивает изнасилование и убийство своей дочери-подростка Анджелы, совершенные несколькими месяцами ранее. Раздраженная отсутствием прогресса в расследовании, Милдред арендует три заброшенных билборда возле своего дома и размещает на них сообщения: «Изнасилована, пока умирала», «Все еще нет арестов?» и «Как так случилось, шериф Уиллоуби?» Рекламные щиты расстроили горожан, в том числе шерифа Билла Уиллоуби (Вуди Харрельсон) и полицейского Джейсона Диксона (Сэм Рокуэлл), расиста и алкоголика. Ни для кого не секрет, что Билл страдает от неизлечимого рака поджелудочной железы, что также добавляет недовольства по поводу билбордов. Несмотря на оскорбления и угрозы, а также возражения со стороны сына Робби, Милдред по-прежнему полна решимости отстаивать идею с рекламными щитами."
    }

    fun getTitle(): String = title
    fun getImageURL(): String = imageURL
    fun getReleaseDate(): LocalDate = releaseDate
    fun getReleaseYear(): String = "2010"
    fun getBudget(): Int = 100500
    fun getGenresString(): String{
        return "Фантастика, приключения, детективы"
    }
    fun getRunTime(): Int = 120
    fun getCountry(): Country = production_countries
    fun getStatus(): StatusMovie = StatusMovie.RELEASED
    fun getOverview(): String = overview
    fun getVoteAverage(): Float = 7.5f
}

data class Country(var iso: String, var name: String)

data class Genres(var id: Int, var name: String)

enum class StatusMovie (val synonym: String) {
    RUMORED("Ходят слухи"),
    PLANNED("Планируется"),
    IN_PRODUCTION("В производстве"),
    POST_PRODUCTION("На этапе выпуска"),
    RELEASED("Вышел"),
    CANCELED("Отменен");


}