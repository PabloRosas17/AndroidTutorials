package coffee.flavors.androidtutorials.delete.core

import android.app.Application
import coffee.flavors.androidtutorials.delete.controller.ViewModelDelete
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * @author, evolandlupiz
 * @date, 2/27/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

class ApplicationDelete : Application() {

    /* modules that will inject into the application */
    private val mViewModels = module {
        viewModel { ViewModelDelete() }
    }

    /* list of of modules that will load through koin */
    private val mModules = listOf(mViewModels)

    /* application dependent method used to instantiate an instance of this and link the modules koin will use*/
    override fun onCreate() {
        super.onCreate()
        startKoin {
            /* @androidLogger initiate logger for Koin*/
            /* @androidContext reference for caller context */
            /* @modules reference for modules available */
            androidLogger()
            androidContext(this@ApplicationDelete)
            loadKoinModules(mModules)
        }
    }
}