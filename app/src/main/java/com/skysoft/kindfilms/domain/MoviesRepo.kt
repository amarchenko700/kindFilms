package com.skysoft.kindfilms.domain

import java.util.*

object MoviesRepo {
    private val cachePopular = mutableListOf<Movie>()
    private val cacheTopRated = mutableListOf<Movie>()
    private val cacheUpcoming = mutableListOf<Movie>()

    init {
        cachePopular.add(
            Movie(
                "Популярный фильм 1",
                "https://avatars.mds.yandex.net/get-zen_doc/1857055/pub_5e200af4e3062c00b03ccdbe_5e200ccc2beb4900ada5b77e/scale_1200"
            )
        )
        cachePopular.add(
            Movie(
                "Популярный фильм 2",
                "https://korzik.net/uploads/posts/2017-11/1510755578_korzik_net_tor.jpg"
            )
        )
        cachePopular.add(
            Movie(
                "Популярный фильм 3",
                "https://s.0552.ua/section/kinoanons_images/upload/images/afisha_kino/gallery/000/000/017/10409407-88451957f5fd57e7eac.jpg"
            )
        )
        cachePopular.add(
            Movie(
                "Популярный фильм 4",
                "https://www.film.ru/sites/default/files/movies/posters/Walking-Tall-5.jpg"
            )
        )
        cachePopular.add(
            Movie(
                "Популярный фильм 1",
                "https://avatars.mds.yandex.net/get-zen_doc/1857055/pub_5e200af4e3062c00b03ccdbe_5e200ccc2beb4900ada5b77e/scale_1200"
            )
        )
        cachePopular.add(
            Movie(
                "Популярный фильм 2",
                "https://korzik.net/uploads/posts/2017-11/1510755578_korzik_net_tor.jpg"
            )
        )
        cachePopular.add(
            Movie(
                "Популярный фильм 3",
                "https://s.0552.ua/section/kinoanons_images/upload/images/afisha_kino/gallery/000/000/017/10409407-88451957f5fd57e7eac.jpg"
            )
        )
        cachePopular.add(
            Movie(
                "Популярный фильм 4",
                "https://www.film.ru/sites/default/files/movies/posters/Walking-Tall-5.jpg"
            )
        )
        cachePopular.add(
            Movie(
                "Популярный фильм 1",
                "https://avatars.mds.yandex.net/get-zen_doc/1857055/pub_5e200af4e3062c00b03ccdbe_5e200ccc2beb4900ada5b77e/scale_1200"
            )
        )
        cachePopular.add(
            Movie(
                "Популярный фильм 2",
                "https://korzik.net/uploads/posts/2017-11/1510755578_korzik_net_tor.jpg"
            )
        )
        cachePopular.add(
            Movie(
                "Популярный фильм 3",
                "https://s.0552.ua/section/kinoanons_images/upload/images/afisha_kino/gallery/000/000/017/10409407-88451957f5fd57e7eac.jpg"
            )
        )
        cachePopular.add(
            Movie(
                "Популярный фильм 4",
                "https://www.film.ru/sites/default/files/movies/posters/Walking-Tall-5.jpg"
            )
        )

        cacheTopRated.add(
            Movie(
                "Модный фильм 1",
                "https://avatars.mds.yandex.net/get-kinopoisk-image/1946459/1aa1942b-6307-48d5-9a69-b35553d2433f/960x960"
            )
        )
        cacheTopRated.add(
            Movie(
                "Модный фильм 2",
                "https://www.film.ru/sites/default/files/movies/posters/7AcjjzV.jpg"
            )
        )
        cacheTopRated.add(
            Movie(
                "Модный фильм 3",
                "https://3.bp.blogspot.com/_bUHjF8vmw_g/Sw0PpochVxI/AAAAAAAAItU/5CIl_hT8wIk/s0/ZOMBIELAND_poster.jpg"
            )
        )
        cacheTopRated.add(
            Movie(
                "Модный фильм 4",
                "https://www.wallpapermaiden.com/wallpaper/20473/download/1200x1920/ready-player-one-artwork.jpg"
            )
        )

        cacheUpcoming.add(Movie("Анонс фильма 1", "https://wallpapercave.com/wp/wp1949554.jpg"))
        cacheUpcoming.add(
            Movie(
                "Анонс фильма 2",
                "https://i.pinimg.com/originals/b3/ae/cf/b3aecf621b373984ee6972f7ea88e5f7.png"
            )
        )
        cacheUpcoming.add(
            Movie(
                "Анонс фильма 3",
                "https://www.kinofilms.ua/images/photos/w200/412598.jpg"
            )
        )
        cacheUpcoming.add(
            Movie(
                "Анонс фильма 4",
                "https://fanart.tv/detailpreview/fanart/movies/137113/movieposter/edge-of-tomorrow-5a4056d54c54a.jpg"
            )
        )
    }

    fun getPopularMovies(): List<Movie?>? {
        return ArrayList<Movie?>(cachePopular)
    }

    fun getTopRatedMovies(): List<Movie?>? {
        return ArrayList<Movie?>(cacheTopRated)
    }

    fun getUpcomingMovies(): List<Movie?>? {
        return ArrayList<Movie?>(cacheUpcoming)
    }
}