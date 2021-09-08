package com.example.trianglehw1


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class StartupPageTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun startupPageTest() {
        val textView = onView(
            allOf(
                withId(R.id.label_AppPurposeUsage),
                withParent(withParent(withId(R.id.fragment_container))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Purpose and Usage of app")))

        //TODO: We can do further tests below if we want to
        /*val textView2 = onView(
            allOf(
                withId(R.id.triangle), withText("startup fragment"),
                withParent(withParent(withId(R.id.fragment_container))),
                isDisplayed()
            )
        )

        textView2.check(matches(withText("TEST_OUR_PURPOSE_AND_USAGE_TEXT")))
        */
    }
}
