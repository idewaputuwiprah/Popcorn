package com.dicoding.popcorn.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.popcorn.data.MovieEntity
import com.dicoding.popcorn.data.PopcornRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(private val popcornRepository: PopcornRepository) : ViewModel() {
    private val _movies: MutableLiveData<List<MovieEntity>> = MutableLiveData<List<MovieEntity>>()
    val movies: LiveData<List<MovieEntity>> = _movies

    fun getRemoteMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            _movies.postValue(popcornRepository.getRemoteMovies())
        }
    }

    fun getLoadingStatus(): LiveData<Boolean> = popcornRepository.getLoadingStatus()
}