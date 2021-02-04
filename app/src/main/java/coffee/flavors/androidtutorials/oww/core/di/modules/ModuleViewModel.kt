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

package coffee.flavors.androidtutorials.oww.core.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import coffee.flavors.androidtutorials.oww.controller.ViewModelOww
import coffee.flavors.androidtutorials.oww.core.di.keys.KeyViewModel
import coffee.flavors.androidtutorials.oww.core.factory.FactoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author, evolandlupiz
 * @date, 3/15/2020
 * @property, AndroidTutorials
 * @purpose, Binding module to make the view-models available and firebase instances.
 */


@Module
abstract class ModuleViewModel {

    @Binds
    abstract fun bindFactoryViewModel(factory: FactoryViewModel): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @KeyViewModel(ViewModelOww::class)
    abstract fun provideViewModelOww(mViewModelAbout: ViewModelOww): ViewModel
}