package com.dicoding.popcorn.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.idputuwiprah.core.domain.model.Movie
import com.idputuwiprah.core.data.Resource
import com.idputuwiprah.core.domain.usecase.PopcornUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TVShowViewModel @Inject constructor(private val popcornUseCase: PopcornUseCase) : ViewModel() {

    fun getRemoteTVShows(): LiveData<Resource<List<Movie>>> = popcornUseCase.getRemoteTVShows().asLiveData()

}