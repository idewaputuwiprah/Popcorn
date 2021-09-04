package com.idputuwiprah.core.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.idputuwiprah.core.data.local.entity.MovieFavEntity
import com.idputuwiprah.core.data.local.entity.TVShowFavEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PopcornDAO {

    @Query("SELECT * FROM movieFav")
    fun getMovieFav(): Flow<List<MovieFavEntity>>

    @Transaction
    @Query("SELECT * FROM movieFav WHERE movieId = :movieId")
    fun getMovieFavById(movieId: String): Flow<MovieFavEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieFav(movieFav: MovieFavEntity)

    @Update
    fun updateMovieFav(movieFav: MovieFavEntity)

    @Delete
    fun deleteMovieFav(movieFav: MovieFavEntity)

    @Query("SELECT * FROM tvShowFav")
    fun getTVShowFav(): Flow<List<TVShowFavEntity>>

    @Transaction
    @Query("SELECT * FROM tvShowFav WHERE tvShowId = :tvId")
    fun getTVShowFavById(tvId: String): Flow<TVShowFavEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTVShowFav(tvShow: TVShowFavEntity)

    @Update
    fun updateTVShowFav(tvShowFav: TVShowFavEntity)

    @Delete
    fun deleteTVShowFav(tvShowFav: TVShowFavEntity)
}