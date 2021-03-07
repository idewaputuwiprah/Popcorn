package com.dicoding.popcorn.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.popcorn.data.local.MovieFavEntity
import com.dicoding.popcorn.data.local.TVShowFavEntity

interface PopcornDataSource {
    fun getRemoteMovies(): LiveData<List<MovieEntity>>

    fun getDetailMovie(id: Int): LiveData<DetailEntity>

    fun getRemoteTVShows(): LiveData<List<MovieEntity>>

    fun getDetailTVShows(id: Int): LiveData<DetailEntity>

    fun getMovieFav(): LiveData<PagedList<MovieFavEntity>>

    fun getMovieFavById(movieId: String): LiveData<MovieFavEntity>

    fun getTVShowFav(): LiveData<PagedList<TVShowFavEntity>>

    fun getTVShowFavById(tvId:String): LiveData<TVShowFavEntity>

    fun insertMovieFav(movieFav: List<MovieFavEntity>)

    fun insertTVShowFav(tvShowFav: List<TVShowFavEntity>)

    fun deleteMovieFav(movieFavEntity: MovieFavEntity)

    fun deleteTVShowFav(tvShowFavEntity: TVShowFavEntity)
}