package com.dicoding.popcorn.ui.detail

import com.dicoding.popcorn.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.ExpectedException
import kotlin.jvm.Throws

class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTVShows = DataDummy.generateDummyTVShows()

    @get:Rule
    var thrown: ExpectedException = ExpectedException.none()

    @Before
    fun setup() {
        viewModel = DetailViewModel()
    }

    @Test
    fun getMovie() {
        val movieID = DataDummy.generateDummyMovies()[0].movieId
        viewModel.setItem(movieID)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovies[0].title, movieEntity.title)
        assertEquals(dummyMovies[0].year, movieEntity.year)
        assertEquals(dummyMovies[0].tags, movieEntity.tags)
        assertEquals(dummyMovies[0].rating, movieEntity.rating)
        assertEquals(dummyMovies[0].duration, movieEntity.duration)

        val content = movieEntity.detail
        val dummyContent = dummyMovies[0].detail
        assertNotNull(content)
        assertEquals(dummyContent?.content, content?.content)
        assertEquals(dummyContent?.director, content?.director)
        assertEquals(dummyContent?.writers, content?.writers)
        assertEquals(dummyContent?.stars, content?.stars)
    }

    @Test
    @Throws(UninitializedPropertyAccessException::class)
    fun emptyIDMovie() {
        thrown.expect(UninitializedPropertyAccessException::class.java)
        thrown.expectMessage("lateinit property itemId has not been initialized")
        val movieEntity = viewModel.getMovie()
        assertEquals(dummyMovies[0].title, movieEntity.title)
        assertEquals(dummyMovies[0].year, movieEntity.year)
        assertEquals(dummyMovies[0].tags, movieEntity.tags)
        assertEquals(dummyMovies[0].rating, movieEntity.rating)
        assertEquals(dummyMovies[0].duration, movieEntity.duration)
    }

    @Test
    fun getTVShow() {
        val showID = DataDummy.generateDummyTVShows()[0].movieId
        viewModel.setItem(showID)
        val showEntity = viewModel.getTVShow()
        assertNotNull(showEntity)
        assertEquals(dummyTVShows[0].title, showEntity.title)
        assertEquals(dummyTVShows[0].year, showEntity.year)
        assertEquals(dummyTVShows[0].tags, showEntity.tags)
        assertEquals(dummyTVShows[0].rating, showEntity.rating)
        assertEquals(dummyTVShows[0].duration, showEntity.duration)

        val content = showEntity.detail
        val dummyContent = dummyTVShows[0].detail
        assertNotNull(content)
        assertEquals(dummyContent?.content, content?.content)
        assertEquals(dummyContent?.director, content?.director)
        assertEquals(dummyContent?.writers, content?.writers)
        assertEquals(dummyContent?.stars, content?.stars)
    }

    @Test
    @Throws(UninitializedPropertyAccessException::class)
    fun emptyIDTVShow() {
        thrown.expect(UninitializedPropertyAccessException::class.java)
        thrown.expectMessage("lateinit property itemId has not been initialized")
        val showEntity = viewModel.getTVShow()
        assertEquals(dummyTVShows[0].title, showEntity.title)
        assertEquals(dummyTVShows[0].year, showEntity.year)
        assertEquals(dummyTVShows[0].tags, showEntity.tags)
        assertEquals(dummyTVShows[0].rating, showEntity.rating)
        assertEquals(dummyTVShows[0].duration, showEntity.duration)
    }
}