package coffee.flavors.androidtutorials.pizzamia.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author, evolandlupiz
 * @date, 2/29/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

/* data class ModelPizza (
    val pizzaname: String
    , val pizzaprice: String
    , val pizzashape: String
    , val pizzatoppings: String
    , val pizzasauce: String
    , val pizzabread: String
) */

@Entity(tableName= "pizza_table")
class ModelPizza(@PrimaryKey @ColumnInfo(name="pizzaname") val pizzaname: String
                 , @ColumnInfo(name="pizzaprice") val pizzaprice: String
                 , @ColumnInfo(name="pizzashape") val pizzashape: String
                 , @ColumnInfo(name="pizzatoppings") val pizzatoppings: String
                 , @ColumnInfo(name="pizzasauce") val pizzasauce: String
                 , @ColumnInfo(name="pizzabread") val pizzabread: String){
    override fun toString(): String {
        return pizzaname
    }
}
