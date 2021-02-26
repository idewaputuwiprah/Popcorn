package com.dicoding.popcorn.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.popcorn.databinding.FragmentMovieBinding
import com.dicoding.popcorn.viewmodels.ViewModelFactory

class MovieFragment : Fragment() {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false)
        return fragmentMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            val adapter = MovieAdapter()

            viewModel.getLoadingStatus().observe(requireActivity(), {
                fragmentMovieBinding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
            })

            viewModel.getRemoteMovies().observe(requireActivity(), { movies->
                if (movies.isNotEmpty()) {
                    adapter.setMovie(movies)
                    adapter.notifyDataSetChanged()
                    fragmentMovieBinding.tvMoviesNull.visibility = View.INVISIBLE
                }
                else fragmentMovieBinding.tvMoviesNull.visibility = View.VISIBLE
            })

            with(fragmentMovieBinding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }
}