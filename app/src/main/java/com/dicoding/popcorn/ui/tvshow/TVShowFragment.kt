package com.dicoding.popcorn.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.popcorn.databinding.FragmentTVShowBinding
import com.dicoding.popcorn.viewmodels.ViewModelFactory

class TVShowFragment : Fragment() {
    private lateinit var fragmentTVShowBinding: FragmentTVShowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentTVShowBinding = FragmentTVShowBinding.inflate(inflater, container, false)
        return fragmentTVShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[TVShowViewModel::class.java]
        val adapter = TVShowAdapter()

        viewModel.getLoadingStatus().observe(requireActivity(), {
            fragmentTVShowBinding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.getRemoteTVShows().observe(requireActivity(), { tvShows->
            if (tvShows.isNotEmpty()) {
                adapter.setShows(tvShows)
                adapter.notifyDataSetChanged()
                fragmentTVShowBinding.tvTvshowsNull.visibility = View.GONE
            }
            else fragmentTVShowBinding.tvTvshowsNull.visibility = View.VISIBLE
        })

        with(fragmentTVShowBinding.rvTvshows) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            this.adapter = adapter
        }
    }
}