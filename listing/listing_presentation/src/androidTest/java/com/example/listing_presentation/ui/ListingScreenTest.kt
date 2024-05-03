package com.example.listing_presentation.ui

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.listing_presentation.ListingActivity
import com.example.listing_presentation.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4ClassRunner::class)
@HiltAndroidTest
class ListingScreenTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    private lateinit var activity: ActivityScenario<ListingActivity>

    @Before
    fun setUp() {
        activity = ActivityScenario.launch(ListingActivity::class.java)
        activity.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun test_IsActivityInView() {
        Espresso.onView(withId(R.id.container))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun test_IsRecyclerInView() {
        Espresso.onView(withId(R.id.rvUniversity)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}