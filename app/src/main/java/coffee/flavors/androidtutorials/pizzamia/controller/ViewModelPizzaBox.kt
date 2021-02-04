package coffee.flavors.androidtutorials.pizzamia.controller

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import coffee.flavors.androidtutorials.pizzamia.model.ModelPizza
import coffee.flavors.androidtutorials.pizzamia.model.database.PizzaRoomDB

/**
 * @author, evolandlupiz
 * @date, 2/29/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

class ViewModelPizzaBox(private val mApplication: Application, private val mPizzaRepo: PizzaRoomDB) : ViewModel() {
    val mPizzaDB = this.mPizzaRepo

    var mModelPizza= mutableListOf<ModelPizza>()

    var mPizzaLD: LiveData<List<ModelPizza>> = this.mPizzaDB.mDaoPizza().query()
}