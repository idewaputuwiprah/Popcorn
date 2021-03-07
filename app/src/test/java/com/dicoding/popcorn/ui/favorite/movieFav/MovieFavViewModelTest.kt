package com.dicoding.popcorn.ui.favorite.movieFav

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.popcorn.data.PopcornRepository
import com.dicoding.popcorn.data.local.MovieFavEntity
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
class MovieFavViewModelTest {
    private lateinit var viewModel: MovieFavViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var popcornRepository: PopcornRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieFavEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieFavEntity>

    @Before
    fun setup() {
        viewModel = MovieFavViewModel(popcornRepository)
    }

    @Test
    fun getFavMovies() {
        val dummyMovies = pagedList
        `when`(dummyMovies.size).thenReturn(5)
        val movies = MutableLiveData<PagedList<MovieFavEntity>>()
        movies.value = dummyMovies

        `when`(popcornRepository.getMovieFav()).thenReturn(movies)
        val movieEntities = viewModel.getFavMovies().value
        verify(popcornRepository).getMovieFav()
        assertNotNull(movieEntities)
        assertEquals(5, movieEntities?.size)

        viewModel.getFavMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}