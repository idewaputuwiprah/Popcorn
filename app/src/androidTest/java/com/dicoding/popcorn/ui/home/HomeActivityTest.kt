package com.dicoding.popcorn.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.popcorn.R
import com.dicoding.popcorn.data.MovieEntity
import com.dicoding.popcorn.utils.DataDummy
import com.dicoding.popcorn.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {
    private val dummyRemoteMovies = DataDummy.generateDummyRemoteMovie()
    private val dummyRemoteMoviesDetail = DataDummy.generateDummyMovieDetail()

    private val dummyRemoteTVShows = DataDummy.generateDummyRemoteTVShow()
    private val dummyRemoteTVShowsDetail = DataDummy.generateDummyTVShowDetail()

    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyRemoteMovies.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_item_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_title)).check(matches(withText(dummyRemoteMoviesDetail.title)))

        onView(withId(R.id.tv_item_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_year)).check(matches(withText(dummyRemoteMoviesDetail.year)))

        onView(withId(R.id.tv_item_tags)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_tags)).check(matches(withText(dummyRemoteMoviesDetail.tags.joinToString())))

        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText(dummyRemoteMoviesDetail.rating)))

        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText(dummyRemoteMoviesDetail.duration)))

        onView(withId(R.id.tv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail)).check(matches(withText(dummyRemoteMoviesDetail.content)))

        onView(withId(R.id.tv_director)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_director)).check(matches(withText(dummyRemoteMoviesDetail.director)))

        onView(withId(R.id.tv_writers)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_writers)).check(matches(withText(dummyRemoteMoviesDetail.writers)))

        onView(withId(R.id.tv_stars)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_stars)).check(matches(withText(dummyRemoteMoviesDetail.stars)))
    }

    @Test
    fun loadTVShows() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyRemoteTVShows.size))
    }

    @Test
    fun loadDetailTVShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tv_item_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_title)).check(matches(withText(dummyRemoteTVShowsDetail.title)))

        onView(withId(R.id.tv_item_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_year)).check(matches(withText(dummyRemoteTVShowsDetail.year)))

        onView(withId(R.id.tv_item_tags)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_tags)).check(matches(withText(dummyRemoteTVShowsDetail.tags.joinToString())))

        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText(dummyRemoteTVShowsDetail.rating)))

        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText(dummyRemoteTVShowsDetail.duration)))

        onView(withId(R.id.tv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail)).check(matches(withText(dummyRemoteTVShowsDetail.content)))

        onView(withId(R.id.tv_director)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_director)).check(matches(withText(dummyRemoteTVShowsDetail.director)))

        onView(withId(R.id.tv_writers)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_writers)).check(matches(withText(dummyRemoteTVShowsDetail.writers)))

        onView(withId(R.id.tv_stars)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_stars)).check(matches(withText(dummyRemoteTVShowsDetail.stars)))
    }
}