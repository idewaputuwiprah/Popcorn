package com.idputuwiprah.core.data

import com.idputuwiprah.core.data.local.LocalDataSource
import com.idputuwiprah.core.data.remote.RemoteDataSource
import com.idputuwiprah.core.data.remote.network.ApiResponse
import com.idputuwiprah.core.domain.model.Detail
import com.idputuwiprah.core.domain.model.Movie
import com.idputuwiprah.core.domain.repository.IPopcornRepository
import com.idputuwiprah.core.utils.AppExecutors
import com.idputuwiprah.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PopcornRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IPopcornRepository {

    override fun getRemoteMovies(): Flow<Resource<List<Movie>>> = flow {
        when (val apiResponse = remoteDataSource.getMovies().first()) {
            is ApiResponse.SUCCESS -> {
                val movieList = DataMapper.mapMovieResponseToMovies(apiResponse.data)
                emit(Resource.Success(movieList))
            }
            is ApiResponse.Empty -> {
                emit(Resource.Success(emptyList<Movie>()))
            }
            is ApiResponse.ERROR -> {
                emit(Resource.Error<List<Movie>>(apiResponse.errorMessage))
            }
        }
    }

    override fun getDetailMovie(id: Int): Flow<Resource<Detail>> = flow {
        when (val apiResponse = remoteDataSource.getMovieDetail(id).first()) {
            is ApiResponse.SUCCESS -> {
                val detail = DataMapper.mapDetailMovieResponseToDetailEntity(apiResponse.data)
                emit(Resource.Success(detail))
            }
            is ApiResponse.ERROR -> {
                emit(Resource.Error<Detail>(apiResponse.errorMessage))
            }
        }
    }

    override fun getRemoteTVShows(): Flow<Resource<List<Movie>>> = flow {
        when (val apiResponse = remoteDataSource.getTVShows().first()) {
            is ApiResponse.SUCCESS -> {
                val tvShowList = DataMapper.mapTVShowResponseToMovies(apiResponse.data)
                emit(Resource.Success(tvShowList))
            }
            is ApiResponse.Empty -> {
                emit(Resource.Success(emptyList<Movie>()))
            }
            is ApiResponse.ERROR -> {
                emit(Resource.Error<List<Movie>>(apiResponse.errorMessage))
            }
        }
    }

    override fun getDetailTVShows(id: Int): Flow<Resource<Detail>> = flow {
        when (val apiResponse = remoteDataSource.getTVShowDetail(id).first()) {
            is ApiResponse.SUCCESS -> {
                val detail = DataMapper.mapDetailTVShowResponseToDetailEntity(apiResponse.data)
                emit(Resource.Success(detail))
            }
            is ApiResponse.ERROR -> {
                emit(Resource.Error<Detail>(apiResponse.errorMessage))
            }
        }
    }

    override fun getMoviesFav(): Flow<List<Movie>> {
        return localDataSource.getMovieFav().map { DataMapper.mapMovieFavEntitiesToMovie(it) }
    }

    override fun getMovieFav(movieId: String): Flow<Movie?> {
        return localDataSource.getMovieFavById(movieId).map { DataMapper.mapMovieFavEntityToMovie(it) }
    }

    override fun getTVShowsFav(): Flow<List<Movie>> {
        return localDataSource.getTVShowFav().map { DataMapper.mapTVShowFavEntitiesToMovie(it) }
    }

    override fun getTVShowFav(tvId: String): Flow<Movie?> {
        return localDataSource.getTVShowFavById(tvId).map { DataMapper.mapTVShowFavEntityToMovie(it) }
    }

    override suspend fun insertMovieFav(movieDetail: Detail) {
        val movieFav = DataMapper.mapDetailToMovieFavEntity(movieDetail)
        localDataSource.insertMovieFav(movieFav)
    }

    override suspend fun insertTVShowFav(tvShowDetail: Detail) {
        val tvShowFav = DataMapper.mapDetailToTVShowFavEntity(tvShowDetail)
//        appExecutors.diskIO().execute { localDataSource.insertTVShowFav(tvShowFav) }
        localDataSource.insertTVShowFav(tvShowFav)
    }

    override fun deleteMovieFav(movieDetail: Detail) {
        val movieFav = DataMapper.mapDetailToMovieFavEntity(movieDetail)
        appExecutors.diskIO().execute { localDataSource.deleteMovie(movieFav) }
    }

    override fun deleteTVShowFav(tvShowDetail: Detail) {
        val tvShowFav = DataMapper.mapDetailToTVShowFavEntity(tvShowDetail)
        appExecutors.diskIO().execute { localDataSource.deleteTVShow(tvShowFav) }
    }
}