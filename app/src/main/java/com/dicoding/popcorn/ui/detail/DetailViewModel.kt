package com.dicoding.popcorn.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.popcorn.core.domain.model.Detail
import com.dicoding.popcorn.core.data.Resource
import com.dicoding.popcorn.core.data.local.entity.MovieFavEntity
import com.dicoding.popcorn.core.data.local.entity.TVShowFavEntity
import com.dicoding.popcorn.core.domain.usecase.PopcornUseCase

class DetailViewModel(private val popcornUseCase: PopcornUseCase) : ViewModel() {
    private lateinit var itemId: String
    var item: Detail? = null

    fun setItem(itemId: String) {
        this.itemId = itemId
    }

    fun getRemoteMovieDetail(): LiveData<Resource<Detail>> = popcornUseCase.getDetailMovie(itemId.toInt())

    fun getRemoteTVShowDetail(): LiveData<Resource<Detail>> = popcornUseCase.getDetailTVShows(itemId.toInt())

    fun insertMovieFavorite(movies: MovieFavEntity) {
        popcornUseCase.insertMovieFav(movies)
    }

    fun getMovieFavorite(): LiveData<MovieFavEntity> = popcornUseCase.getMovieFavById(itemId)

    fun deleteMovie(movieFavEntity: MovieFavEntity) {
        popcornUseCase.deleteMovieFav(movieFavEntity)
    }

    fun insertTVShowFavorite(tvShows: TVShowFavEntity) {
        popcornUseCase.insertTVShowFav(tvShows)
    }

    fun getTVShowFavorite(): LiveData<TVShowFavEntity> = popcornUseCase.getTVShowFavById(itemId)

    fun deleteTVShow(tvShowFavEntity: TVShowFavEntity) {
        popcornUseCase.deleteTVShowFav(tvShowFavEntity)
    }
}