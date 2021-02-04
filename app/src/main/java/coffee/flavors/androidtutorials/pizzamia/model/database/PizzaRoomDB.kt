package coffee.flavors.androidtutorials.pizzamia.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import coffee.flavors.androidtutorials.pizzamia.model.ModelPizza

/**
 * @author, evolandlupiz
 * @date, 2/29/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

@Database(entities = arrayOf(ModelPizza::class), version = 1, exportSchema = false)
public abstract class PizzaRoomDB : RoomDatabase() {
    abstract fun mDaoPizza() : DaoPizza

    companion object {
        @Volatile private var INSTANCE_PIZZA_ROOM_DB: PizzaRoomDB? = null
        fun getDatabase(context: Context) : RoomDatabase {
            val tInstance = INSTANCE_PIZZA_ROOM_DB
            if(tInstance != null){
                return tInstance
            }
            synchronized(this){
                val instance =
                    Room.databaseBuilder(context, PizzaRoomDB::class.java, "pizza_table").build()
                this.INSTANCE_PIZZA_ROOM_DB = instance
                return instance
            }
        }
    }
}