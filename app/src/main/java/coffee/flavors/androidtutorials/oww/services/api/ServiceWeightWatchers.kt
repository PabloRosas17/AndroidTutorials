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

package coffee.flavors.androidtutorials.oww.services.api

import coffee.flavors.androidtutorials.oww.model.ModelEntity
import coffee.flavors.androidtutorials.oww.tools.constants.RestApis
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author, evolandlupiz
 * @date, 3/2/2020
 * @property, AndroidTutorials
 * @purpose, contract as a network service that defines REST apis.
 */

/* @API_FORMAT "/{v}/{w}/{x}/.../x.json") */
interface ServiceWeightWatchers {
    /**
     * Adds a [getEntityRQ] operation which io's the path.
     * @return the new size of the group.
     */
    @GET(RestApis.PATH_COLLECTIONS)
    fun getEntityRQ(
    ) : Call<List<ModelEntity>>
}