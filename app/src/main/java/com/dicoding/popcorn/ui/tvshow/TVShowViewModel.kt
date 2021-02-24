package com.dicoding.popcorn.ui.tvshow

import androidx.lifecycle.ViewModel
import com.dicoding.popcorn.data.MovieEntity
import com.dicoding.popcorn.utils.DataDummy

class TVShowViewModel : ViewModel() {

    fun getTVShow() : List<MovieEntity> {
        return DataDummy.generateDummyTVShows()
    }
}