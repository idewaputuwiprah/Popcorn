package com.dicoding.popcorn.ui.favorite.movieFav

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.popcorn.data.PopcornRepository
import com.dicoding.popcorn.data.local.MovieFavEntity

class MovieFavViewModel(private val popcornRepository: PopcornRepository) : ViewModel() {

    fun getFavMovies(): LiveData<PagedList<MovieFavEntity>> = popcornRepository.getMovieFav()

    fun getLoadingStatus(): LiveData<Boolean> = popcornRepository.getLoadingStatus()
}