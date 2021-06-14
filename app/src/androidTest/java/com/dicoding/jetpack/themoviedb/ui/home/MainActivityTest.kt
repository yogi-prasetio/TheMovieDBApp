package com.dicoding.jetpack.themoviedb.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.dicoding.jetpack.themoviedb.R
import com.dicoding.jetpack.themoviedb.utils.EspressoIdlingResource
import org.junit.*
import org.junit.runners.MethodSorters

class MainActivityTest {

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun testView() {
        onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.tv_show_navigation)).perform(ViewActions.click())
        onView(withId(R.id.rv_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        onView(withId(R.id.favorite_navigation)).perform(ViewActions.click())
        onView(withText(R.string.tv_shows)).perform(ViewActions.click())
        onView(withText(R.string.movies)).perform(ViewActions.click())

        onView(withId(R.id.movie_navigation)).perform(ViewActions.click())
    }

    @Test
    fun testLoadMovieAndTvShow() {
        onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(15))

        onView(withId(R.id.tv_show_navigation)).perform(ViewActions.click())
        onView(withId(R.id.rv_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rv_tv_show))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(15))

        onView(withId(R.id.movie_navigation)).perform(ViewActions.click())
    }

    @Test
    fun testDetailMovie() {
        onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2))
        onView(withId(R.id.rv_movie))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, ViewActions.click() ))

        onView(withId(R.id.img_poster))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_release))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_rating))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_description))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        pressBack()
    }

    @Test
    fun testDetailTvShow() {
        onView(withId(R.id.tv_show_navigation)).perform(ViewActions.click())
        onView(withId(R.id.rv_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rv_tv_show))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(2))
        onView(withId(R.id.rv_tv_show))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, ViewActions.click() ))

        onView(withId(R.id.img_poster))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_release))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_rating))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_description))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        pressBack()
    }

    @Test
    fun testInsertAndDeleteFavorite() {
        onView(withId(R.id.rv_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, ViewActions.click() ))
        onView(withId(R.id.toggleFavorite)).perform(ViewActions.click())
        Espresso.pressBack()

        onView(withId(R.id.tv_show_navigation)).perform(ViewActions.click())
        onView(withId(R.id.rv_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3, ViewActions.click() ))
        onView(withId(R.id.toggleFavorite)).perform(ViewActions.click())
        Espresso.pressBack()

        onView(withId(R.id.favorite_navigation)).perform(ViewActions.click())
        onView(withId(R.id.rv_favorite_movies))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rv_favorite_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click() ))
        onView(withId(R.id.toggleFavorite)).perform(ViewActions.click())
        Espresso.pressBack()

        onView(withId(R.id.favorite_navigation)).perform(ViewActions.click())
        onView(withText(R.string.tv_shows)).perform(ViewActions.click())
        onView(withId(R.id.rv_favorite_tv_shows))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rv_favorite_tv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click() ))
        onView(withId(R.id.toggleFavorite)).perform(ViewActions.click())
        Espresso.pressBack()
    }
}