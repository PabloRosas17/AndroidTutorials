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

package coffee.flavors.androidtutorials.ub.model

import coffee.flavors.androidtutorials.ub.controller.UiChanges
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.USE_CASE_ERROR
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.USE_CASE_IDLE
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.USE_CASE_PROCESSING
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.USE_CASE_S0
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.USE_CASE_S1
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.USE_CASE_S2
import coffee.flavors.androidtutorials.ub.tools.constants.Constants.USE_CASE_S3
import io.reactivex.Single

/**
 * @author, evolandlupiz
 * @date, 3/6/2020
 * @property, AndroidTutorials
 * @purpose, Cases which will be bounded **within** the view model.
 */

/**
 * Emitter for Start.
 */
class StartUseCase {
    fun start(): Single<UiChanges> = Single.just(UiChanges.Start(USE_CASE_S0))
}

/**
 * Emitter for Bake.
 */
class StartBakeCase {
    fun bake(): Single<UiChanges> = Single.just(UiChanges.Bake(USE_CASE_S1))
}

/**
 * Emitter for Check.
 */
class StartCheckCase {
    fun check(): Single<UiChanges> = Single.just(UiChanges.Check(USE_CASE_S2))
}

/**
 * Emitter for End.
 */
class StartEndCase {
    fun end(): Single<UiChanges> = Single.just(UiChanges.End(USE_CASE_S3))
}

/**
 * Emitter for Idle.
 */
class StartIdleCase {
    fun idle(): Single<UiChanges> = Single.just(UiChanges.Idle(USE_CASE_IDLE))
}

/**
 * Emitter for Processing.
 */
class StartProcessingCase {
    fun processing(): Single<UiChanges> = Single.just(UiChanges.Processing(USE_CASE_PROCESSING))
}

/**
 * Emitter for Error.
 */
class StartErrorCase {
    fun error(): Single<UiChanges> = Single.just(UiChanges.Error(USE_CASE_ERROR))
}