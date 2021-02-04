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

import android.app.Activity
import coffee.flavors.androidtutorials.oww.services.api.ServiceWeightWatchers
import coffee.flavors.androidtutorials.oww.tools.constants.NetworkConstants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author, evolandlupiz
 * @date, 3/15/2020
 * @property, AndroidTutorials
 * @purpose, Define network modules.
 */

@Module
class ModuleNetwork {

    /**
     * Builder for [OkHttpClient]
     */
    @Provides
    @Singleton
    fun networkOkHttp(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    /**
     * Builder for [networkRetrofitWeightWatchers]
     */
    @Provides
    @Singleton
    fun networkRetrofitWeightWatchers(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(NetworkConstants.BASE_URL_WEIGHT_WATCHERS)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    /**
     * Service for [ServiceWeightWatchers]
     */
    @Provides
    @Singleton
    fun serviceWeightWatchers(nrf: Retrofit): ServiceWeightWatchers {
        return nrf.create(ServiceWeightWatchers::class.java)
    }
}