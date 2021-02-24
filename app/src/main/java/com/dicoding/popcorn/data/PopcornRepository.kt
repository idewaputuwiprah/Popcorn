package com.dicoding.popcorn.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.popcorn.BuildConfig
import com.dicoding.popcorn.data.remote.MoviesResponse
import com.dicoding.popcorn.data.remote.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PopcornRepository(): PopcornDataSource {

    companion object {
        @Volatile
        private var instance: PopcornRepository? = null

        fun getInstance(): PopcornRepository =
            instance ?: synchronized(this) {
                instance ?: PopcornRepository()
            }
    }

    private val movieList = MutableLiveData<List<MovieEntity>>()

    override fun getMovies(): LiveData<List<MovieEntity>> {
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
                                    path = "https://image.tmdb.org/t/p/w500/${movie.posterPath}",
                                    duration = "-"
                                )
                                movieEntity.detail = ContentEntity(
                                    content = movie.overview,
                                    director = "-",
                                    writers = "-",
                                    stars = "-"
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
                Log.d("Movie API", t.message.toString())
            }
        })
        return movieList
    }
}