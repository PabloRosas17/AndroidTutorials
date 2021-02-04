/*
 * Copyright (c) 2020 PabloRosas17 @ https://github.com/PabloRosas17
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package coffee.flavors.androidtutorials.ui

import android.os.Build
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import coffee.flavors.androidtutorials.R
import coffee.flavors.androidtutorials.oww.views.ViewOww
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

/**
 * @author, evolandlupiz
 * @date, 3/4/2020
 * @property, AndroidTutorials
 * @purpose, Simple test case to see if my snackbar text matches what i wish for.
 */

/*
@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(AndroidJUnit4::class)
@SmallTest
class SnackbarTest {

    @get:Rule public var activityScenarioRule: ActivityScenarioRule<ViewOww> = ActivityScenarioRule<ViewOww>(ViewOww::class.java)

    @Before
    fun intentsInit() {
        Intents.init()
    }

    @After
    fun intentsTeardown() {
        Intents.release()
    }

    @Test
    fun snackbar(){
        onView(withId(R.id.oww_fab)).perform(click())

        onView(withText("Enjoy the Demonstration.")).check(matches(isDisplayed()))
    }
}
 */