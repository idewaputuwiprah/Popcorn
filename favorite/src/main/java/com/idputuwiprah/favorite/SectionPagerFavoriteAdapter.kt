package com.idputuwiprah.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dicoding.popcorn.R
import com.idputuwiprah.favorite.movieFav.MovieFavFragment
import com.idputuwiprah.favorite.tvFav.TVShowFavFragment

class SectionPagerFavoriteAdapter(private val mContext: Context, fm: FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int = TABS_TITLE.size

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MovieFavFragment()
            1 -> TVShowFavFragment()
            else -> Fragment()
        }
    }

    fun getPageTitle(position: Int): CharSequence =mContext.resources.getString(TABS_TITLE[position])

    companion object {
        @StringRes
        private val TABS_TITLE = intArrayOf(R.string.movies_fav, R.string.tv_shows_fav)
    }
}