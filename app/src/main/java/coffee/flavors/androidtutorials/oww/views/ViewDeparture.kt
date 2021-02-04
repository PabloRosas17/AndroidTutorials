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

package coffee.flavors.androidtutorials.oww.views

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import coffee.flavors.androidtutorials.R
import coffee.flavors.androidtutorials.databinding.LayoutViewOwwLightDepartureBinding
import coffee.flavors.androidtutorials.oww.tools.OwwUtil
import coffee.flavors.androidtutorials.oww.tools.constants.StoryBoardConstants.DEPARTURE_SECONDS
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

/**
 * @author, evolandlupiz
 * @date, 3/3/2020
 * @property, AndroidTutorials
 * @purpose, Storyboard departure.
 */

/**
 * This class serves as the storyboard departure.
 * @return Activity.
 */
class ViewDeparture: AppCompatActivity() {

    /**
     * Adds a [mBinding] to this.
     * @return promised binding.
     */
    private lateinit var mBinding: LayoutViewOwwLightDepartureBinding

    /**
     * Does bindings and then launches a thread to gracefully end the departured activity.
     * @param savedInstanceState as state.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.fireUiBindings()
        this.onEndStoryBoard()
    }

    /**
     * Ui will bind itself to layouts, for consistency.
     * Binding is generated through BR class, this will set the view through binding
     * Execute pending bindings.
     */
    private fun fireUiBindings() {
        this.mBinding = DataBindingUtil.setContentView(this, R.layout.layout_view_oww_light_departure)
        this.mBinding.executePendingBindings()
    }

    /**
     * Thread launcher that displays a snackbar on the activities end.
     */
    private fun onEndStoryBoard() {
        val snackbar = OwwUtil().fireLightSnackbar(this,"Until next time.",Snackbar.LENGTH_SHORT,R.id.layout_view_departure_parent)
        snackbar.anchorView = this.findViewById(R.id.gd_departure_view_75_hor)
        snackbar.show()

        val handler = Handler().postDelayed({ this@ViewDeparture.finishAffinity()
        }, DEPARTURE_SECONDS)
    }
}