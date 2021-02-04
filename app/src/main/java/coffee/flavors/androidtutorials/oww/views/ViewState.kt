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

import coffee.flavors.androidtutorials.oww.tools.constants.StateConstants

/**
 * @author, evolandlupiz
 * @date, 3/3/2020
 * @property, AndroidTutorials
 * @purpose, Model for states.
 */

/**
 * Model for states.
 * @param status as the states status.
 */
data class ViewState(private val status: STATUS) {
    companion object {
        /**
         * @return the state of as empty.
         */
        val LOAD_EMPTY = ViewState(STATUS.EMPTY)
        /**
         * @return the state of as error.
         */
        val LOAD_ERROR = ViewState(STATUS.ERROR)
        /**
         * @return the state of as okay.
         */
        val LOAD_OKAY = ViewState(STATUS.OKAY)
    }

    /**
     * @return enumarated constants defining various finite states.
     */
    enum class STATUS(s: String) {
        EMPTY(StateConstants.STATE_EMPTY)
        , ERROR(StateConstants.STATE_ERROR)
        , OKAY(StateConstants.STATE_OKAY)
    }
}