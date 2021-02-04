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

package coffee.flavors.androidtutorials.oww.core.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * @author, evolandlupiz
 * @date, 3/15/2020
 * @property, AndroidTutorials
 * @purpose, Factory that will generate view models.
 */

/**
 * Factory responsible for instantiating view-model.
 * @return instance of view-model requested.
 */
@Singleton
class FactoryViewModel @Inject constructor(
    creator: Map<Class<out ViewModel>
            , @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory{
    /**
     * Map with current view-models stored.
     * @return Map<*,*>
     */
    private var creators: Map<Class<out ViewModel>,Provider<ViewModel>> = creator

    /**
     * Generates a view-model.
     * @return ViewModel of type [T]
     * @suppress [T] as it is in fact the generic type requested.
     * @throws RuntimeException if view-model isn't a registered type.
     */
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator = this.creators[modelClass]

        if(creator == null){
            this.creators.forEach lift@ {
                if(modelClass.isAssignableFrom(it.key)){
                    creator = it.value
                    return@lift
                }
            }
        }

        try {
            /* this generic is in fact of ViewModel type, suppress the warning */
            @Suppress("unchecked_cast") return creator?.get() as T
        } catch (e: Exception){
            throw RuntimeException("FactoryViewModel.kt, unknown model class: $modelClass , e: $e")
        }
    }
}