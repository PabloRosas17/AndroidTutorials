package coffee.flavors.androidtutorials.mdvm.core.di.modules

import androidx.fragment.app.Fragment
import coffee.flavors.androidtutorials.mdvm.core.di.keys.KeyFragment
import coffee.flavors.androidtutorials.mdvm.factory.FactoryFragment
import coffee.flavors.androidtutorials.mdvm.views.fragments.ViewFragmentOneMVDM
import coffee.flavors.androidtutorials.mdvm.views.fragments.ViewFragmentTwoMVDM
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * @author, evolandlupiz
 * @date, 2/28/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

@Module
abstract class ModuleFragment {

    @Binds
    @IntoMap
    @KeyFragment(Fragment::class)
    abstract fun bindFragment(factory: FactoryFragment): AndroidInjector.Factory<out Fragment>

    @ContributesAndroidInjector
    abstract fun fragmentViewFragmentOneMVDM(): ViewFragmentOneMVDM

    @ContributesAndroidInjector
    abstract fun fragmentViewFragmentTwoMVDM(): ViewFragmentTwoMVDM
}