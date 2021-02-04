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

package coffee.flavors.androidtutorials.ub.core

import android.app.Application
import coffee.flavors.androidtutorials.ub.core.di.ModuleViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

/**
 * @author, evolandlupiz
 * @date, 3/5/2020
 * @property, AndroidTutorials
 * @purpose, core application module.
 */

/**
 * module used for configuring the un-categorized apis.
 * @return a as [Application].
 */
class ApplicationUb : Application() {

    /**
     * list of modules that will inject into the application
     * @return m as [mApplicationModules].
     */
    private val mApplicationModules = listOf(
        ModuleViewModel
    )

    /* load an instance of this and link the modules Koin will use
     * @androidLogger initiate logger for Koin
     * @androidContext reference for caller context
     * @modules reference for modules available */
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ApplicationUb)
            loadKoinModules(mApplicationModules)
        }
    }

}