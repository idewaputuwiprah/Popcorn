package com.dicoding.popcorn.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.popcorn.data.DetailEntity
import com.dicoding.popcorn.data.PopcornRepository
import com.dicoding.popcorn.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import kotlin.jvm.Throws

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    @get:Rule
    var thrown: ExpectedException = ExpectedException.none()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var popcornRepository: PopcornRepository

    @Mock
    private lateinit var observer: Observer<DetailEntity>

    @Before
    fun setup() {
        viewModel = DetailViewModel(popcornRepository)
    }

    @Test
    fun getMovie() {
        val dummyDetail = DataDummy.generateDummyMovieDetail()
        val detail = MutableLiveData<DetailEntity>()
        detail.value = dummyDetail
        viewModel.setItem(dummyDetail.movieId)

        `when`(popcornRepository.getDetailMovie(dummyDetail.movieId.toInt())).thenReturn(detail)
        val movieEntity = viewModel.getRemoteMovieDetail().value
        verify(popcornRepository).getDetailMovie(dummyDetail.movieId.toInt())
        assertNotNull(movieEntity)
        assertEquals(dummyDetail.title, movieEntity?.title)
        assertEquals(dummyDetail.year, movieEntity?.year)
        assertEquals(dummyDetail.tags, movieEntity?.tags)
        assertEquals(dummyDetail.rating, movieEntity?.rating)
        assertEquals(dummyDetail.duration, movieEntity?.duration)
        assertEquals(dummyDetail.content, movieEntity?.content)
        assertEquals(dummyDetail.director, movieEntity?.director)
        assertEquals(dummyDetail.writers, movieEntity?.writers)
        assertEquals(dummyDetail.stars, movieEntity?.stars)

        viewModel.getRemoteMovieDetail().observeForever(observer)
        verify(observer).onChanged(dummyDetail)
    }

    @Test
    @Throws(UninitializedPropertyAccessException::class)
    fun emptyIDMovie() {
        val dummyDetail = DataDummy.generateDummyMovieDetail()
        val detail = MutableLiveData<DetailEntity>()
        detail.value = dummyDetail

        thrown.expect(UninitializedPropertyAccessException::class.java)
        thrown.expectMessage("lateinit property itemId has not been initialized")

        `when`(popcornRepository.getDetailMovie(dummyDetail.movieId.toInt())).thenReturn(detail)
        val movieEntity = viewModel.getRemoteMovieDetail().value
        verify(popcornRepository).getDetailMovie(dummyDetail.movieId.toInt())

        assertEquals(dummyDetail.title, movieEntity?.title)
        assertEquals(dummyDetail.year, movieEntity?.year)
        assertEquals(dummyDetail.tags, movieEntity?.tags)
        assertEquals(dummyDetail.rating, movieEntity?.rating)
        assertEquals(dummyDetail.duration, movieEntity?.duration)
        assertEquals(dummyDetail.content, movieEntity?.content)
        assertEquals(dummyDetail.director, movieEntity?.director)
        assertEquals(dummyDetail.writers, movieEntity?.writers)
        assertEquals(dummyDetail.stars, movieEntity?.stars)
    }

    @Test
    fun getTVShow() {
        val dummyDetail = DataDummy.generateDummyTVShowDetail()
        val detail = MutableLiveData<DetailEntity>()
        detail.value = dummyDetail
        viewModel.setItem(dummyDetail.movieId)

        `when`(popcornRepository.getDetailTVShows(dummyDetail.movieId.toInt())).thenReturn(detail)
        val showEntity = viewModel.getRemoteTVShowDetail().value
        verify(popcornRepository).getDetailTVShows(dummyDetail.movieId.toInt())

        assertNotNull(showEntity)
        assertEquals(dummyDetail.title, showEntity?.title)
        assertEquals(dummyDetail.year, showEntity?.year)
        assertEquals(dummyDetail.tags, showEntity?.tags)
        assertEquals(dummyDetail.rating, showEntity?.rating)
        assertEquals(dummyDetail.duration, showEntity?.duration)
        assertEquals(dummyDetail.content, showEntity?.content)
        assertEquals(dummyDetail.director, showEntity?.director)
        assertEquals(dummyDetail.writers, showEntity?.writers)
        assertEquals(dummyDetail.stars, showEntity?.stars)

        viewModel.getRemoteTVShowDetail().observeForever(observer)
        verify(observer).onChanged(dummyDetail)
    }

    @Test
    @Throws(UninitializedPropertyAccessException::class)
    fun emptyIDTVShow() {
        val dummyDetail = DataDummy.generateDummyTVShowDetail()
        val detail = MutableLiveData<DetailEntity>()
        detail.value = dummyDetail

        thrown.expect(UninitializedPropertyAccessException::class.java)
        thrown.expectMessage("lateinit property itemId has not been initialized")

        `when`(popcornRepository.getDetailTVShows(dummyDetail.movieId.toInt())).thenReturn(detail)
        val showEntity = viewModel.getRemoteTVShowDetail().value
        verify(popcornRepository).getDetailTVShows(dummyDetail.movieId.toInt())
        assertEquals(dummyDetail.title, showEntity?.title)
        assertEquals(dummyDetail.year, showEntity?.year)
        assertEquals(dummyDetail.tags, showEntity?.tags)
        assertEquals(dummyDetail.rating, showEntity?.rating)
        assertEquals(dummyDetail.duration, showEntity?.duration)
    }
}