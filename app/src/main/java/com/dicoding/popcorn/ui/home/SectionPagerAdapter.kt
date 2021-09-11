package com.dicoding.popcorn.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dicoding.popcorn.R
import com.dicoding.popcorn.ui.movie.MovieFragment
import com.dicoding.popcorn.ui.tvshow.TVShowFragment

class SectionPagerAdapter(private val mContext: Context, fm: FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = TABS_TITLE.size

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MovieFragment()
            1 -> TVShowFragment()
            else -> Fragment()
        }
    }

    fun getPageTitle(position: Int): CharSequence = mContext.resources.getString(TABS_TITLE[position])

    companion object {
        @StringRes
        private val TABS_TITLE = intArrayOf(R.string.movies, R.string.tv_shows)
    }

}