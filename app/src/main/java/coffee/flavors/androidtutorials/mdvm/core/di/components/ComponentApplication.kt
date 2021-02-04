package coffee.flavors.androidtutorials.mdvm.core.di.components

import android.app.Application
import coffee.flavors.androidtutorials.mdvm.core.ApplicationMVDM
import coffee.flavors.androidtutorials.mdvm.core.di.modules.ModuleActivity
import coffee.flavors.androidtutorials.mdvm.core.di.modules.ModuleFragment
import coffee.flavors.androidtutorials.mdvm.core.di.modules.ModuleProvider
import coffee.flavors.androidtutorials.mdvm.core.di.modules.ModuleViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * @author, evolandlupiz
 * @date, 2/28/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

@Component(
    modules = [
        ModuleActivity::class
        , ModuleFragment::class
        , ModuleViewModel::class
        , ModuleProvider::class
        , AndroidInjectionModule::class
    ]
)

@Singleton
interface ComponentApplication {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ComponentApplication
    }
    fun inject(mApplicationMVDM: ApplicationMVDM)
}