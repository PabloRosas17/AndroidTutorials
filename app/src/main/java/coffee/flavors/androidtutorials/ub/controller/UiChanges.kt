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

package coffee.flavors.androidtutorials.ub.controller

/**
 * @author, evolandlupiz
 * @date, 3/6/2020
 * @property, AndroidTutorials
 * @purpose, Unique types.
 */

/**
 * Unique type as UiChanges, by design can't have another type known as UiChanges, so seal it away.
 */
sealed class UiChanges {

    /**
     * Changes for Start.
     * @return UiChanges.
     */
    data class Start(val msg: String) : UiChanges()

    /**
     * Changes for Bake.
     * @return UiChanges.
     */
    data class Bake(val msg: String) : UiChanges()

    /**
     * Changes for Check.
     * @return UiChanges.
     */
    data class Check(val msg: String) : UiChanges()

    /**
     * Changes for End.
     * @return UiChanges.
     */
    data class End(val msg: String) : UiChanges()

    /**
     * Changes for Idle.
     * @return UiChanges.
     */
    data class Idle(val msg: String) : UiChanges()

    /**
     * Changes for Processing.
     * @return UiChanges.
     */
    data class Processing(val msg: String) : UiChanges()

    /**
     * Changes for Error.
     * @return UiChanges.
     */
    data class Error(val msg: String) : UiChanges()
}