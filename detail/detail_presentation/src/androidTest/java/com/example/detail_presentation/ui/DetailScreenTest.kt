package com.example.detail_presentation.ui

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.detail_presentation.DetailActivity
import com.example.detail_presentation.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
class DetailScreenTest {
    private lateinit var activity: ActivityScenario<DetailActivity>

    @Before
    fun setUp() {
        activity = ActivityScenario.launch(DetailActivity::class.java)
        activity.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun test_IsActivityInView() {
        Espresso.onView(ViewMatchers.withId(R.id.container))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test_IsRefreshButtonInView() {
        Espresso.onView(ViewMatchers.withId(R.id.ivRefresh)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    @Test
    fun test_IsUniversityTvInView() {
        Espresso.onView(ViewMatchers.withId(R.id.tvUniversity)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    @Test
    fun test_IsStateTvInView() {
        Espresso.onView(ViewMatchers.withId(R.id.tvState)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    @Test
    fun test_IsCountryTvInView() {
        Espresso.onView(ViewMatchers.withId(R.id.tvCountry)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    @Test
    fun test_IsCountryCodeTvInView() {
        Espresso.onView(ViewMatchers.withId(R.id.tvCountryCode)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    @Test
    fun test_IsWebTvInView() {
        Espresso.onView(ViewMatchers.withId(R.id.tvWebPage)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

}