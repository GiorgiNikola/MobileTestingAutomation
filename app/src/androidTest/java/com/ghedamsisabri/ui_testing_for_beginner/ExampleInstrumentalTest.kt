package com.ghedamsisabri.ui_testing_for_beginner

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isViewDisplayed
import com.ghedamsisabri.ui_testing_for_beginner.Helper.tap
import org.hamcrest.Matcher
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentalTest {

    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun validateSecondPage() {
        Assert.assertTrue(activityMainTitle.isViewDisplayed())
        NextBtn.tap()
        Assert.assertTrue(secondPageActivity.isViewDisplayed())
        Assert.assertTrue(BackBtn.isViewDisplayed())
    }

    @Test
    fun validateMainPage() {
        Assert.assertTrue(activityMainTitle.isViewDisplayed())
        NextBtn.tap()
        BackBtn.tap()
        Assert.assertTrue(activityMainTitle.isViewDisplayed())
        Assert.assertTrue(NextBtn.isViewDisplayed())
    }

    companion object{
        val activityMainTitle:Matcher<View> by lazy { withId(R.id.activity_main_title) }
        val NextBtn: Matcher<View> by lazy { withId(R.id.button_next_activity) }
        val secondPageActivity: Matcher<View> by lazy { withId(R.id.activity_secondary_title) }
        val BackBtn: Matcher<View> by lazy { withId(R.id.button_back) }
    }
}