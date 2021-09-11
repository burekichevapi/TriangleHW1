package com.example.trianglehw1


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
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
    fun StartupPageLabelDisplays() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        //Setup
        val textView = onView(withId(R.id.label_Title))

        //Verify
        textView.check(matches(withSubstring("Triangle App")))

    }

    @Test
    fun StartupPageDisplaysPurpose() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        //Setup
        val textView = onView(withId(R.id.label_AppPurpose))

        //Verify
        textView.check(matches(withSubstring("Purpose:")))
        textView.check(matches(withSubstring("The TriangleApp will display the different types of triangles that can be created depending on the inputted triangle side lengths:")))
        textView.check(matches(withSubstring("Scalene")))
        textView.check(matches(withSubstring("No sides of equal lengths")))
        textView.check(matches(withSubstring("No equal angles")))
        textView.check(matches(withSubstring("No lines of symmetry")))
        textView.check(matches(withSubstring("Isosceles")))
        textView.check(matches(withSubstring("Two sides of equal lengths")))
        textView.check(matches(withSubstring("Two equal angles")))
        textView.check(matches(withSubstring("One lines of symmetry")))
        textView.check(matches(withSubstring("Equilateral")))
        textView.check(matches(withSubstring("Three sides of equal lengths")))
        textView.check(matches(withSubstring("Three angles, all equal to 60°")))
        textView.check(matches(withSubstring("Three lines of symmetry")))
//        textView.check(matches(withSubstring("Usage:")))
//        textView.check(matches(withSubstring("Input Values - The user will be able to input values  between 0.1 and 100.")))
//        textView.check(matches(withSubstring("Navigation Bar - Will allow users to refresh, navigate between the screens, and contains the Donation Button.")))
//        textView.check(matches(withSubstring("Clear Button - Will allow users to erase previous inputs and outputs.")))
//        textView.check(matches(withSubstring("Display Triangle Button - Will display the type of triangle and an image of the triangle in the output window.")))
//        textView.check(matches(withSubstring("Donation Button - Will redirect users to the donation screen where users can input their information to donate.")))
//        textView.check(matches(withSubstring("Exit Button - Will terminate the TriangleApp")))

    }

    @Test
    fun StartupPageDisplaysUsage() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        //Setup
        val textView = onView(withId(R.id.label_AppUsage))

        //Verify
        textView.check(matches(withSubstring("Usage:")))
        textView.check(matches(withSubstring("Inputted Values - The user will be able to input values between 0.1 and 100.")))
        textView.check(matches(withSubstring("Navigation Bar - Will allow users to refresh, navigate between the screens, and contains the Donation Button.")))
        textView.check(matches(withSubstring("Clear Button - Will allow users to erase previous inputs and outputs.")))
        textView.check(matches(withSubstring("Display Triangle Button - Will display the type of triangle and an image of the triangle in the output window.")))
        textView.check(matches(withSubstring("Donation Button - Will redirect users to the donation screen where users can input their information to donate.")))
        textView.check(matches(withSubstring("Exit Button - Will terminate the TriangleApp")))

    }
}
