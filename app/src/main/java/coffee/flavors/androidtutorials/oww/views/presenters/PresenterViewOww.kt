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

package coffee.flavors.androidtutorials.oww.views.presenters

import android.view.View
import coffee.flavors.androidtutorials.R
import coffee.flavors.androidtutorials.databinding.LayoutViewOwwDarkOkayBinding
import coffee.flavors.androidtutorials.databinding.LayoutViewOwwDarkOkayBindingImpl
import coffee.flavors.androidtutorials.databinding.LayoutViewOwwLightOkayBinding
import coffee.flavors.androidtutorials.databinding.LayoutViewOwwLightOkayBindingImpl
import coffee.flavors.androidtutorials.oww.tools.OwwUtil
import coffee.flavors.androidtutorials.oww.tools.ThemeCallbackIf
import coffee.flavors.androidtutorials.oww.views.ViewDeparture
import coffee.flavors.androidtutorials.oww.views.ViewOww
import com.google.android.material.snackbar.Snackbar
import java.lang.RuntimeException

/**
 * @author, evolandlupiz
 * @date, 3/3/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

/**
 **
 * @param activity as parent view.
 * @constructor provides initialized view.
 */
class PresenterViewOww(private val activity: ViewOww) {

    /**
     * Delegate as [mThemeCallbackIf].
     * @return ThemeCallbackIf.
     */
    private val mThemeCallbackIf: ThemeCallbackIf = this.activity

    /**
     * E when the FAB is clicked.
     * Displays a snackbar.
     */
    fun fireFab() {
        val snackbar = OwwUtil().fireDarkSnackbar(activity,"Enjoy the Demonstration.",Snackbar.LENGTH_SHORT,R.id.layout_view_oww_parent)
        OwwUtil().adjustSnackbarPosition(snackbar, activity.findViewById<View>(R.id.gd_oww_85_hor))
        snackbar.show()
    }

    /**
     * E when image button is clicked.
     * @return [Unit] new intent on [ViewDeparture]
     */
    fun fireImgBtn() {
        OwwUtil().fireIntent(activity,ViewDeparture::class.java)
    }

    /**
     * E when the theme is switch is switched.
     * Walk through logic to determine the dynamic binding,
     * then event on the theme that was selected.
     * @throws RuntimeException when the View isn't [ViewOww]
     */
    fun fireThemeSwitch() {
        when(this.activity.mBinding){
            is LayoutViewOwwDarkOkayBindingImpl -> {
                val darkcast = (this.activity.mBinding as LayoutViewOwwDarkOkayBinding)
                val darkstatus = darkcast.owwDarkNightlightMtrlSw.isEnabled
                mThemeCallbackIf.call(!darkstatus)
            }
            is LayoutViewOwwLightOkayBindingImpl -> {
                val lightcast = (this.activity.mBinding as LayoutViewOwwLightOkayBinding)
                val lightstatus = lightcast.owwLightNightlightMtrlSw.isEnabled
                mThemeCallbackIf.call(lightstatus)
            }
            else -> { throw RuntimeException("ViewOww.kt, unknown type :${this.activity.mBinding} for fireThemeSwitch() mBinding.") }
        }
    }
}