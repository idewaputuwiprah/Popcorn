package com.idputuwiprah.favorite.tvFav

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.idputuwiprah.core.domain.model.Movie
import com.idputuwiprah.core.domain.usecase.PopcornUseCase

class TVShowFavViewModel(private val popcornUseCase: PopcornUseCase) : ViewModel() {

    fun getFavTVShows(): LiveData<List<Movie>> = popcornUseCase.getTVShowsFav().asLiveData()
}