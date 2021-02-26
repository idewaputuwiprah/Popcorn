package com.dicoding.popcorn.data

import androidx.lifecycle.LiveData

interface PopcornDataSource {
    fun getRemoteMovies(): LiveData<List<MovieEntity>>

    fun getDetailMovie(id: Int): LiveData<DetailEntity>

    fun getRemoteTVShows(): LiveData<List<MovieEntity>>

    fun getDetailTVShows(id: Int): LiveData<DetailEntity>

}