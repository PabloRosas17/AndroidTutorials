package coffee.flavors.androidtutorials.mdvm.core.di.keys

import android.app.Activity
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
annotation class KeyActivity(val value: KClass<out Activity>)