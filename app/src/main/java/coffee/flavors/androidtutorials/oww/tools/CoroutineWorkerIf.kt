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

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * @author, evolandlupiz
 * @date, 3/2/2020
 * @property, AndroidTutorials
 * @purpose, Coroutine lifecycle can become dirty when dealing with synchronicity
 *  , this is a tool to help mitigate exceptions due to the dirty coroutines.
 */

/**
 * @desc Inheritors capable of coroutine will contract this class to follow proper execution cycles.
 */
interface CoroutineWorkerIf: CoroutineScope {

    /**
     * Context representing the coroutine.
     * @return the coroutine context.
     */
    override val coroutineContext: CoroutineContext

    /**
     * Job instance to represent the coroutine.
     * @return the coroutine job.
     */
    var mWorker: Job

    /**
     * lifecycle method to start the coroutine.
     */
    fun fireCoroutineWorker()

    /**
     * Coroutine method that will perform asynchronous preemptive multitasking.
     */
    suspend fun popFrozenTime()

    /**
     * lifecycle method to end the coroutine.
     */
    fun onDestroy()
}