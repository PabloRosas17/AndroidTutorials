package coffee.flavors.androidtutorials.pizzamia.core

import android.app.Application
import androidx.room.Room
import coffee.flavors.androidtutorials.pizzamia.controller.ViewModelPizzaBox
import coffee.flavors.androidtutorials.pizzamia.model.database.PizzaRoomDB
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * @author, evolandlupiz
 * @date, 2/29/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

class ApplicationPizzamia : Application() {

    /* modules that will inject into the application */
    private val mViewModels = module {
        single { Room.databaseBuilder(get(), PizzaRoomDB::class.java, "pizza_table").build() }
        viewModel { ViewModelPizzaBox(get(),get()) }
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
            androidContext(this@ApplicationPizzamia)
            loadKoinModules(mModules)
        }
    }
}