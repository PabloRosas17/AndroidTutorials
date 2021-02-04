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
 * @date, 3/2/2020
 * @property, AndroidTutorials
 * @purpose, Binder utility used to keep track of views that are binded.
 */

/**
 * @desc contract for views capable of binding, all views in this case since mvvm architecture
 * @param T type of the calling class
 */
interface ViewBinderIf<T> {

    /**
     * @return T type of the calling class, associate the binding element
     */
    var mBinding: T

    /**
     * Method used to enforce bindings happen
     */
    fun fireUiBindings()

    /**
     * Find the element and register listener with the ui.
     */
    fun registerUi()

    /**
     * Filters out on methods that will emit observer observable pattern.
     */
    fun subscribeUi()

    /**
     * Listener that resembles the LOD principle, encapsulates observers observables.
     */
    fun listenersUi()
}