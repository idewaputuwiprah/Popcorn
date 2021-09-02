package com.dicoding.popcorn.core.domain.usecase

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.popcorn.core.data.Resource
import com.dicoding.popcorn.core.data.local.entity.MovieFavEntity
import com.dicoding.popcorn.core.data.local.entity.TVShowFavEntity
import com.dicoding.popcorn.core.domain.model.Detail
import com.dicoding.popcorn.core.domain.model.Movie
import com.dicoding.popcorn.core.domain.repository.IPopcornRepository

class PopcornInteractor(private val popcornRepository: IPopcornRepository): PopcornUseCase {
    override fun getRemoteMovies(): LiveData<Resource<List<Movie>>> =
        popcornRepository.getRemoteMovies()

    override fun getDetailMovie(id: Int): LiveData<Resource<Detail>> =
        popcornRepository.getDetailMovie(id)

    override fun getRemoteTVShows(): LiveData<Resource<List<Movie>>> =
        popcornRepository.getRemoteTVShows()

    override fun getDetailTVShows(id: Int): LiveData<Resource<Detail>> =
        popcornRepository.getDetailTVShows(id)

    override fun getMovieFav(): LiveData<PagedList<MovieFavEntity>> =
        popcornRepository.getMovieFav()

    override fun getMovieFavById(movieId: String): LiveData<MovieFavEntity> =
        popcornRepository.getMovieFavById(movieId)

    override fun getTVShowFav(): LiveData<PagedList<TVShowFavEntity>> =
        popcornRepository.getTVShowFav()

    override fun getTVShowFavById(tvId: String): LiveData<TVShowFavEntity> =
        popcornRepository.getTVShowFavById(tvId)

    override fun insertMovieFav(movieFav: MovieFavEntity) {
        popcornRepository.insertMovieFav(movieFav)
    }

    override fun insertTVShowFav(tvShowFav: TVShowFavEntity) {
        popcornRepository.insertTVShowFav(tvShowFav)
    }

    override fun deleteMovieFav(movieFavEntity: MovieFavEntity) {
        popcornRepository.deleteMovieFav(movieFavEntity)
    }

    override fun deleteTVShowFav(tvShowFavEntity: TVShowFavEntity) {
        popcornRepository.deleteTVShowFav(tvShowFavEntity)
    }
}