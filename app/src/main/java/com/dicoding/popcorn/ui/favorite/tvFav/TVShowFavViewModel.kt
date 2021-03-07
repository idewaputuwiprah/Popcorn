package com.dicoding.popcorn.ui.favorite.tvFav

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.popcorn.data.MovieEntity
import com.dicoding.popcorn.data.PopcornRepository
import com.dicoding.popcorn.data.local.TVShowFavEntity
import com.dicoding.popcorn.utils.DataDummy

class TVShowFavViewModel(private val popcornRepository: PopcornRepository) : ViewModel() {

    fun getFavTVShows(): LiveData<PagedList<TVShowFavEntity>> = popcornRepository.getTVShowFav()

    fun getLoadingStatus(): LiveData<Boolean> = popcornRepository.getLoadingStatus()

}