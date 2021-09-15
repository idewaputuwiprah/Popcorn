package com.dicoding.popcorn.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.idputuwiprah.core.data.Resource
import com.idputuwiprah.core.domain.model.Movie
import com.idputuwiprah.core.domain.usecase.PopcornUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val popcornUseCase: PopcornUseCase) : ViewModel() {
    private val movieFlow = Channel<Resource<List<Movie>>>(Channel.BUFFERED)
    val movies = movieFlow.receiveAsFlow().asLiveData()

    fun getMovies(page: Int) {
        viewModelScope.launch {
            popcornUseCase.getRemoteMovies(page)
                .collect {
                    movieFlow.send(it)
                }
        }
    }
}