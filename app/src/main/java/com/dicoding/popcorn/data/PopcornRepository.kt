package com.dicoding.popcorn.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.popcorn.BuildConfig
import com.dicoding.popcorn.data.local.LocalDataSource
import com.dicoding.popcorn.data.local.MovieFavEntity
import com.dicoding.popcorn.data.local.TVShowFavEntity
import com.dicoding.popcorn.data.remote.*
import com.dicoding.popcorn.data.remote.retrofit.ApiConfig
import com.dicoding.popcorn.utils.AppExecutors
import com.dicoding.popcorn.utils.EspressoIdlingResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopcornRepository(
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): PopcornDataSource {

    companion object {
        @Volatile
        private var instance: PopcornRepository? = null

        fun getInstance(localData: LocalDataSource, appExecutors: AppExecutors): PopcornRepository =
            instance ?: synchronized(this) {
                instance ?: PopcornRepository(localData, appExecutors)
            }
    }

    private val movieDetail = MutableLiveData<DetailEntity>()

    private val tvShowList = MutableLiveData<List<MovieEntity>>()
    private val tvShowDetail = MutableLiveData<DetailEntity>()

    private val _isLoading = MutableLiveData<Boolean>()

    fun getLoadingStatus(): LiveData<Boolean> = _isLoading

    override suspend fun getRemoteMovies(): List<MovieEntity> {
        withContext(Dispatchers.Main){ _isLoading.value = true }
        val movies = ArrayList<MovieEntity>()
        EspressoIdlingResource.increment()
        withContext(Dispatchers.IO) {
            val client = ApiConfig.getApiService().getMovieList(
                apiKey = BuildConfig.API_KEY,
                language = "en-US",
                sortBy = "popularity.desc",
                includeAdult = false,
                includeVideo = false,
                page = 1
            )
            withContext(Dispatchers.Main) { _isLoading.value = false }
            EspressoIdlingResource.decrement()
            when (client.code()) {
                200 -> {
                    for (movie in client.body()!!.results) {
                        val movieEntity = MovieEntity(
                            movieId = movie.id.toString(),
                            title = movie.title,
                            rating = movie.voteAverage.toString(),
                            year = movie.releaseDate.take(4),
                            tags = movie.genreIds.joinToString(),
                            path = "https://image.tmdb.org/t/p/w500${movie.posterPath}",
                            duration = "-"
                        )
                        movies.add(movieEntity)
                    }
                }
                else -> Log.d("Movie API", client.message())
            }
        }
        return movies
    }

    override suspend fun getDetailMovie(id: Int): DetailEntity {
        withContext(Dispatchers.Main) { _isLoading.value = true }
        var detailEntity: DetailEntity? = null
        EspressoIdlingResource.increment()
        withContext(Dispatchers.IO) {
            val client = ApiConfig.getApiService().getMovieDetail(
                id = id,
                apiKey = BuildConfig.API_KEY,
                language = "en-US"
            )
            withContext(Dispatchers.Main) { _isLoading.value = false }
            EspressoIdlingResource.decrement()
            when (client.code()) {
                200 -> {
                    val detailResponse = client.body()!!
                    detailEntity = DetailEntity(
                        movieId = detailResponse.id.toString(),
                        title = detailResponse.title,
                        rating = detailResponse.voteAverage.toString(),
                        year = detailResponse.releaseDate.take(4),
                        tags = getTags(detailResponse.genres),
                        path = "https://image.tmdb.org/t/p/w500${detailResponse.posterPath}",
                        duration = getDuration(detailResponse.runtime),
                        content = detailResponse.overview,
                        director = "-",
                        writers = "-",
                        stars = "-",
                        backdrop = "https://image.tmdb.org/t/p/w500${detailResponse.backdropPath}"
                    )
                }
                else -> Log.d("Detail Movie API", client.message())
            }
        }
        return detailEntity as DetailEntity
    }

    override fun getRemoteTVShows(): LiveData<List<MovieEntity>> {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getTVShowList(
                apiKey = BuildConfig.API_KEY,
                language = "en-US",
                sortBy = "popularity.desc",
                page = 1,
                timezone = "America/New_York",
                includeNullAirDates = false
        )
        client.enqueue(object : Callback<TVShowsResponse>{
            override fun onResponse(call: Call<TVShowsResponse>, response: Response<TVShowsResponse>) {
                _isLoading.value = false
                if (response.code() == 200) {
                    val tvShowResponse = response.body()?.results
                    val tvShows = ArrayList<MovieEntity>()
                    if (tvShowResponse != null) {
                        lateinit var tvShowEntity : MovieEntity
                        for (tvShow in tvShowResponse) {
                            tvShowEntity = MovieEntity(
                                    movieId = tvShow.id.toString(),
                                    title = tvShow.name,
                                    rating = tvShow.voteAverage.toString(),
                                    year = tvShow.firstAirDate.take(4),
                                    tags = tvShow.genreIds.joinToString(),
                                    path = "https://image.tmdb.org/t/p/w500${tvShow.posterPath}",
                                    duration = "-"
                            )
                            tvShows.add(tvShowEntity)
                        }
                        tvShowList.value = tvShows
                    }
                } else {
                    Log.d("TV Shows API", response.message())
                }
            }

            override fun onFailure(call: Call<TVShowsResponse>, t: Throwable) {
                _isLoading.value = false
                Log.d("TV Shows API", t.message.toString())
            }
        })
        return tvShowList
    }

    override fun getDetailTVShows(id: Int): LiveData<DetailEntity> {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getTVShowsDetail(
                id = id,
                apiKey = BuildConfig.API_KEY,
                language = "en-US"
        )
        client.enqueue(object : Callback<DetailTVShowsResponse>{
            override fun onResponse(call: Call<DetailTVShowsResponse>, response: Response<DetailTVShowsResponse>) {
                _isLoading.value = false
                if (response.code() == 200) {
                    val detailResponse = response.body()
                    if (detailResponse != null) {
                        val detailEntity = DetailEntity(
                                movieId = detailResponse.id.toString(),
                                title = detailResponse.name,
                                rating = detailResponse.voteAverage.toString(),
                                year = detailResponse.firstAirDate.take(4),
                                tags = getTags(detailResponse.genres),
                                path = "https://image.tmdb.org/t/p/w500${detailResponse.posterPath}",
                                duration = getDuration(detailResponse.episodeRunTime),
                                content = detailResponse.overview,
                                director = "-",
                                writers = "-",
                                stars = "-",
                                backdrop = "https://image.tmdb.org/t/p/w500${detailResponse.backdropPath}"
                        )
                        tvShowDetail.value = detailEntity
                    }
                } else {
                    Log.d("Detail TV API", response.message())
                }
            }

            override fun onFailure(call: Call<DetailTVShowsResponse>, t: Throwable) {
                _isLoading.value = false
                Log.d("Detail TV API", t.message.toString())
            }
        })
        return tvShowDetail
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

    override fun insertMovieFav(movieFav: List<MovieFavEntity>) {
        appExecutors.diskIO().execute { localDataSource.insertMovieFav(movieFav) }
    }

    override fun insertTVShowFav(tvShowFav: List<TVShowFavEntity>) {
        appExecutors.diskIO().execute { localDataSource.insertTVShowFav(tvShowFav) }
    }

    override fun deleteMovieFav(movieFavEntity: MovieFavEntity) {
        appExecutors.diskIO().execute { localDataSource.deleteMovie(movieFavEntity) }
    }

    override fun deleteTVShowFav(tvShowFavEntity: TVShowFavEntity) {
        appExecutors.diskIO().execute { localDataSource.deleteTVShow(tvShowFavEntity) }
    }

    private fun getDuration(duration: Int): String {
        val hour = duration / 60
        val minute = duration % 60
        return "${hour}h ${minute}min"
    }

    private fun getDuration(durations: List<Int>): String = "${durations[0]}min"

    private fun getTags(genres: List<GenresItem>): List<String> {
        val listGenre = ArrayList<String>()
        for (genre in genres) listGenre.add(genre.name)
        return listGenre
    }
}