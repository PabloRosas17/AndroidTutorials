package coffee.flavors.androidtutorials.pizzamia.controller.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coffee.flavors.androidtutorials.R
import coffee.flavors.androidtutorials.databinding.ViewPizzamiaRecyclerItemLayoutBinding
import coffee.flavors.androidtutorials.pizzamia.model.ModelPizza
import coffee.flavors.androidtutorials.pizzamia.views.ViewPizzaBox

/**
 * @author, evolandlupiz
 * @date, 2/29/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

class PizzaBoxAdapter(private val activity: ViewPizzaBox, private var mModelPizza: List<ModelPizza>)
    : RecyclerView.Adapter<PizzaBoxAdapter.PizzaBoxViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaBoxViewHolder {
        val inflater = LayoutInflater.from(this.activity)
        val view = inflater.inflate(R.layout.view_pizzamia_recycler_item_layout, parent, false)
        return PizzaBoxViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.mModelPizza.size
    }

    override fun onBindViewHolder(holder: PizzaBoxViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class PizzaBoxViewHolder(private val mItemView: View): RecyclerView.ViewHolder(mItemView) {
        fun bind(position: Int) {
            val text =
                    mModelPizza[position].pizzaname + ", " +
                    mModelPizza[position].pizzaprice + ", " +
                    mModelPizza[position].pizzatoppings + ", " +
                    mModelPizza[position].pizzashape + ", " +
                    mModelPizza[position].pizzasauce + ", " +
                    mModelPizza[position].pizzabread

            val mBinding = DataBindingUtil.bind<ViewPizzamiaRecyclerItemLayoutBinding>(mItemView)
            mBinding?.executePendingBindings()
            mBinding?.rvTvItem?.text = text
        }
    }
}