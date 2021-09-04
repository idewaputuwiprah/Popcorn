package com.dicoding.popcorn.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.idputuwiprah.core.domain.usecase.PopcornUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(popcornUseCase: PopcornUseCase) : ViewModel() {
    val movies = popcornUseCase.getRemoteMovies().asLiveData()
}