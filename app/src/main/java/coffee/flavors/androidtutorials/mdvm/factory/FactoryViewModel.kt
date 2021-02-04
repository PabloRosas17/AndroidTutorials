package coffee.flavors.androidtutorials.mdvm.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

/**
 * @author, evolandlupiz
 * @date, 2/28/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

@Singleton
class FactoryViewModel @Inject constructor(
    creator: Map<Class<out ViewModel>
            , @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory{

    private var creators: Map<Class<out ViewModel>,Provider<ViewModel>> = creator

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var creator = this.creators.get(modelClass)

        if(creator == null){
            this.creators.forEach lift@ {
                if(modelClass.isAssignableFrom(it.key)){
                    creator = it.value
                    return@lift
                }
            }
        }

        try {
            return creator?.get() as T
        } catch (e: Exception){
            throw RuntimeException("FactoryViewModel.kt, unknown model class: $modelClass , e: $e")
        }
    }
}