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

package coffee.flavors.androidtutorials.oww.tools

/**
 * @author, evolandlupiz
 * @date, 3/4/2020
 * @property, AndroidTutorials
 * @purpose, delegate as a contract for views that implement dark mode theme.
 */

/**
 * Delegate.
 */
interface ThemeCallbackIf {

    /**
     * Adds a [call] as a delegate.
     * @param mode as the theme mode.
     */
    fun call(mode: Boolean)
}