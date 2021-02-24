package com.dicoding.popcorn.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.popcorn.BuildConfig
import com.dicoding.popcorn.data.ContentEntity
import com.dicoding.popcorn.data.MovieEntity
import com.dicoding.popcorn.data.PopcornRepository
import com.dicoding.popcorn.data.remote.MoviesResponse
import com.dicoding.popcorn.data.remote.ResultsItem
import com.dicoding.popcorn.data.remote.retrofit.ApiConfig
import com.dicoding.popcorn.utils.DataDummy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel() : ViewModel() {
    private val _movies = MutableLiveData<List<MovieEntity>>()
    val movies: LiveData<List<MovieEntity>> = _movies

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getRemoteMovie() {
        _isLoading.value = true
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
                when (response.code()) {
                    200 -> {
                        val movieResponse = response.body()?.results
                        mapMovies(movieResponse)
                    }
                    else -> {
                        Log.d("Movie API", response.message())
                    }
                }
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                _isLoading.value = false
                Log.d("Movie API", t.message.toString())
            }
        })
    }

//    fun getRepositoryMovies(): LiveData<List<MovieEntity>> {
//        return popcornRepository.getMovies()
//    }

    private fun mapMovies(movieResponse: List<ResultsItem>?) {
        val listMovies = ArrayList<MovieEntity>()
        if (movieResponse != null) {
            lateinit var movieEntity : MovieEntity
            for (movie in movieResponse) {
                movieEntity = MovieEntity(
                    movieId = movie.id.toString(),
                    title = movie.title,
                    rating = movie.voteAverage.toString(),
                    year = movie.releaseDate.take(4),
                    tags = movie.genreIds.joinToString(),
                    path = "https://image.tmdb.org/t/p/w500/${movie.posterPath}",
                    duration = "-"
                )
                movieEntity.detail = ContentEntity(
                    content = movie.overview,
                    director = "-",
                    writers = "-",
                    stars = "-"
                )
                listMovies.add(movieEntity)
            }
            _movies.value = listMovies
        }
    }

    fun getMovie(): List<MovieEntity> = DataDummy.generateDummyMovies()
}