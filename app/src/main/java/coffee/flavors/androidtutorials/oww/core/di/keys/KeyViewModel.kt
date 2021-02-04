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

package coffee.flavors.androidtutorials.oww.core.di.keys

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * @author, evolandlupiz
 * @date, 3/15/2020
 * @property, AndroidTutorials
 * @purpose, Resolve the type ViewModel at runtime during Dagger graph mapping.
 */

/**
 * Reflection technique used to determine a type at runtime.
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class KeyViewModel(val value: KClass<out ViewModel>)