package com.dicoding.popcorn.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.dicoding.popcorn.core.domain.usecase.PopcornUseCase

class MovieViewModel(popcornUseCase: PopcornUseCase) : ViewModel() {
    val movies = popcornUseCase.getRemoteMovies().asLiveData()
}