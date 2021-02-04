package coffee.flavors.androidtutorials.mdvm.core.di.modules

import android.app.Activity
import coffee.flavors.androidtutorials.mdvm.core.di.keys.KeyActivity
import coffee.flavors.androidtutorials.mdvm.factory.FactoryActivity
import coffee.flavors.androidtutorials.mdvm.views.activities.ViewActivityTopMVDM
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
abstract class ModuleActivity{

    @Binds
    @IntoMap
    @KeyActivity(Activity::class)
    abstract fun bindActivity(factory: FactoryActivity): AndroidInjector.Factory<out Activity>

    @ContributesAndroidInjector
    abstract fun activityViewActivityTopMVDM(): ViewActivityTopMVDM
}