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

package coffee.flavors.androidtutorials.oww.tools

import coffee.flavors.androidtutorials.oww.model.ModelEntity
import coffee.flavors.androidtutorials.oww.model.ModelOww

/**
 * @author, evolandlupiz
 * @date, 3/3/2020
 * @property, AndroidTutorials
 * @purpose, filter used to parse through strings.
 */

/**
 * Filter utility.
 */
class OwwApiFilter {

    /**
     * Parses through a list of entities and matches their data.
     * @param B as [body] the list of entities.
     * @param M as [model] the data.
     */
    fun filter(body: List<ModelEntity>?, model: ModelOww) {
        body?.forEachIndexed { i, entity ->
            model.list.add(entity)
        }
    }
}