package com.dicoding.popcorn.ui.favorite.movieFav

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.popcorn.core.domain.model.Movie
import com.dicoding.popcorn.databinding.FragmentMovieBinding
import com.dicoding.popcorn.ui.detail.DetailActivity
import com.dicoding.popcorn.core.ui.ViewModelFactory
import com.dicoding.popcorn.ui.home.ItemCallback
import com.dicoding.popcorn.ui.movie.MovieAdapter

class MovieFavFragment : Fragment() {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    private lateinit var viewModel: MovieFavViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MovieFavViewModel::class.java]
            movieAdapter = MovieAdapter()

            movieAdapter.setOnClickListener(object : ItemCallback {
                override fun onClick(data: Movie) {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.apply {
                        putExtra(DetailActivity.ITEM_TYPE, DetailActivity.MOVIE_TYPE)
                        putExtra(DetailActivity.ITEM_ID, data.movieId)
                    }
                    startActivity(intent)
                }
            })

            setUpMovieObserver()

            with(fragmentMovieBinding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = movieAdapter
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (!viewModel.getFavMovies().hasActiveObservers()) {
            setUpMovieObserver()
        }
    }

    private fun setUpMovieObserver() {
        viewModel.getFavMovies().observe(requireActivity(), { movies->
            movieAdapter.setMovie(movies)
            if (movies.isNotEmpty()) {
                fragmentMovieBinding.tvMoviesNull.visibility = View.INVISIBLE
            }
            else fragmentMovieBinding.tvMoviesNull.visibility = View.VISIBLE
        })
    }
}