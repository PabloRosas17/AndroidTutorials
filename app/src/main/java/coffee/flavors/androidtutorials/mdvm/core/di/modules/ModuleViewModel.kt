package coffee.flavors.androidtutorials.mdvm.core.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import coffee.flavors.androidtutorials.mdvm.controller.ViewModelActivityTop
import coffee.flavors.androidtutorials.mdvm.controller.ViewModelFragmentOne
import coffee.flavors.androidtutorials.mdvm.controller.ViewModelFragmentTwo
import coffee.flavors.androidtutorials.mdvm.core.di.keys.KeyViewModel
import coffee.flavors.androidtutorials.mdvm.factory.FactoryViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author, evolandlupiz
 * @date, 2/28/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

@Module
abstract class ModuleViewModel{
    @Binds
    abstract fun bindFactoryViewModel(factory: FactoryViewModel): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @KeyViewModel(ViewModelActivityTop::class)
    abstract fun mViewModelActivityTop(mViewModelActivityTop: ViewModelActivityTop): ViewModel

    @Binds
    @IntoMap
    @KeyViewModel(ViewModelFragmentOne::class)
    abstract fun mViewModelFragmentOne(mViewModelFragmentOne: ViewModelFragmentOne): ViewModel

    @Binds
    @IntoMap
    @KeyViewModel(ViewModelFragmentTwo::class)
    abstract fun mViewModelFragmentTwo(mViewModelFragmentTwo: ViewModelFragmentTwo): ViewModel
}