package com.dicoding.popcorn.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.popcorn.core.domain.model.Movie
import com.dicoding.popcorn.core.data.Resource
import com.dicoding.popcorn.core.domain.usecase.PopcornUseCase

class TVShowViewModel(private val popcornUseCase: PopcornUseCase) : ViewModel() {

    fun getRemoteTVShows(): LiveData<Resource<List<Movie>>> = popcornUseCase.getRemoteTVShows()

}