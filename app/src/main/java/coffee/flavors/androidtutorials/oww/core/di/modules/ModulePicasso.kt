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

import android.app.Application
import android.content.Context
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton


/**
 * @author, evolandlupiz
 * @date, 3/15/2020
 * @property, AndroidTutorials
 * @purpose, Module that will initialize third-party modules.
 */

@Module
class ModulePicasso {

    /**
     * Picasso
     */
    @Provides
    @Singleton
    fun picasso(context: Context?, okHttp3Downloader: OkHttp3Downloader?): Picasso? {
        return Picasso.Builder(context).downloader(okHttp3Downloader).build()
    }
}
