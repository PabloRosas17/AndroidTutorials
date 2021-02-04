package coffee.flavors.androidtutorials.pizzamia.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import coffee.flavors.androidtutorials.pizzamia.model.ModelPizza

/**
 * @author, evolandlupiz
 * @date, 2/29/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

@Dao
interface DaoPizza {
    @Query("SELECT * FROM pizza_table")
    fun query(): LiveData<List<ModelPizza>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pizza: ModelPizza)

    @Query("DELETE FROM pizza_table WHERE pizzaname = :pk")
    suspend fun delete(pk: String)
}