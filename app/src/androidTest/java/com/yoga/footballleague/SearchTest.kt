package com.yoga.footballleague

import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule

import com.yoga.footballleague.fragment.LeagueFragment
import com.yoga.footballleague.main.MainActivity
import com.yoga.footballleague.R.id.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class SearchTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)



    @Test
    fun inputTeam(){
        onView(withId(spinn_liga))
            .check(matches(isDisplayed()))
        onView(withId(bt_league)).perform(click())

        onView(withId(edt_search))
            .perform(typeText("Liverpool"), closeSoftKeyboard())
        onView(withId(btn_search)).perform(click())
    }
}