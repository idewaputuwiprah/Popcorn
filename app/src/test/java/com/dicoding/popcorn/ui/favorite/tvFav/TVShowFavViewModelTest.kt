package com.dicoding.popcorn.ui.favorite.tvFav

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.popcorn.data.PopcornRepository
import com.dicoding.popcorn.data.local.TVShowFavEntity
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
class TVShowFavViewModelTest {
    private lateinit var viewModel: TVShowFavViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var popcornRepository: PopcornRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TVShowFavEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TVShowFavEntity>

    @Before
    fun setup() {
        viewModel = TVShowFavViewModel(popcornRepository)
    }

    @Test
    fun getFavTVShows() {
        val dummyTVShows = pagedList
        `when`(dummyTVShows.size).thenReturn(5)
        val tvShows = MutableLiveData<PagedList<TVShowFavEntity>>()
        tvShows.value = dummyTVShows

        `when`(popcornRepository.getTVShowFav()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getFavTVShows().value
        verify(popcornRepository).getTVShowFav()
        assertNotNull(tvShowEntities)
        assertEquals(5, tvShowEntities?.size)

        viewModel.getFavTVShows().observeForever(observer)
        verify(observer).onChanged(dummyTVShows)
    }
}