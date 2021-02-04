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
import coffee.flavors.androidtutorials.oww.tools.OwwUtil
import coffee.flavors.androidtutorials.oww.views.ViewOww
import com.google.android.material.snackbar.Snackbar


/**
 * @author, evolandlupiz
 * @date, 3/3/2020
 * @property, AndroidTutorials
 * @purpose, Encapsulate E as events from ui components.
 */

/**
 **
 * @param mItemView as parent view.
 * @property position as the card position.
 * @constructor provides initialized view and position of a known card.
 */
class PresenterCardItem(private val mItemView: View, private val position: Int) {

    /**
     * Adds a [ctx] that can be used within this class-lifecycle.
     * @return Context.
     */
    private val ctx = this.mItemView.context

    /**
     * E when a card is clicked.
     * Handle filter and display ui on it.
     * @throws RuntimeException when the View isn't [ViewOww]
     */
    fun fireCardItemClicker() {
        when(ctx) {
            is ViewOww -> {
                var filter = ctx.mVmOww.mModelOww.list[position].filter
                if(filter.isEmpty() || filter.isBlank()){
                    filter="Whoops, filter is not okay!"
                }
                val snackbar = OwwUtil().fireDarkSnackbar(ctx,filter,Snackbar.LENGTH_SHORT,R.id.layout_view_oww_parent)
                snackbar.anchorView = this.ctx.findViewById(R.id.gd_oww_93_hor)
                snackbar.show()
            }
            else -> { throw RuntimeException("PresenterCardItem.kt, unknown context type.") }
        }
    }
}