package com.dicoding.popcorn.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.popcorn.data.MovieEntity
import com.dicoding.popcorn.data.PopcornRepository
import com.dicoding.popcorn.utils.DataDummy

class TVShowViewModel(private val popcornRepository: PopcornRepository) : ViewModel() {

    fun getRemoteTVShows(): LiveData<List<MovieEntity>> = popcornRepository.getRemoteTVShows()

    fun getLoadingStatus(): LiveData<Boolean> = popcornRepository.getLoadingStatus()

}