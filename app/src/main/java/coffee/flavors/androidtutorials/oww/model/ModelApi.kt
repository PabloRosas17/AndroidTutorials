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

package coffee.flavors.androidtutorials.oww.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @author, evolandlupiz
 * @date, 3/2/2020
 * @property, AndroidTutorials
 * @purpose, models and data containers.
 */

/**
 * Model that defines an observed container to place [ModelEntity] data.
 */
class ModelOww {
    /**
     * Adds a [list] model.
     * @return a mutable list.
     */
    var list = mutableListOf<ModelEntity>()
}

/**
 * Model Entity that represents an api response
 * , and un-marshals items into this wrapper.
 */
@JsonClass(generateAdapter = true)
data class ModelEntity(
    /**
     * Adds an [image] to the wrapper.
     * @return the image.
     */
    @field: Json(name = "image") val image: String = ""
    /**
     * Adds a [filter] to the wrapper.
     * @return the filter associated with an image.
     */
    , @field: Json(name = "filter") val filter: String = ""
    /**
     * Adds a [title] to the wrapper.
     * @return the title of an image.
     */
    , @field: Json(name = "title") val title: String = ""
)