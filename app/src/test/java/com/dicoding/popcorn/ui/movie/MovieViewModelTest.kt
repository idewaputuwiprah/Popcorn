package com.dicoding.popcorn.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.popcorn.data.MovieEntity
import com.dicoding.popcorn.data.PopcornRepository
import com.dicoding.popcorn.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var popcornRepository: PopcornRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setup() {
        viewModel = MovieViewModel(popcornRepository)
    }

    @Test
    fun getMovie() {
        val dummyMovie = DataDummy.generateDummyRemoteMovie()
        val movies = MutableLiveData<List<MovieEntity>>()
        movies.value = dummyMovie

        `when`(popcornRepository.getRemoteMovies()).thenReturn(movies)
        val movieEntities = viewModel.getRemoteMovies().value
        verify(popcornRepository).getRemoteMovies()
        assertNotNull(movieEntities)
        assertEquals(20, movieEntities?.size)

        viewModel.getRemoteMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}