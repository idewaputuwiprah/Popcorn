package com.idputuwiprah.favorite.tvFav

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
import com.dicoding.popcorn.databinding.FragmentTVShowBinding
import com.dicoding.popcorn.di.FavoriteModuleDependencies
import com.dicoding.popcorn.ui.detail.DetailActivity
import com.dicoding.popcorn.ui.detail.DetailActivity.Companion.TV_SHOW_TYPE
import com.dicoding.popcorn.ui.home.ItemCallback
import com.dicoding.popcorn.ui.tvshow.TVShowAdapter
import com.idputuwiprah.favorite.DaggerFavoriteComponent
import com.idputuwiprah.favorite.viewModel.ViewModelFactory
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class TVShowFavFragment : Fragment() {
    private lateinit var fragmentTVShowBinding: FragmentTVShowBinding
    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: TVShowFavViewModel by viewModels{ factory }
    private lateinit var tvShowAdapter: TVShowAdapter

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
        fragmentTVShowBinding = FragmentTVShowBinding.inflate(inflater, container, false)
        return fragmentTVShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvShowAdapter = TVShowAdapter()

        tvShowAdapter.setOnClickListener(object : ItemCallback {
            override fun onClick(data: Movie) {
                val intent = Intent(context, Class.forName("com.dicoding.popcorn.ui.detail.DetailActivity"))
                intent.apply {
                    putExtra(DetailActivity.ITEM_TYPE, TV_SHOW_TYPE)
                    putExtra(DetailActivity.ITEM_ID, data.movieId)
                }
                startActivity(intent)
            }
        })

        setUpTVShowObserver()

        with(fragmentTVShowBinding.rvTvshows) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = tvShowAdapter
        }
    }

    override fun onResume() {
        super.onResume()
        if (!viewModel.getFavTVShows().hasActiveObservers()) {
            setUpTVShowObserver()
        }
    }

    private fun setUpTVShowObserver() {
        viewModel.getFavTVShows().observe(requireActivity(), { tvShows->
            tvShows?.let {
                tvShowAdapter.listTVShows = it
            }
            if (tvShows.isNotEmpty()) {
                fragmentTVShowBinding.tvTvshowsNull.visibility = View.GONE
            }
            else fragmentTVShowBinding.tvTvshowsNull.visibility = View.VISIBLE
        })
    }
}