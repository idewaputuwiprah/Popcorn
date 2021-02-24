package com.dicoding.popcorn.ui.tvshow

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TVShowViewModelTest {
    private lateinit var viewModel: TVShowViewModel

    @Before
    fun setup() {
        viewModel = TVShowViewModel()
    }

    @Test
    fun getTVShow() {
        val tvShowEntities = viewModel.getTVShow()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities.size)
    }
}