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

package coffee.flavors.androidtutorials.ub.tools.constants

/**
 * @author, evolandlupiz
 * @date, 3/7/2020
 * @property, AndroidTutorials
 * @purpose, Container for all constants.
 */

object Constants{
    /* notifications through snackbar */
    const val STATE_S0_NOTIFICATION = "State Machine S0 START."
    const val STATE_S1_NOTIFICATION = "State Machine S1 BAKE."
    const val STATE_S2_NOTIFICATION = "State Machine S2 CHECK."
    const val STATE_S3_NOTIFICATION = "State Machine S3 END."
    const val STATE_IDLE_NOTIFICATION = "State Machine SX IDLE."
    const val STATE_PROCESSING_NOTIFICATION = "State Machine SX PROCESSING."
    const val STATE_ERROR_NOTIFICATION = "State Machine SX ERROR."

    /* emitter tags */
    const val USE_CASE_S0 = "start"
    const val USE_CASE_S1 = "bake"
    const val USE_CASE_S2 = "check"
    const val USE_CASE_S3 = "end"
    const val USE_CASE_IDLE = "idle"
    const val USE_CASE_PROCESSING = "processing"
    const val USE_CASE_ERROR = "error"
}