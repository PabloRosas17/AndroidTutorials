package coffee.flavors.androidtutorials.delete.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import coffee.flavors.androidtutorials.R
import coffee.flavors.androidtutorials.databinding.LayoutDeleteMainBinding

/**
 * @author, evolandlupiz
 * @date, 2/27/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

class ViewDelete : AppCompatActivity() {

    lateinit var mBinding: LayoutDeleteMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.fireUiBindings()
    }

    /* ui will bind itself to layouts, for consistency */
    private fun fireUiBindings(){
        /* binding is generated through BR class, this will set the view through binding */
        this.mBinding = DataBindingUtil.setContentView(this, R.layout.layout_delete_main)
        /* execute pending bindings */
        this.mBinding.executePendingBindings()
    }
}