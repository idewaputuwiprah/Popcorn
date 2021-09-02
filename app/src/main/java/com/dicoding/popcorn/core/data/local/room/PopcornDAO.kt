package com.dicoding.popcorn.core.data.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.dicoding.popcorn.core.data.local.entity.MovieFavEntity
import com.dicoding.popcorn.core.data.local.entity.TVShowFavEntity

@Dao
interface PopcornDAO {

    @Query("SELECT * FROM movieFav")
    fun getMovieFav(): DataSource.Factory<Int, MovieFavEntity>

    @Transaction
    @Query("SELECT * FROM movieFav WHERE movieId = :movieId")
    fun getMovieFavById(movieId: String): LiveData<MovieFavEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieFav(movieFav: MovieFavEntity)

    @Update
    fun updateMovieFav(movieFav: MovieFavEntity)

    @Delete
    fun deleteMovieFav(movieFav: MovieFavEntity)

    @Query("SELECT * FROM tvShowFav")
    fun getTVShowFav(): DataSource.Factory<Int, TVShowFavEntity>

    @Transaction
    @Query("SELECT * FROM tvShowFav WHERE tvShowId = :tvId")
    fun getTVShowFavById(tvId: String): LiveData<TVShowFavEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTVShowFav(tvShow: TVShowFavEntity)

    @Update
    fun updateTVShowFav(tvShowFav: TVShowFavEntity)

    @Delete
    fun deleteTVShowFav(tvShowFav: TVShowFavEntity)
}