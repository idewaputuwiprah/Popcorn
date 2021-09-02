package com.dicoding.popcorn.core.data.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dicoding.popcorn.core.data.local.entity.MovieFavEntity
import com.dicoding.popcorn.core.data.local.entity.TVShowFavEntity
import com.dicoding.popcorn.core.data.local.room.PopcornDAO

class LocalDataSource private constructor(private val popcornDAO: PopcornDAO) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(popcornDAO: PopcornDAO): LocalDataSource =
            INSTANCE ?: LocalDataSource(popcornDAO)
    }

    fun getMovieFav(): DataSource.Factory<Int, MovieFavEntity> = popcornDAO.getMovieFav()

    fun getTVShowFav(): DataSource.Factory<Int, TVShowFavEntity> = popcornDAO.getTVShowFav()

    fun insertMovieFav(movieFav: MovieFavEntity) = popcornDAO.insertMovieFav(movieFav)

    fun insertTVShowFav(tvShowFav: TVShowFavEntity) = popcornDAO.insertTVShowFav(tvShowFav)

    fun getMovieFavById(movieId: String): LiveData<MovieFavEntity> = popcornDAO.getMovieFavById(movieId)

    fun getTVShowFavById(tvId: String): LiveData<TVShowFavEntity> = popcornDAO.getTVShowFavById(tvId)

    fun deleteMovie(movieFavEntity: MovieFavEntity) = popcornDAO.deleteMovieFav(movieFavEntity)

    fun deleteTVShow(tvShowFavEntity: TVShowFavEntity) = popcornDAO.deleteTVShowFav(tvShowFavEntity)
}
