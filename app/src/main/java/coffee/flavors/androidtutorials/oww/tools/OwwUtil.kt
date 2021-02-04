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

package coffee.flavors.androidtutorials.oww.tools

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import coffee.flavors.androidtutorials.R
import com.google.android.material.snackbar.Snackbar

/**
 * @author, evolandlupiz
 * @date, 3/2/2020
 * @property, AndroidTutorials
 * @purpose, Un-categorized utility.
 */

/**
 * Utility.
 */
class OwwUtil {

    /**
     * @desc generalized methods to fire intents, useful to keep track of all initiators.
     *  @param activity is the calling activity , type @param [T] is the class type of the caller
     */
    fun <T : AppCompatActivity> fireIntent(activity: AppCompatActivity, type: Class<T>) {
        val mIntent = Intent(activity, type)
        activity.startActivity(mIntent)
        activity.finish()
    }

    /**
     * Styles the snackbar.
     * @param view as the activity.
     * @param msg as the message.
     * @param duration as the time to show.
     * @param id as the parent.
     * @return the snackbar as a light [Snackbar].
     */
    fun fireLightSnackbar(view: Activity, msg: String, duration: Int, id: Int): Snackbar {
        val snackbar = Snackbar.make(view.findViewById(id),msg, duration)
        snackbar.setBackgroundTint(view.resources.getColor(R.color.colorLightGhostLight, null))
        snackbar.setTextColor(view.resources.getColor(R.color.colorLightPrimaryDark, null))
        return snackbar
    }

    /**
     * Styles the snackbar.
     * @param view as the activity.
     * @param msg as the message.
     * @param duration as the time to show.
     * @param id as the parent.
     * @return the snackbar as a dark [Snackbar].
     */
    fun fireDarkSnackbar(view: Activity, msg: String, duration: Int, id: Int): Snackbar {
        val snackbar = Snackbar.make(view.findViewById(id),msg, duration)
        snackbar.setBackgroundTint(view.resources.getColor(R.color.colorLightGhostDark, null))
        snackbar.setTextColor(view.resources.getColor(R.color.colorLightBackground, null))
        return snackbar
    }

    /**
     * Renders the snackbar at an adjusted location.
     * @param sb as the snackbar.
     * @param gl as the guideline.
     */
    fun adjustSnackbarPosition(sb: Snackbar, gl: View) {
        val sl = sb.view
        val slp = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        slp.setMargins(0, gl.y.toInt(), 0, 0)
        sl.layoutParams = slp
    }
}