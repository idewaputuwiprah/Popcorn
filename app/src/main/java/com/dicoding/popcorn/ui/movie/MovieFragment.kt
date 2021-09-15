package com.dicoding.popcorn.ui.movie

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.idputuwiprah.core.domain.model.Movie
import com.idputuwiprah.core.data.Resource
import com.dicoding.popcorn.databinding.FragmentMovieBinding
import com.dicoding.popcorn.ui.detail.DetailActivity
import com.dicoding.popcorn.ui.home.ItemCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieFragment : Fragment() {
    private var page = 1
    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var movieAdapter: MovieAdapter
    private val currentList = ArrayList<Movie>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            movieAdapter = MovieAdapter()

            movieAdapter.setOnClickListener(object : ItemCallback{
                override fun onClick(data: Movie) {
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.apply {
                        putExtra(DetailActivity.ITEM_TYPE, DetailActivity.MOVIE_TYPE)
                        putExtra(DetailActivity.ITEM_ID, data.movieId)
                    }
                    startActivity(intent)
                }
            })

            showProgressBar()

            viewModel.getMovies(page)
            subscribeToObserver()

            with(fragmentMovieBinding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = movieAdapter
                addOnScrollListener(object : RecyclerView.OnScrollListener(){
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        if (!recyclerView.canScrollVertically(1)) {
                            page += 1
                            showProgressBar()
                            viewModel.getMovies(page)
                        }
                    }
                })
            }
        }
    }

    fun showProgressBar() {
        fragmentMovieBinding.progressBar.visibility = View.VISIBLE
    }

    private fun subscribeToObserver() {
        viewModel.movies.observe(requireActivity(), { movies->
            if (movies != null) {
                when (movies) {
                    is Resource.Success -> {
                        movies.data?.let {
                            if (currentList.hashCode() != it.hashCode())
                                currentList.addAll(it)
                            movieAdapter.setMovie(currentList)
                        }
                        fragmentMovieBinding.apply {
                            tvMoviesNull.visibility = View.GONE
                            progressBar.visibility = View.GONE
                        }
                    }
                    is Resource.Error -> {
                        fragmentMovieBinding.apply {
                            tvMoviesNull.visibility = View.VISIBLE
                            progressBar.visibility = View.GONE
                        }
                    }
                }
            }
        })
    }
}