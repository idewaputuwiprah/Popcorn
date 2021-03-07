package com.dicoding.popcorn.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.popcorn.data.local.LocalDataSource
import com.dicoding.popcorn.data.local.MovieFavEntity
import com.dicoding.popcorn.data.local.TVShowFavEntity
import com.dicoding.popcorn.utils.AppExecutors
import com.dicoding.popcorn.utils.DataDummy
import com.dicoding.popcorn.utils.LiveDataTextUtil
import com.dicoding.popcorn.utils.PageListUtils
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PopcornRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val local = mock(LocalDataSource::class.java)
    private val appExecutor = mock(AppExecutors::class.java)

    @Mock
    private val popcornRepository = FakePopcornRepository(local, appExecutor)

    private val roomRepository = FakePopcornRepository(local, appExecutor)

    private val dummyMovies = DataDummy.generateDummyRemoteMovie()
    private val dummyMovieDetail = DataDummy.generateDummyMovieDetail()
    private val dummyMovieId = dummyMovieDetail.movieId.toInt()

    private val dummyTVShows = DataDummy.generateDummyRemoteTVShow()
    private val dummyTVShowDetail = DataDummy.generateDummyTVShowDetail()
    private val dummyTVShowId = dummyTVShowDetail.movieId.toInt()

    @Test
    fun getRemoteMovies() {
        val movies = MutableLiveData<List<MovieEntity>>()
        movies.value = dummyMovies

        `when`(popcornRepository.getRemoteMovies()).thenReturn(movies)
        val movieEntities = LiveDataTextUtil.getValue(popcornRepository.getRemoteMovies())
        verify(popcornRepository).getRemoteMovies()
        assertNotNull(movieEntities)
        assertEquals(dummyMovies.size, movieEntities.size)
    }

    @Test
    fun getDetailMovie() {
        val movieDetail = MutableLiveData<DetailEntity>()
        movieDetail.value = dummyMovieDetail

        `when`(popcornRepository.getDetailMovie(dummyMovieId)).thenReturn(movieDetail)
        val detailEntity = LiveDataTextUtil.getValue(popcornRepository.getDetailMovie(dummyMovieId))
        verify(popcornRepository).getDetailMovie(dummyMovieId)
        assertNotNull(detailEntity)
        assertEquals(dummyMovieDetail.title, detailEntity.title)
        assertEquals(dummyMovieDetail.year, detailEntity.year)
        assertEquals(dummyMovieDetail.rating, detailEntity.rating)
        assertEquals(dummyMovieDetail.duration, detailEntity.duration)
        assertEquals(dummyMovieDetail.content, detailEntity.content)
        assertEquals(dummyMovieDetail.director, detailEntity.director)
        assertEquals(dummyMovieDetail.writers, detailEntity.writers)
        assertEquals(dummyMovieDetail.stars, detailEntity.stars)
    }

    @Test
    fun getRemoteTVShows() {
        val tvShows = MutableLiveData<List<MovieEntity>>()
        tvShows.value = dummyTVShows

        `when`(popcornRepository.getRemoteTVShows()).thenReturn(tvShows)
        val tvShowEntities = LiveDataTextUtil.getValue(popcornRepository.getRemoteTVShows())
        verify(popcornRepository).getRemoteTVShows()
        assertNotNull(tvShowEntities)
        assertEquals(dummyTVShows.size, tvShowEntities.size)
    }

    @Test
    fun getDetailTVShows() {
        val tvShowDetail = MutableLiveData<DetailEntity>()
        tvShowDetail.value = dummyTVShowDetail

        `when`(popcornRepository.getDetailTVShows(dummyTVShowId)).thenReturn(tvShowDetail)
        val detailEntity = LiveDataTextUtil.getValue(popcornRepository.getDetailTVShows(dummyTVShowId))
        verify(popcornRepository).getDetailTVShows(dummyTVShowId)
        assertNotNull(detailEntity)
        assertEquals(dummyTVShowDetail.title, detailEntity.title)
        assertEquals(dummyTVShowDetail.year, detailEntity.year)
        assertEquals(dummyTVShowDetail.rating, detailEntity.rating)
        assertEquals(dummyTVShowDetail.duration, detailEntity.duration)
        assertEquals(dummyTVShowDetail.content, detailEntity.content)
        assertEquals(dummyTVShowDetail.director, detailEntity.director)
        assertEquals(dummyTVShowDetail.writers, detailEntity.writers)
        assertEquals(dummyTVShowDetail.stars, detailEntity.stars)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieFavEntity>
        `when`(local.getMovieFav()).thenReturn(dataSourceFactory)
        roomRepository.getMovieFav()

        val movieEntities = PageListUtils.mockPagedList(DataDummy.generateDummyRemoteMovie())
        verify(local).getMovieFav()
        assertNotNull(movieEntities)
        assertEquals(dummyMovies.size, movieEntities.size)
    }

    @Test
    fun getFavoriteTVShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVShowFavEntity>
        `when`(local.getTVShowFav()).thenReturn(dataSourceFactory)
        roomRepository.getTVShowFav()

        val tvShowEntities = PageListUtils.mockPagedList(DataDummy.generateDummyRemoteTVShow())
        verify(local).getTVShowFav()
        assertNotNull(tvShowEntities)
        assertEquals(dummyTVShows.size, tvShowEntities.size)
    }
}