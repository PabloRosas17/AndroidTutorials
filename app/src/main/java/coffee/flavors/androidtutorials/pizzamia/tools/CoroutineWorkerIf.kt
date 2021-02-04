package coffee.flavors.androidtutorials.pizzamia.tools

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

/**
 * @author, evolandlupiz
 * @date, 2/29/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

/* @desc inheritors capable of coroutine will contract this class to follow proper execution cycles*/
interface CoroutineWorkerIf: CoroutineScope {

    /* job instance to represent the coroutine */
    var mWorker: Job

    /* lifecycle method to end the coroutine */
    fun onDestroy()
}