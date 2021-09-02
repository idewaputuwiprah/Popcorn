package com.dicoding.popcorn.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.popcorn.core.data.local.LocalDataSource
import com.dicoding.popcorn.core.data.local.entity.MovieFavEntity
import com.dicoding.popcorn.core.data.local.entity.TVShowFavEntity
import com.dicoding.popcorn.core.data.remote.RemoteDataSource
import com.dicoding.popcorn.core.data.remote.response.GenresItem
import com.dicoding.popcorn.core.data.remote.network.ApiResponse
import com.dicoding.popcorn.core.domain.model.Detail
import com.dicoding.popcorn.core.domain.model.Movie
import com.dicoding.popcorn.core.domain.repository.IPopcornRepository
import com.dicoding.popcorn.core.utils.AppExecutors
import com.dicoding.popcorn.core.utils.DataMapper

class PopcornRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IPopcornRepository {

    companion object {
        @Volatile
        private var instance: PopcornRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): PopcornRepository =
            instance ?: synchronized(this) {
                instance ?: PopcornRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getRemoteMovies(): LiveData<Resource<List<Movie>>> {
        val result = MediatorLiveData<Resource<List<Movie>>>()
        val apiResponse = remoteDataSource.getMovies()
        result.addSource(apiResponse) { response->
            result.removeSource(apiResponse)
            when (response) {
                is ApiResponse.SUCCESS -> {
                    val movieList = DataMapper.mapMovieResponseToMovies(response.data)
                    result.value = Resource.Success(movieList)
                }
                is ApiResponse.ERROR -> {
                    result.value = Resource.Error(response.errorMessage, null)
                }
                is ApiResponse.Empty -> {
                    result.value = Resource.Success(emptyList())
                }
            }
        }
        return result
    }

    override fun getDetailMovie(id: Int): LiveData<Resource<Detail>> {
        val result = MediatorLiveData<Resource<Detail>>()
        val apiResponse = remoteDataSource.getMovieDetail(id)
        result.addSource(apiResponse) { response->
            when (response) {
                is ApiResponse.SUCCESS -> {
                    val detail = DataMapper.mapDetailMovieResponseToDetailEntity(response.data)
                    result.value = Resource.Success(detail)
                }
                is ApiResponse.ERROR -> {
                    result.value = Resource.Error(response.errorMessage, null)
                }
                else -> Unit
            }
        }
        return result
    }

    override fun getRemoteTVShows(): LiveData<Resource<List<Movie>>> {
        val result = MediatorLiveData<Resource<List<Movie>>>()
        val apiResponse = remoteDataSource.getTVShows()
        result.addSource(apiResponse) { response->
            result.removeSource(apiResponse)
            when (response) {
                is ApiResponse.SUCCESS -> {
                    val tvShowList = DataMapper.mapTVShowResponseToMovies(response.data)
                    result.value = Resource.Success(tvShowList)
                }
                is ApiResponse.ERROR -> {
                    result.value = Resource.Error(response.errorMessage)
                }
                is ApiResponse.Empty -> {
                    result.value = Resource.Success(emptyList())
                }
            }
        }
        return result
    }

    override fun getDetailTVShows(id: Int): LiveData<Resource<Detail>> {
        val result = MediatorLiveData<Resource<Detail>>()
        val apiResponse = remoteDataSource.getTVShowDetail(id)
        result.addSource(apiResponse) { response->
            when (response) {
                is ApiResponse.SUCCESS -> {
                    val detail = DataMapper.mapDetailTVShowResponseToDetailEntity(response.data)
                    result.value = Resource.Success(detail)
                }
                is ApiResponse.ERROR -> {
                    result.value = Resource.Error(response.errorMessage)
                }
                else -> Unit
            }
        }
        return result
    }

    override fun getMovieFav(): LiveData<PagedList<MovieFavEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getMovieFav(), config).build()
    }

    override fun getMovieFavById(movieId: String): LiveData<MovieFavEntity> = localDataSource.getMovieFavById(movieId)

    override fun getTVShowFav(): LiveData<PagedList<TVShowFavEntity>> {
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build()
        return LivePagedListBuilder(localDataSource.getTVShowFav(), config).build()
    }

    override fun getTVShowFavById(tvId: String): LiveData<TVShowFavEntity> = localDataSource.getTVShowFavById(tvId)

    override fun insertMovieFav(movieFav: MovieFavEntity) {
        appExecutors.diskIO().execute { localDataSource.insertMovieFav(movieFav) }
    }

    override fun insertTVShowFav(tvShowFav: TVShowFavEntity) {
        appExecutors.diskIO().execute { localDataSource.insertTVShowFav(tvShowFav) }
    }

    override fun deleteMovieFav(movieFavEntity: MovieFavEntity) {
        appExecutors.diskIO().execute { localDataSource.deleteMovie(movieFavEntity) }
    }

    override fun deleteTVShowFav(tvShowFavEntity: TVShowFavEntity) {
        appExecutors.diskIO().execute { localDataSource.deleteTVShow(tvShowFavEntity) }
    }
}