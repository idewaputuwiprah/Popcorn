package com.dicoding.popcorn.core.data.local

import com.dicoding.popcorn.core.data.local.entity.MovieFavEntity
import com.dicoding.popcorn.core.data.local.entity.TVShowFavEntity
import com.dicoding.popcorn.core.data.local.room.PopcornDAO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val popcornDAO: PopcornDAO) {

//    companion object {
//        private var INSTANCE: LocalDataSource? = null
//
//        fun getInstance(popcornDAO: PopcornDAO): LocalDataSource =
//            INSTANCE ?: LocalDataSource(popcornDAO)
//    }

    fun getMovieFav(): Flow<List<MovieFavEntity>> = popcornDAO.getMovieFav()

    fun getTVShowFav(): Flow<List<TVShowFavEntity>> = popcornDAO.getTVShowFav()

    suspend fun insertMovieFav(movieFav: MovieFavEntity) = popcornDAO.insertMovieFav(movieFav)

    suspend fun insertTVShowFav(tvShowFav: TVShowFavEntity) = popcornDAO.insertTVShowFav(tvShowFav)

    fun getMovieFavById(movieId: String): Flow<MovieFavEntity> = popcornDAO.getMovieFavById(movieId)

    fun getTVShowFavById(tvId: String): Flow<TVShowFavEntity> = popcornDAO.getTVShowFavById(tvId)

    fun deleteMovie(movieFavEntity: MovieFavEntity) = popcornDAO.deleteMovieFav(movieFavEntity)

    fun deleteTVShow(tvShowFavEntity: TVShowFavEntity) = popcornDAO.deleteTVShowFav(tvShowFavEntity)
}
