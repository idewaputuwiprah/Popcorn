package com.idputuwiprah.core.utils

import com.idputuwiprah.core.data.local.entity.MovieFavEntity
import com.idputuwiprah.core.data.local.entity.TVShowFavEntity
import com.idputuwiprah.core.domain.model.Detail
import com.idputuwiprah.core.domain.model.Movie
import com.idputuwiprah.core.data.remote.response.*

object DataMapper {
    fun mapMovieResponseToMovies(input: List<ResultsItem>): List<Movie> {
        val movies = ArrayList<Movie>()
        input.map { movie->
            val movieEntity = Movie(
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
        return movies
    }

    fun mapTVShowResponseToMovies(input: List<ResultsTVItem>): List<Movie> {
        val tvShows = ArrayList<Movie>()
        input.map { tvShow->
            val movieEntity = Movie(
                movieId = tvShow.id.toString(),
                title = tvShow.name,
                rating = tvShow.voteAverage.toString(),
                year = tvShow.firstAirDate.take(4),
                tags = tvShow.genreIds.joinToString(),
                path = "https://image.tmdb.org/t/p/w500${tvShow.posterPath}",
                duration = "-"
            )
            tvShows.add(movieEntity)
        }
        return tvShows
    }

    fun mapDetailMovieResponseToDetailEntity(input: DetailMovieResponse) =
        Detail(
            movieId = input.id.toString(),
            title = input.title,
            rating = input.voteAverage.toString(),
            year = input.releaseDate.take(4),
            tags = getTags(input.genres),
            path = "https://image.tmdb.org/t/p/w500${input.posterPath}",
            duration = getDuration(input.runtime),
            content = input.overview,
            director = "-",
            writers = "-",
            stars = "-",
            backdrop = "https://image.tmdb.org/t/p/w500${input.backdropPath}"
        )

    fun mapDetailTVShowResponseToDetailEntity(input: DetailTVShowsResponse) =
        Detail (
            movieId = input.id.toString(),
            title = input.name,
            rating = input.voteAverage.toString(),
            year = input.firstAirDate.take(4),
            tags = getTags(input.genres),
            path = "https://image.tmdb.org/t/p/w500${input.posterPath}",
            duration = "${input.episodeRunTime.size} episode",
            content = input.overview,
            director = "-",
            writers = "-",
            stars = "-",
            backdrop = "https://image.tmdb.org/t/p/w500${input.backdropPath}"
        )

    fun mapMovieFavEntitiesToMovie(input: List<MovieFavEntity>): List<Movie> =
        input.map { movie->
            Movie(
                movieId = movie.movieId,
                title = movie.title,
                rating = movie.rating,
                year = movie.year,
                tags = movie.tags,
                path = movie.path,
                duration = "-"
            )
        }

    fun mapTVShowFavEntitiesToMovie(input: List<TVShowFavEntity>): List<Movie> =
        input.map { tvShow->
            Movie(
                movieId = tvShow.tvShowId,
                title = tvShow.title,
                rating = tvShow.rating,
                year = tvShow.year,
                tags = tvShow.tags,
                path = tvShow.path,
                duration = "-"
            )
        }

    fun mapMovieFavEntityToMovie(input: MovieFavEntity?): Movie? =
        input?.let {
            Movie(
                movieId = it.movieId,
                title = input.title,
                rating = input.rating,
                year = input.year,
                tags = input.tags,
                path = input.path,
                duration = "-"
            )
        }

    fun mapTVShowFavEntityToMovie(input: TVShowFavEntity?): Movie? =
        input?.let {
            Movie(
                movieId = it.tvShowId,
                title = input.title,
                rating = input.rating,
                year = input.year,
                tags = input.tags,
                path = input.path,
                duration = "-"
            )
        }

    fun mapDetailToMovieFavEntity(input: Detail) =
        MovieFavEntity(
            movieId = input.movieId,
            title = input.title,
            rating = input.rating,
            year = input.year,
            tags = input.tags.joinToString(),
            path = input.path,
            duration = input.duration
        )

    fun mapDetailToTVShowFavEntity(input: Detail) =
        TVShowFavEntity(
            tvShowId = input.movieId,
            title = input.title,
            rating = input.rating,
            year = input.year,
            tags = input.tags.joinToString(),
            path = input.path,
            duration = input.duration
        )

    private fun getDuration(duration: Int): String {
        val hour = duration / 60
        val minute = duration % 60
        return "${hour}h ${minute}min"
    }

    private fun getTags(genres: List<GenresItem>): List<String> {
        val listGenre = ArrayList<String>()
        for (genre in genres) listGenre.add(genre.name)
        return listGenre
    }
}