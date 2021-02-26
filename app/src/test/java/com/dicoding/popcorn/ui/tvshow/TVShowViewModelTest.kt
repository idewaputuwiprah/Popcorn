package com.dicoding.popcorn.ui.tvshow

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
class TVShowViewModelTest {
    private lateinit var viewModel: TVShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var popcornRepository: PopcornRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setup() {
        viewModel = TVShowViewModel(popcornRepository)
    }

    @Test
    fun getTVShow() {
        val dummyTVShow = DataDummy.generateDummyRemoteTVShow()
        val tvShows = MutableLiveData<List<MovieEntity>>()
        tvShows.value = dummyTVShow

        `when`(popcornRepository.getRemoteTVShows()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getRemoteTVShows().value
        assertNotNull(tvShowEntities)
        assertEquals(20, tvShowEntities?.size)

        viewModel.getRemoteTVShows().observeForever(observer)
        verify(observer).onChanged(dummyTVShow)
    }
}