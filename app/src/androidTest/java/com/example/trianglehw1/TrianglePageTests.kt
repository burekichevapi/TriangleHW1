package com.example.trianglehw1
import android.media.Image
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.trianglehw1.CustomMatchers.withImageDrawable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TrianglePageTests {
    @Rule
    @JvmField
    val mainActivityRule = ActivityTestRule(MainActivity::class.java)
    private lateinit var edtTriangleSideA : ViewInteraction
    private lateinit var edtTriangleSideB : ViewInteraction
    private lateinit var edtTriangleSideC : ViewInteraction
    private lateinit var btnClearResults : ViewInteraction
    private lateinit var ctrTriangleImage : ViewInteraction
    private lateinit var btnDisplayTriangle : ViewInteraction

    @Before
    fun setUp() {
        navigateToTrianglePage()
        initializeActivityObjects()
    }

    private fun navigateToTrianglePage() {
        ActivityScenario.launch(MainActivity::class.java)
        val startButton = onView(withId(R.id.btn_Start))
        startButton.perform(click())
    }

    private fun initializeActivityObjects() {
        edtTriangleSideA = onView(withId(R.id.edtTriangleSideA))
        edtTriangleSideB = onView(withId(R.id.edtTriangleSideB))
        edtTriangleSideC = onView(withId(R.id.edtTriangleSideC))
        btnClearResults = onView(withId(R.id.btnClearResults))
        ctrTriangleImage = onView(withId(R.id.ctrTriangleImage))
        btnDisplayTriangle = onView(withId(R.id.btnDisplayTriangle))
    }

    @Test
    fun fromStartupPage_canNavigateToTrianglePage() {
        onView(withId(R.id.triangle_fragment)).check(matches(isDisplayed()))
    }

    @Test
    fun hasLableFor_TriangleSideA() {
        onView(withId(R.id.lblTriangleSideA)).check(matches(isDisplayed()))
    }

    @Test
    fun hasLableFor_TriangleSideB() {
        onView(withId(R.id.lblTriangleSideB)).check(matches(isDisplayed()))
    }

    @Test
    fun hasLableFor_TriangleSideC() {
        onView(withId(R.id.lblTriangleSideC)).check(matches(isDisplayed()))
    }

    @Test
    fun hasButtonFor_SubmittingTriangleSides() {
        onView(withId(R.id.btnDisplayTriangle)).check(matches(isDisplayed()))
    }

    @Test
    fun hasCardViewFor_DisplayingTriangleImages() {
        onView(withId(R.id.ctrTriangleImage)).check(matches(isDisplayed()))
    }

    @Test
    fun editTriangleSideA_CannotInputAlpha() {
        edtTriangleSideA.perform(clearText(), typeText("abc"))

        edtTriangleSideA.check(matches(withText("")))
    }

    @Test
    fun editTriangleSideB_CannotInputAlpha() {
        edtTriangleSideB.perform(clearText(), typeText("abc"))

        edtTriangleSideB.check(matches(withText("")))
    }

    @Test
    fun editTriangleSideC_CannotInputAlpha() {
        edtTriangleSideC.perform(clearText(), typeText("abc"))

        edtTriangleSideC.check(matches(withText("")))
    }

    @Test
    fun editTriangleSideA_CanInputNumbers() {
        edtTriangleSideA.perform(clearText(), typeText("1"))

        edtTriangleSideA.check(matches(withText("1")))
    }

    @Test
    fun editTriangleSideB_CanInputNumbers() {
        edtTriangleSideB.perform(clearText(), typeText("1"))

        edtTriangleSideB.check(matches(withText("1")))
    }

    @Test
    fun editTriangleSideC_CanInputNumbers() {
        edtTriangleSideC.perform(clearText(), typeText("1"))

        edtTriangleSideC.check(matches(withText("1")))
    }

    @Test
    fun editTriangleSideA_CanInputDouble() {
        edtTriangleSideA.perform(clearText(), typeText("1.1"))

        edtTriangleSideA.check(matches(withText("1.1")))
    }

    @Test
    fun editTriangleSideB_CanInputDouble() {
        edtTriangleSideB.perform(clearText(), typeText("1.1"))

        edtTriangleSideB.check(matches(withText("1.1")))
    }

    @Test
    fun editTriangleSideC_CanInputDouble() {
        edtTriangleSideC.perform(clearText(), typeText("1.1"))

        edtTriangleSideC.check(matches(withText("1.1")))
    }

    @Test
    fun btnClearResults_WillMakeEdtTriangleSideBEmpty() {
        edtTriangleSideB.perform(clearText(), typeText("1.1"))

        btnClearResults.perform(click())

        edtTriangleSideB.check(matches(withText("")))
    }

    @Test
    fun btnClearResults_WillMakeEdtTriangleSideCEmpty() {
        edtTriangleSideC.perform(clearText(), typeText("1.1"))

        btnClearResults.perform(click())

        edtTriangleSideC.check(matches(withText("")))
    }

    @Test
    fun btnClearResults_WillMakeEdtTriangleSideAEmpty() {
        edtTriangleSideA.perform(clearText(), typeText("1.1"))

        btnClearResults.perform(click())

        edtTriangleSideA.check(matches(withText("")))
    }

    @Test
    fun ctrTriangleImage_WillShowPictureOfEquilateralTriangle_WhenAllSidesAreEqual() {
        edtTriangleSideA.perform(clearText(), typeText("1.1"))
        edtTriangleSideB.perform(clearText(), typeText("1.1"))
        edtTriangleSideC.perform(clearText(), typeText("1.1"))

        btnDisplayTriangle.perform(click())

        ctrTriangleImage.check(matches(withImageDrawable(R.drawable.equilateral_triangle)))
    }

    @Test
    fun ctrTriangleImage_WillShowPictureOfIsoscelesTriangle_When2SidesAreEqual() {
        edtTriangleSideA.perform(clearText(), typeText("1.2"))
        edtTriangleSideB.perform(clearText(), typeText("1.1"))
        edtTriangleSideC.perform(clearText(), typeText("1.1"))

        btnDisplayTriangle.perform(click())

        ctrTriangleImage.check(matches(withImageDrawable(R.drawable.isosceles_triangle)))
    }

    @Test
    fun ctrTriangleImage_WillShowPictureOfScaleneTriangle_WhenNoSidesAreEqual() {
        edtTriangleSideA.perform(clearText(), typeText("1.2"))
        edtTriangleSideB.perform(clearText(), typeText("1.3"))
        edtTriangleSideC.perform(clearText(), typeText("1.1"))

        btnDisplayTriangle.perform(click())

        ctrTriangleImage.check(matches(withImageDrawable(R.drawable.scalene_triangle)))
    }



}