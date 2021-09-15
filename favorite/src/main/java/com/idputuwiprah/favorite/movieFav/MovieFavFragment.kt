package com.idputuwiprah.favorite.movieFav

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.idputuwiprah.core.domain.model.Movie
import com.dicoding.popcorn.databinding.FragmentMovieBinding
import com.dicoding.popcorn.di.FavoriteModuleDependencies
import com.dicoding.popcorn.ui.detail.DetailActivity
import com.dicoding.popcorn.ui.detail.DetailActivity.Companion.MOVIE_TYPE
import com.dicoding.popcorn.ui.home.ItemCallback
import com.dicoding.popcorn.ui.movie.MovieAdapter
import com.idputuwiprah.favorite.DaggerFavoriteComponent
import com.idputuwiprah.favorite.viewModel.ViewModelFactory
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class MovieFavFragment : Fragment() {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: MovieFavViewModel by viewModels { factory }
    private lateinit var movieAdapter: MovieAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFavoriteComponent.builder()
            .context(requireContext())
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    requireContext().applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            movieAdapter = MovieAdapter()

            movieAdapter.setOnClickListener(object : ItemCallback {
                override fun onClick(data: Movie) {
                    val intent = Intent(context, Class.forName("com.dicoding.popcorn.ui.detail.DetailActivity"))
                    intent.apply {
                        putExtra(DetailActivity.ITEM_TYPE, MOVIE_TYPE)
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
            movies?.let {
                movieAdapter.listMovies = it
            }
            if (movies.isNotEmpty()) {
                fragmentMovieBinding.tvMoviesNull.visibility = View.INVISIBLE
            }
            else fragmentMovieBinding.tvMoviesNull.visibility = View.VISIBLE
        })
    }
}