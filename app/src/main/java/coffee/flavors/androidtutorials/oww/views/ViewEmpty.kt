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
import coffee.flavors.androidtutorials.databinding.LayoutViewOwwLightEmptyBinding
import coffee.flavors.androidtutorials.oww.tools.OwwUtil
import coffee.flavors.androidtutorials.oww.tools.ViewBinderIf
import coffee.flavors.androidtutorials.oww.tools.constants.StoryBoardConstants
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

/**
 * @author, evolandlupiz
 * @date, 3/3/2020
 * @property, AndroidTutorials
 * @purpose, Network empty response.
 */

/**
 * State based class that renders an empty view.
 * @return Activity.
 */
class ViewEmpty: AppCompatActivity(), ViewBinderIf<LayoutViewOwwLightEmptyBinding> {

    /**
     * Adds a [mBinding] to this.
     * @return promised binding.
     */
    override lateinit var mBinding: LayoutViewOwwLightEmptyBinding

    /**
     * Does bindings and then launches a thread to gracefully end the empty activity.
     * @param savedInstanceState as state.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.fireUiBindings()
        this.onEndEmpty()
    }

    /**
     * Ui will bind itself to layouts, for consistency.
     * Binding is generated through BR class, this will set the view through binding
     * Execute pending bindings.
     */
    override fun fireUiBindings(){
        this.mBinding = DataBindingUtil.setContentView(this, R.layout.layout_view_oww_light_empty)
        this.mBinding.executePendingBindings()
    }

    /**
     * Find the element and register listener with the ui.
     */
    override fun registerUi() {}

    /**
     * Filters out on methods that will emit observer observable pattern.
     */
    override fun subscribeUi() {}

    /**
     * Listener that resembles the LOD principle, encapsulates observers observables.
     */
    override fun listenersUi() {}

    /**
     * Thread launcher that displays a snackbar on the activities end.
     */
    private fun onEndEmpty() {
        val snackbar = OwwUtil().fireLightSnackbar(this,"ViewEmpty, 404!", Snackbar.LENGTH_SHORT, R.id.layout_view_empty_parent)
        snackbar.anchorView = this.findViewById(R.id.gd_empty_50_hor)
        snackbar.show()

        val handler = Handler().postDelayed({ this@ViewEmpty.finishAffinity()
        }, StoryBoardConstants.EMPTY_SECONDS)
    }
}