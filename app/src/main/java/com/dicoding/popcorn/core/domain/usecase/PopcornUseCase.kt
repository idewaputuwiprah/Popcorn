package com.dicoding.popcorn.core.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.popcorn.core.data.Resource
import com.dicoding.popcorn.core.data.local.entity.MovieFavEntity
import com.dicoding.popcorn.core.data.local.entity.TVShowFavEntity
import com.dicoding.popcorn.core.domain.model.Detail
import com.dicoding.popcorn.core.domain.model.Movie

interface PopcornUseCase {
    fun getRemoteMovies(): LiveData<Resource<List<Movie>>>

    fun getDetailMovie(id: Int): LiveData<Resource<Detail>>

    fun getRemoteTVShows(): LiveData<Resource<List<Movie>>>

    fun getDetailTVShows(id: Int): LiveData<Resource<Detail>>

    fun getMovieFav(): LiveData<PagedList<MovieFavEntity>>

    fun getMovieFavById(movieId: String): LiveData<MovieFavEntity>

    fun getTVShowFav(): LiveData<PagedList<TVShowFavEntity>>

    fun getTVShowFavById(tvId:String): LiveData<TVShowFavEntity>

    fun insertMovieFav(movieFav: MovieFavEntity)

    fun insertTVShowFav(tvShowFav: TVShowFavEntity)

    fun deleteMovieFav(movieFavEntity: MovieFavEntity)

    fun deleteTVShowFav(tvShowFavEntity: TVShowFavEntity)
}