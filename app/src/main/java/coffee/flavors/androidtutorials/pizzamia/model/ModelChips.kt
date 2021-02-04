package coffee.flavors.androidtutorials.pizzamia.model

import java.lang.RuntimeException

/**
 * @author, evolandlupiz
 * @date, 3/1/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

class ModelChips {

    fun generate(key: String): ModelPizza {
        when(key) {
            "pizzamia" -> { return pizzamia() }
            "pizzabbq" -> { return pizzabbq() }
            "pizzaclassic" -> { return pizzaclassic() }
            "pizzamgr" -> { return pizzamgr() }
            "pizzadog" -> { return pizzadog() }
            else -> { return throw RuntimeException("ModelChips.kt, unknown key.")}
        }
    }

    fun pizzamia(): ModelPizza {
        return ModelPizza(
            "pizzamia"
            , "10.99"
            , "round"
            , "pepperoni, pineapple, mushrooms"
            , "heavy-red-sauce"
            , "regular"
        )
    }

    fun pizzabbq(): ModelPizza {
        return ModelPizza(
            "pizzabbq"
            , "15.99"
            , "round"
            , "chicken, olives, celery"
            , "bbq-sauce"
            , "deep-dish"
        )
    }

    fun pizzaclassic(): ModelPizza {
        return ModelPizza(
            "pizzaclassic"
            , "7.99"
            , "round"
            , "pepperoni, extra-cheese"
            , "medium-red"
            , "regular"
        )
    }

    fun pizzamgr(): ModelPizza {
        return ModelPizza(
            "pizzamgr"
            , "21.99"
            , "round"
            , "pepperoni, sausage, pineapple, mushrooms, celery, onions, bell-peppers, olives"
            , "heavy-white"
            , "deep-dish-crusty"
        )
    }

    fun pizzadog(): ModelPizza {
        return ModelPizza(
            "pizzadog"
            , "5.99"
            , "round"
            , "pepperoni, chicken-sausage, mushrooms, onions"
            , "hot-sauce"
            , "dogbun"
        )
    }
}