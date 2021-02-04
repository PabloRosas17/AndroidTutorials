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

package coffee.flavors.androidtutorials.oww.tools.constants

/**
 * @author, evolandlupiz
 * @date, 3/2/2020
 * @property, AndroidTutorials
 * @purpose, Container for all constants.
 */

/**
 * Network constants, define urls, status codes.
 */
object NetworkConstants {
    const val BASE_URL_WEIGHT_WATCHERS: String  = "https://www.weightwatchers.com/"
    const val OK = 200
    const val BAD_REQUEST = 400
    const val NOT_FOUND = 404
}

/**
 * Adapter constants, define unique identifiers.
 */
object AdapterConstants {
    const val NULL_ITEMS: Int = -1
    /* by definition a view count should be null (non existing)
     * , but to be type safe, use 0, to render no items*/
    const val DEFAULT_ITEM_COUNT: Int = 0
}

/**
 * Storyboard constants, define control flow and timing.
 */
object StoryBoardConstants {
    const val ENTRANCE_SECONDS: Long = 3000
    const val DEPARTURE_SECONDS: Long = 2000
    const val ERROR_SECONDS: Long = 5000
    const val EMPTY_SECONDS: Long = 5000
}

/**
 * Snackbar constants, define rules for layout, named-literals.
 */
object SnackbarConstants {
    const val Y_BOTTOM = 0.0f
}

/**
 * Marshalization constants, define keys.
 */
object MarshallizedTokens {
    const val KEY_RV_STATE_ON_ORIENTATION_CHANGE = "RV_STATE"
    const val KEY_RV_POSITION_ON_ORIENTATION_CHANGE = "RV_POSITION"
    const val KEY_SM_THEME_MODE = "SM_THEME_MODE"
}

/**
 * State constants, define states.
 */
object StateConstants {
    const val STATE_EMPTY = "EMPTY"
    const val STATE_ERROR = "ERROR"
    const val STATE_OKAY = "OKAY"
}

/**
 * Coroutine constants, define context tags.
 */
object CoroutineConstants {
    const val VIEW_OWW_COROUTINE = "ViewOwwCoroutine"
}

/**
 * String constants, define un-categorized literals.
 */
object StringGlobals {
    const val EMPTY_STRING = ""
    const val DARK_MODE = "DARK_MODE"
    const val LIGHT_MODE = "LIGHT_MODE"
}

/**
 * Rest constants, define apis.
 */
object RestApis {
    const val PATH_COLLECTIONS: String = "assets/cmx/us/messages/collections.json"
}