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

package coffee.flavors.androidtutorials.ub.views.actions

import com.ww.roxie.BaseAction

/**
 * @author, evolandlupiz
 * @date, 3/6/2020
 * @property, AndroidTutorials
 * @purpose, define the action available.
 */

/**
 * This defines the blueprint for Actions available.
 */
sealed class UiActions : BaseAction {

    /**
     * Acts upon a user pressing the s0 button.
     */
    object Start : UiActions()

    /**
     * Acts upon a user pressing the s1 button.
     */
    object Bake : UiActions()

    /**
     * Acts upon a user pressing the s2 button.
     * @param baked to determine is the cake baked yet.
     */
    data class Check(val baked: Boolean) : UiActions()

    /**
     * Acts upon a user pressing the s3 button.
     */
    object End : UiActions()
}