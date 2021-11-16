package com.skysoft.kindfilms.domain

import java.util.ArrayList

object MoviesRepo {
    private val cache = mutableListOf<Movie>()

    init{
        cache.add(Movie( "Какое-то описание 1", "https://avatars.mds.yandex.net/get-zen_doc/1857055/pub_5e200af4e3062c00b03ccdbe_5e200ccc2beb4900ada5b77e/scale_1200"))
        cache.add(Movie("Какое-то описание 2", "https://korzik.net/uploads/posts/2017-11/1510755578_korzik_net_tor.jpg"))
        cache.add(Movie("Какое-то описание 3", "https://s.0552.ua/section/kinoanons_images/upload/images/afisha_kino/gallery/000/000/017/10409407-88451957f5fd57e7eac.jpg"))
        cache.add(Movie("Какое-то описание 4", "https://www.film.ru/sites/default/files/movies/posters/Walking-Tall-5.jpg"))
    }

    fun getMovies(): List<Movie?>? {
        return ArrayList<Movie?>(cache)
    }
}