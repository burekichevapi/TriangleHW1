package com.example.trianglehw1


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
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
class EndToEndTests {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)
//

    @Test
    fun NegativeEndToEndTest() {
        //Arrange
        val sideA = "3"
        val sideB = "2"
        val sideC = "40"
        val expectedText = "Invalid Triangle! All sides must be >= 0.1 and the sum of its two sides must be greater than the third side."

        //Act
        Act(sideA, sideB, sideC)

        //Assert
        Verify(expectedText)
    }

    @Test
    fun ScaleneEndToEndTest() {
        //Arrange
        val sideA = "3"
        val sideB = "4"
        val sideC = "2"
        val expectedText = "A triangle where all sides are of a different length."

        //Act
        Act(sideA, sideB, sideC)

        //Assert
        Verify(expectedText)
    }

    @Test
    fun IsoscelesEndToEndTest() {
        //Arrange
        val sideA = "3"
        val sideB = "2"
        val sideC = "2"
        val expectedText = "A triangle where only two sides are of equal length."

        //Act
        Act(sideA, sideB, sideC)

        //Assert
        Verify(expectedText)
    }

    @Test
    fun EquilateralEndToEndTest() {
        //Arrange
        val sideA = "1"
        val sideB = "1"
        val sideC = "1"
        val expectedText = "A triangle where all three sides are equal length."

        //Act
        Act(sideA, sideB, sideC)

        //Assert
        Verify(expectedText)
    }

    private fun Verify(expectedText: String) {
        val textView = onView(
            allOf(
                withId(R.id.lblTriangleError),
                withParent(
                    allOf(
                        withId(R.id.triangle_fragment),
                        withParent(withId(R.id.fragment_container))
                    )
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText(expectedText)))
    }

    private fun Act(sideA: String ,sideB: String, sideC:String) {
        val materialButton = onView(
            allOf(
                withId(R.id.btn_Start), withText("Start"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.fragment_container),
                        0
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.edtTriangleSideA),
                childAtPosition(
                    allOf(
                        withId(R.id.triangle_fragment),
                        childAtPosition(
                            withId(R.id.fragment_container),
                            0
                        )
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText(sideA), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.edtTriangleSideB),
                childAtPosition(
                    allOf(
                        withId(R.id.triangle_fragment),
                        childAtPosition(
                            withId(R.id.fragment_container),
                            0
                        )
                    ),
                    5
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText(sideB), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.edtTriangleSideC),
                childAtPosition(
                    allOf(
                        withId(R.id.triangle_fragment),
                        childAtPosition(
                            withId(R.id.fragment_container),
                            0
                        )
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText(sideC), closeSoftKeyboard())

        val materialButton2 = onView(
            allOf(
                withId(R.id.btnDisplayTriangle), withText("Display Triangle"),
                childAtPosition(
                    allOf(
                        withId(R.id.triangle_fragment),
                        childAtPosition(
                            withId(R.id.fragment_container),
                            0
                        )
                    ),
                    7
                ),
                isDisplayed()
            )
        )
        materialButton2.perform(click())

//        val textView = onView(
//            allOf(
//                withId(R.id.lblTriangleError),
//                //withText("A triangle where all three sides are equal length."),
//                withParent(
//                    allOf(
//                        withId(R.id.triangle_fragment),
//                        withParent(withId(R.id.fragment_container))
//                    )
//                ),
//                isDisplayed()
//            )
//        )
//        textView.check(matches(withText(expectedText)))
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
