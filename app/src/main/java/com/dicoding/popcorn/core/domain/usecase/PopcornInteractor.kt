package com.dicoding.popcorn.core.domain.usecase

import androidx.lifecycle.LiveData
import com.dicoding.popcorn.core.data.Resource
import com.dicoding.popcorn.core.domain.model.Detail
import com.dicoding.popcorn.core.domain.model.Movie
import com.dicoding.popcorn.core.domain.repository.IPopcornRepository
import kotlinx.coroutines.flow.Flow

class PopcornInteractor(private val popcornRepository: IPopcornRepository): PopcornUseCase {
    override fun getRemoteMovies(): Flow<Resource<List<Movie>>> =
        popcornRepository.getRemoteMovies()

    override fun getDetailMovie(id: Int): Flow<Resource<Detail>> =
        popcornRepository.getDetailMovie(id)

    override fun getRemoteTVShows(): Flow<Resource<List<Movie>>> =
        popcornRepository.getRemoteTVShows()

    override fun getDetailTVShows(id: Int): Flow<Resource<Detail>> =
        popcornRepository.getDetailTVShows(id)

    override fun getMoviesFav(): LiveData<List<Movie>> =
        popcornRepository.getMoviesFav()

    override fun getMovieFav(movieId: String): LiveData<Movie> =
        popcornRepository.getMovieFav(movieId)

    override fun getTVShowsFav(): LiveData<List<Movie>> =
        popcornRepository.getTVShowsFav()

    override fun getTVShowFav(tvId: String): LiveData<Movie> =
        popcornRepository.getTVShowFav(tvId)

    override fun insertMovieFav(movieDetail: Detail) {
        popcornRepository.insertMovieFav(movieDetail)
    }

    override fun insertTVShowFav(tvShowDetail: Detail) {
        popcornRepository.insertTVShowFav(tvShowDetail)
    }

    override fun deleteMovieFav(movieDetail: Detail) {
        popcornRepository.deleteMovieFav(movieDetail)
    }

    override fun deleteTVShowFav(tvShowDetail: Detail) {
        popcornRepository.deleteTVShowFav(tvShowDetail)
    }
}