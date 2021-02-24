package com.dicoding.popcorn.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.popcorn.R
import com.dicoding.popcorn.utils.DataDummy
import org.junit.Before
import org.junit.Test

class HomeActivityTest {
    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTVShows = DataDummy.generateDummyTVShows()

    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_item_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_title)).check(matches(withText(dummyMovies[0].title)))

        onView(withId(R.id.tv_item_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_year)).check(matches(withText(dummyMovies[0].year)))

        onView(withId(R.id.tv_item_tags)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_tags)).check(matches(withText(dummyMovies[0].tags)))

        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText(dummyMovies[0].rating)))

        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText(dummyMovies[0].duration)))

        onView(withId(R.id.tv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail)).check(matches(withText(dummyMovies[0].detail?.content)))

        onView(withId(R.id.tv_director)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_director)).check(matches(withText(dummyMovies[0].detail?.director)))

        onView(withId(R.id.tv_writers)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_writers)).check(matches(withText(dummyMovies[0].detail?.writers)))

        onView(withId(R.id.tv_stars)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_stars)).check(matches(withText(dummyMovies[0].detail?.stars)))
    }

    @Test
    fun loadTVShows() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTVShows.size))
    }

    @Test
    fun loadDetailTVShow() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.tv_item_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_title)).check(matches(withText(dummyTVShows[0].title)))

        onView(withId(R.id.tv_item_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_year)).check(matches(withText(dummyTVShows[0].year)))

        onView(withId(R.id.tv_item_tags)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_item_tags)).check(matches(withText(dummyTVShows[0].tags)))

        onView(withId(R.id.tv_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_rating)).check(matches(withText(dummyTVShows[0].rating)))

        onView(withId(R.id.tv_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_duration)).check(matches(withText(dummyTVShows[0].duration)))

        onView(withId(R.id.tv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail)).check(matches(withText(dummyTVShows[0].detail?.content)))

        onView(withId(R.id.tv_director)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_director)).check(matches(withText(dummyTVShows[0].detail?.director)))

        onView(withId(R.id.tv_writers)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_writers)).check(matches(withText(dummyTVShows[0].detail?.writers)))

        onView(withId(R.id.tv_stars)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_stars)).check(matches(withText(dummyTVShows[0].detail?.stars)))
    }
}