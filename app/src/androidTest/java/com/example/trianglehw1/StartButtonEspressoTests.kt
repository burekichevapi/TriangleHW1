package com.example.trianglehw1


import android.view.View
import android.view.ViewGroup
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class StartButtonEspressoTests {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun startButtonIsDisplayed() {
        //Setup
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        val startButton = onView(withId(R.id.btn_Start))

        //Verify
        startButton.check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun startButtonNavigatesToTriangleFragment() {
        //Setup
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        val startButton = onView(withId(R.id.btn_Start))
        startButton.perform(click())

        //Verify
        onView(withId(R.id.triangle_fragment)).check(ViewAssertions.matches(isDisplayed()))
    }
    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
