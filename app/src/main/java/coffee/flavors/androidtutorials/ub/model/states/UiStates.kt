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

package coffee.flavors.androidtutorials.ub.model.states

import com.ww.roxie.BaseState

/**
 * @author, evolandlupiz
 * @date, 3/6/2020
 * @property, AndroidTutorials
 * @purpose, define the state available.
 */

/**
 * This defines the blueprint for States available.
 */
data class UiStates(

    /**
     * Determines the state as Started.
     * @return state truth whether state is s0.
     */
    var s0Start: Boolean = false

    /**
     * Determines the state as Baked.
     * @return state truth whether state is s1.
     */
    , var s1Bake: Boolean = false

    /**
     * Determines the state as Check.
     * @return state truth whether state is s2.
     */
    , var s2Check: Boolean = false

    /**
     * Determines the state as Ended.
     * @return state truth whether state is s3.
     */
    , var s3End: Boolean = false

    /**
     * Determines the state as Idle.
     * @return state truth whether state is idle.
     */
    , var isIdle: Boolean = false

    /**
     * Determines the state as Processing.
     * @return state truth whether state is processing.
     */
    , var isProcessing: Boolean = false

    /**
     * Determines the state as Error.
     * @return state truth whether state is in error.
     */
    , var isError: Boolean = false
) : BaseState