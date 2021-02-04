package coffee.flavors.androidtutorials.mdvm.core

import android.app.Application
import coffee.flavors.androidtutorials.mdvm.core.di.components.DaggerComponentApplication
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * @author, evolandlupiz
 * @date, 2/27/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

class ApplicationMVDM : Application(), HasAndroidInjector {

    @Inject lateinit var mDispatchingAndroidInjector : DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = mDispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()

        DaggerComponentApplication.builder()
            .application(this)
            .build()
            .inject(this)
    }
}