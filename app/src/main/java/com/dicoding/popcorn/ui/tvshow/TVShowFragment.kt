package com.dicoding.popcorn.ui.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.idputuwiprah.core.data.Resource
import com.idputuwiprah.core.domain.model.Movie
import com.dicoding.popcorn.databinding.FragmentTVShowBinding
import com.dicoding.popcorn.ui.detail.DetailActivity
import com.dicoding.popcorn.ui.home.ItemCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TVShowFragment : Fragment() {
    private lateinit var fragmentTVShowBinding: FragmentTVShowBinding
    private lateinit var tvShowAdapter: TVShowAdapter
    private val viewModel: TVShowViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentTVShowBinding = FragmentTVShowBinding.inflate(inflater, container, false)
        return fragmentTVShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

        subscribeToObserver()

        fragmentTVShowBinding.progressBar.visibility = View.VISIBLE

        with(fragmentTVShowBinding.rvTvshows) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = tvShowAdapter
        }
    }

    private fun subscribeToObserver() {
        viewModel.getRemoteTVShows().observe(requireActivity(), { tvShows->
            if (tvShows != null) {
                when (tvShows) {
                    is Resource.Success -> {
                        tvShows.data?.let {
                            tvShowAdapter.listTVShows = it
                        }
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
    }
}