package com.dicoding.popcorn.data

import androidx.lifecycle.LiveData

interface PopcornDataSource {
    fun getMovies(): LiveData<List<MovieEntity>>
}