package com.dicoding.popcorn.ui.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.popcorn.core.data.Resource
import com.dicoding.popcorn.core.domain.model.Movie
import com.dicoding.popcorn.databinding.FragmentTVShowBinding
import com.dicoding.popcorn.ui.detail.DetailActivity
import com.dicoding.popcorn.ui.home.ItemCallback
import com.dicoding.popcorn.core.ui.ViewModelFactory

class TVShowFragment : Fragment() {
    private lateinit var fragmentTVShowBinding: FragmentTVShowBinding
    private lateinit var tvShowAdapter: TVShowAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentTVShowBinding = FragmentTVShowBinding.inflate(inflater, container, false)
        return fragmentTVShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[TVShowViewModel::class.java]
        tvShowAdapter = TVShowAdapter()

        tvShowAdapter.setOnClickListener(object : ItemCallback{
            override fun onClick(data: Movie) {
                val intent = Intent(context, DetailActivity::class.java)
                intent.apply {
                    putExtra(DetailActivity.ITEM_TYPE, DetailActivity.TV_SHOW_TYPE)
                    putExtra(DetailActivity.ITEM_ID, data.movieId)
                }
                startActivity(intent)
            }
        })

        fragmentTVShowBinding.progressBar.visibility = View.VISIBLE

        viewModel.getRemoteTVShows().observe(requireActivity(), { tvShows->
            if (tvShows != null) {
                when (tvShows) {
                    is Resource.Success -> {
                        tvShowAdapter.setShows(tvShows.data)
                        fragmentTVShowBinding.apply {
                            tvTvshowsNull.visibility = View.GONE
                            progressBar.visibility = View.GONE
                        }
                    }
                    is Resource.Error -> {
                        fragmentTVShowBinding.apply {
                            tvTvshowsNull.visibility = View.VISIBLE
                            progressBar.visibility = View.GONE
                        }
                    }
                }
            }
        })

        with(fragmentTVShowBinding.rvTvshows) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = tvShowAdapter
        }
    }
}