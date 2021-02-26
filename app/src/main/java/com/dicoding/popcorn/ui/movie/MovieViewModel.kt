package com.dicoding.popcorn.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.popcorn.data.MovieEntity
import com.dicoding.popcorn.data.PopcornRepository
import com.dicoding.popcorn.utils.DataDummy

class MovieViewModel(private val popcornRepository: PopcornRepository) : ViewModel() {

    fun getRemoteMovies(): LiveData<List<MovieEntity>> = popcornRepository.getRemoteMovies()

    fun getLoadingStatus(): LiveData<Boolean> = popcornRepository.getLoadingStatus()

    fun getMovie(): List<MovieEntity> = DataDummy.generateDummyMovies()
}