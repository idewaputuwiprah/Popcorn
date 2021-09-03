package com.dicoding.popcorn.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dicoding.popcorn.core.domain.model.Detail
import com.dicoding.popcorn.core.data.Resource
import com.dicoding.popcorn.core.domain.model.Movie
import com.dicoding.popcorn.core.domain.usecase.PopcornUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val popcornUseCase: PopcornUseCase) : ViewModel() {
    private lateinit var itemId: String
    var item: Detail? = null

    fun setItem(itemId: String) {
        this.itemId = itemId
    }

    fun getRemoteMovieDetail(): LiveData<Resource<Detail>> = popcornUseCase.getDetailMovie(itemId.toInt()).asLiveData()

    fun getRemoteTVShowDetail(): LiveData<Resource<Detail>> = popcornUseCase.getDetailTVShows(itemId.toInt()).asLiveData()

    fun insertMovieFavorite(movieDetail: Detail) {
        viewModelScope.launch(Dispatchers.IO) {
            popcornUseCase.insertMovieFav(movieDetail)
        }
    }

    fun getMovieFavorite(): LiveData<Movie?> = popcornUseCase.getMovieFav(itemId).asLiveData()

    fun deleteMovie(movieDetail: Detail) {
        popcornUseCase.deleteMovieFav(movieDetail)
    }

    fun insertTVShowFavorite(tvShowsDetail: Detail) {
        viewModelScope.launch(Dispatchers.IO) {
            popcornUseCase.insertTVShowFav(tvShowsDetail)
        }
    }

    fun getTVShowFavorite(): LiveData<Movie?> = popcornUseCase.getTVShowFav(itemId).asLiveData()

    fun deleteTVShow(tvShowDetail: Detail) {
        popcornUseCase.deleteTVShowFav(tvShowDetail)
    }
}