package com.idputuwiprah.core.data.local

import com.idputuwiprah.core.data.local.entity.MovieFavEntity
import com.idputuwiprah.core.data.local.entity.TVShowFavEntity
import com.idputuwiprah.core.data.local.room.PopcornDAO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val popcornDAO: PopcornDAO) {

    fun getMovieFav(): Flow<List<MovieFavEntity>> = popcornDAO.getMovieFav()

    fun getTVShowFav(): Flow<List<TVShowFavEntity>> = popcornDAO.getTVShowFav()

    suspend fun insertMovieFav(movieFav: MovieFavEntity) = popcornDAO.insertMovieFav(movieFav)

    suspend fun insertTVShowFav(tvShowFav: TVShowFavEntity) = popcornDAO.insertTVShowFav(tvShowFav)

    fun getMovieFavById(movieId: String): Flow<MovieFavEntity> = popcornDAO.getMovieFavById(movieId)

    fun getTVShowFavById(tvId: String): Flow<TVShowFavEntity> = popcornDAO.getTVShowFavById(tvId)

    fun deleteMovie(movieFavEntity: MovieFavEntity) = popcornDAO.deleteMovieFav(movieFavEntity)

    fun deleteTVShow(tvShowFavEntity: TVShowFavEntity) = popcornDAO.deleteTVShowFav(tvShowFavEntity)
}
