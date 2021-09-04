package com.dicoding.popcorn.ui.favorite.tvFav

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.idputuwiprah.core.domain.model.Movie
import com.idputuwiprah.core.domain.usecase.PopcornUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TVShowFavViewModel @Inject constructor(private val popcornUseCase: PopcornUseCase) : ViewModel() {

    fun getFavTVShows(): LiveData<List<Movie>> = popcornUseCase.getTVShowsFav().asLiveData()
}