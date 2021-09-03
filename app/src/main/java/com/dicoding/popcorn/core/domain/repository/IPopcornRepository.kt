package com.dicoding.popcorn.core.domain.repository

import androidx.lifecycle.LiveData
import com.dicoding.popcorn.core.domain.model.Detail
import com.dicoding.popcorn.core.domain.model.Movie
import com.dicoding.popcorn.core.data.Resource
import kotlinx.coroutines.flow.Flow

interface IPopcornRepository {
    fun getRemoteMovies(): Flow<Resource<List<Movie>>>

    fun getDetailMovie(id: Int): Flow<Resource<Detail>>

    fun getRemoteTVShows(): Flow<Resource<List<Movie>>>

    fun getDetailTVShows(id: Int): Flow<Resource<Detail>>

    fun getMoviesFav(): LiveData<List<Movie>>

    fun getMovieFav(movieId: String): LiveData<Movie>

    fun getTVShowsFav(): LiveData<List<Movie>>

    fun getTVShowFav(tvId:String): LiveData<Movie>

    fun insertMovieFav(movieDetail: Detail)

    fun insertTVShowFav(tvShowDetail: Detail)

    fun deleteMovieFav(movieDetail: Detail)

    fun deleteTVShowFav(tvShowDetail: Detail)
}