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

package coffee.flavors.androidtutorials.oww.core

import android.app.Application
import coffee.flavors.androidtutorials.oww.core.di.components.ComponentApplication
import coffee.flavors.androidtutorials.oww.core.di.components.DaggerComponentApplication

/**
 * @author, evolandlupiz
 * @date, 3/2/2020
 * @property, AndroidTutorials
 * @purpose, core application module.
 */

/**
 * module used for configuring the un-categorized apis.
 * @return a as [Application].
 */
class ApplicationOww : Application() {

    lateinit var mComponent: ComponentApplication
        private set

    /**
     * Initial module declares injection components for the Application, then build the Application.
     */
    override fun onCreate() {
        super.onCreate()
        this.mComponent = DaggerComponentApplication.builder()
            .application(this)
            .build()
    }
}
