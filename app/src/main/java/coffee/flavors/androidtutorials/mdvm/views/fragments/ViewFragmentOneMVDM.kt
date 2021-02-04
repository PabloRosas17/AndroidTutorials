package coffee.flavors.androidtutorials.mdvm.views.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coffee.flavors.androidtutorials.R
import coffee.flavors.androidtutorials.databinding.LayoutViewFragmentOneMvdmBinding
import coffee.flavors.androidtutorials.mdvm.controller.ViewModelFragmentOne
import coffee.flavors.androidtutorials.mdvm.core.ApplicationMVDM
import coffee.flavors.androidtutorials.mdvm.factory.FactoryViewModel
import javax.inject.Inject

/**
 * @author, evolandlupiz
 * @date, 2/28/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

class ViewFragmentOneMVDM : Fragment() {

    companion object {
        /* fragment instance used with view pager */
        @JvmStatic fun instance(): ViewFragmentOneMVDM {
            return ViewFragmentOneMVDM()
        }
    }

    @Inject lateinit var mFactoryViewModel: FactoryViewModel

    lateinit var mBinding: LayoutViewFragmentOneMvdmBinding

    lateinit var mViewModel: ViewModelFragmentOne

    private lateinit var mRootView: View

    override fun onAttach(context: Context) {
        (context.applicationContext as ApplicationMVDM).androidInjector().inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        /* binding is generated through BR class, this will set the view through binding */
        this.mBinding = DataBindingUtil.inflate(inflater, R.layout.layout_view_fragment_one_mvdm, container, false)
        this.fireUiBindings()
        this.fireVmBindings()
        return this.mRootView
    }

    private fun fireUiBindings() {
        /* execute pending bindings */
        mBinding.executePendingBindings()
        /* get hold of the fragment root */
        this.mRootView = this.mBinding.root
    }

    private fun fireVmBindings() {
        /* generate view models of type get(T) through the factory provided */
        this.mViewModel = ViewModelProvider(this, this.mFactoryViewModel).get(ViewModelFragmentOne::class.java)
    }
}