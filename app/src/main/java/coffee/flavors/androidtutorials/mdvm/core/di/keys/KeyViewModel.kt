package coffee.flavors.androidtutorials.mdvm.core.di.keys

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * @author, evolandlupiz
 * @date, 2/28/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class KeyViewModel(val value: KClass<out ViewModel>)
