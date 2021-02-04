package coffee.flavors.androidtutorials.mdvm.core.di.modules

import coffee.flavors.androidtutorials.mdvm.controller.ViewModelActivityTop
import coffee.flavors.androidtutorials.mdvm.controller.ViewModelFragmentOne
import coffee.flavors.androidtutorials.mdvm.controller.ViewModelFragmentTwo
import dagger.Module
import dagger.Provides

/**
 * @author, evolandlupiz
 * @date, 2/28/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

@Module
class ModuleProvider {

    @Provides
    fun provideViewModelActivityTop(): ViewModelActivityTop{
        return ViewModelActivityTop()
    }

    @Provides
    fun provideViewModelFragmentOne(): ViewModelFragmentOne{
        return ViewModelFragmentOne()
    }

    @Provides
    fun provideViewModelFragmentTwo(): ViewModelFragmentTwo{
        return ViewModelFragmentTwo()
    }

}