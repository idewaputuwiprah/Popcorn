package com.dicoding.popcorn.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.popcorn.data.DetailEntity
import com.dicoding.popcorn.data.PopcornRepository

class DetailViewModel(private val popcornRepository: PopcornRepository) : ViewModel() {
    private lateinit var itemId: String

    fun setItem(itemId: String) {
        this.itemId = itemId
    }

    fun getRemoteMovieDetail(): LiveData<DetailEntity> = popcornRepository.getDetailMovie(itemId.toInt())

    fun getRemoteTVShowDetail(): LiveData<DetailEntity> = popcornRepository.getDetailTVShows(itemId.toInt())

    fun getLoadingStatus(): LiveData<Boolean> = popcornRepository.getLoadingStatus()
}