package com.dicoding.popcorn.ui.home

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.popcorn.R
import com.dicoding.popcorn.ui.movie.MovieFragment
import com.dicoding.popcorn.ui.tvshow.TVShowFragment

class SectionPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        @StringRes
        private val TABS_TITLE = intArrayOf(R.string.movies, R.string.tv_shows)
    }

    override fun getCount(): Int = TABS_TITLE.size

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> MovieFragment()
            1 -> TVShowFragment()
            else -> Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence =mContext.resources.getString(TABS_TITLE[position])
}