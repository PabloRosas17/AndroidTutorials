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

package coffee.flavors.androidtutorials.oww.core.di.components

import android.app.Activity
import android.app.Application
import coffee.flavors.androidtutorials.oww.core.ApplicationOww
import coffee.flavors.androidtutorials.oww.core.di.modules.ModuleNetwork
import coffee.flavors.androidtutorials.oww.core.di.modules.ModulePicasso
import coffee.flavors.androidtutorials.oww.core.di.modules.ModuleViewModel
import coffee.flavors.androidtutorials.oww.services.api.ServiceWeightWatchers
import coffee.flavors.androidtutorials.oww.views.*
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * @author, evolandlupiz
 * @date, 3/15/2020
 * @property, AndroidTutorials
 * @purpose, Define component modules for injection,
 */

/**
 * Components that will be used to map during builders lifecycle.
 */
@Component(
    modules = [
        ModuleViewModel::class
        , ModuleNetwork::class
        , ModulePicasso::class
    ]
)

/**
 * Contract for the application to generate components.
 */
@Singleton
interface ComponentApplication {

    /**
     * builder that builds an application.
     */
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ComponentApplication
    }

    /**
     * injection function used to inject a fresh made service.
     */
    fun serviceWeightWatchers(): ServiceWeightWatchers

    /**
     * injection function used to inject a fresh made application from the factory.
     */
    fun inject(mApplicationOww: ApplicationOww)


    /**
     * injection function used to inject a freshly made activity.
     */
    fun inject(mActivity: Activity)
    fun inject(mViewOww: ViewOww)
}