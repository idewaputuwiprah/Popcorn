package com.dicoding.popcorn.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.popcorn.BuildConfig
import com.dicoding.popcorn.data.remote.*
import com.dicoding.popcorn.data.remote.retrofit.ApiConfig
import com.dicoding.popcorn.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FakePopcornRepository(): PopcornDataSource {

    private val movieList = MutableLiveData<List<MovieEntity>>()
    private val movieDetail = MutableLiveData<DetailEntity>()

    private val tvShowList = MutableLiveData<List<MovieEntity>>()
    private val tvShowDetail = MutableLiveData<DetailEntity>()

    private val _isLoading = MutableLiveData<Boolean>()

    fun getLoadingStatus(): LiveData<Boolean> = _isLoading

    override fun getRemoteMovies(): LiveData<List<MovieEntity>> {
        _isLoading.value = true
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getMovieList(
            apiKey = BuildConfig.API_KEY,
            language = "en-US",
            sortBy = "popularity.desc",
            includeAdult = false,
            includeVideo = false,
            page = 1
        )
        client.enqueue(object : Callback<MoviesResponse>{
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                _isLoading.value = false
                EspressoIdlingResource.decrement()
                when (response.code()) {
                    200 -> {
                        val movieResponse = response.body()?.results
                        val movies = ArrayList<MovieEntity>()
                        if (movieResponse != null) {
                            lateinit var movieEntity : MovieEntity
                            for (movie in movieResponse) {
                                movieEntity = MovieEntity(
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
                            movieList.value = movies
                        }
                    }
                    else -> {
                        Log.d("Movie API", response.message())
                    }
                }
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                _isLoading.value = false
                EspressoIdlingResource.decrement()
                Log.d("Movie API", t.message.toString())
            }
        })
        return movieList
    }

    override fun getDetailMovie(id: Int): LiveData<DetailEntity> {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getMovieDetail(
                id = id,
                apiKey = BuildConfig.API_KEY,
                language = "en-US"
        )
        client.enqueue(object : Callback<DetailMovieResponse>{
            override fun onResponse(call: Call<DetailMovieResponse>, response: Response<DetailMovieResponse>) {
                _isLoading.value = false
                if (response.code() == 200) {
                    val detailResponse = response.body()
                    if (detailResponse != null) {
                        val detailEntity = DetailEntity(
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
                                stars = "-"
                        )
                        movieDetail.value = detailEntity
                    }
                } else {
                    Log.d("Detail Movie API", response.message())
                }
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                _isLoading.value = false
                Log.d("Detail Movie API", t.message.toString())
            }

        })
        return movieDetail
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
                                stars = "-"
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