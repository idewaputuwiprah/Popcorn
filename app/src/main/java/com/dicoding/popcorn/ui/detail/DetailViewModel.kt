package com.dicoding.popcorn.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dicoding.popcorn.data.DetailEntity
import com.dicoding.popcorn.data.PopcornRepository
import com.dicoding.popcorn.data.local.MovieFavEntity
import com.dicoding.popcorn.data.local.TVShowFavEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DetailViewModel(private val popcornRepository: PopcornRepository) : ViewModel() {
    private lateinit var itemId: String
    var item: DetailEntity? = null

    fun setItem(itemId: String) {
        this.itemId = itemId
    }

    fun getRemoteMovieDetail(): LiveData<DetailEntity> {
        val data = MutableLiveData<DetailEntity>()
        viewModelScope.launch(Dispatchers.IO) {
            data.postValue(popcornRepository.getDetailMovie(itemId.toInt()))
        }
        return data
    }

    fun getRemoteTVShowDetail(): LiveData<DetailEntity> = popcornRepository.getDetailTVShows(itemId.toInt())

    fun getLoadingStatus(): LiveData<Boolean> = popcornRepository.getLoadingStatus()

    fun insertMovieFavorite(movies: List<MovieFavEntity>) {
        popcornRepository.insertMovieFav(movies)
    }

    fun insertTVShowFavorite(tvShows: List<TVShowFavEntity>) {
        popcornRepository.insertTVShowFav(tvShows)
    }

    fun getMovieFavorite(): LiveData<MovieFavEntity> = popcornRepository.getMovieFavById(itemId)

    fun getTVShowFavorite(): LiveData<TVShowFavEntity> = popcornRepository.getTVShowFavById(itemId)

    fun deleteMovie(movieFavEntity: MovieFavEntity) {
        popcornRepository.deleteMovieFav(movieFavEntity)
    }

    fun deleteTVShow(tvShowFavEntity: TVShowFavEntity) {
        popcornRepository.deleteTVShowFav(tvShowFavEntity)
    }
}