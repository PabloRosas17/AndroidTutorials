package coffee.flavors.androidtutorials.mdvm.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import coffee.flavors.androidtutorials.R
import coffee.flavors.androidtutorials.databinding.LayoutViewActivityTopMvdmBinding
import coffee.flavors.androidtutorials.mdvm.controller.ViewModelActivityTop
import coffee.flavors.androidtutorials.mdvm.controller.adapter.TapPagerAdapter
import coffee.flavors.androidtutorials.mdvm.factory.FactoryViewModel
import coffee.flavors.androidtutorials.mdvm.tools.TabNavIf
import com.google.android.material.tabs.TabLayout
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * @author, evolandlupiz
 * @date, 2/27/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

class ViewActivityTopMVDM : AppCompatActivity(), TabNavIf {

    @Inject lateinit var mFactoryViewModel: FactoryViewModel

    lateinit var mBinding: LayoutViewActivityTopMvdmBinding

    lateinit var mViewModel: ViewModelActivityTop

    override lateinit var mTabLayout: TabLayout

    override lateinit var mViewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        this.fireUiBindings()
        this.fireVmBindings()
        this.registerUi()
        this.subscribeUi()
    }

    /* ui will bind itself to layouts, for consistency */
    private fun fireUiBindings(){
        /* binding is generated through BR class, this will set the view through binding */
        this.mBinding = DataBindingUtil.setContentView(this, R.layout.layout_view_activity_top_mvdm)
        /* execute pending bindings */
        this.mBinding.executePendingBindings()
    }

    private fun fireVmBindings() {
        /* generate view models of type get(T) through the factory provided */
        this.mViewModel = ViewModelProvider(this, this.mFactoryViewModel).get(ViewModelActivityTop::class.java)
    }

    private fun registerUi() {
        this.mBinding.ltViewPager.adapter = TapPagerAdapter(supportFragmentManager, TOTAL_TABS)
        this.mBinding.ltTabLayout.setupWithViewPager(this.mBinding.ltViewPager)
        this.mViewPager = this.mBinding.ltViewPager
        this.mTabLayout = this.mBinding.ltTabLayout
    }

    private fun subscribeUi() {
        this.mBinding.ltTabLayout.addOnTabSelectedListener(this)
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        when(tab?.position) {
            F1_TAB -> { mViewPager.currentItem = F1_TAB }
            F2_TAB -> { mViewPager.currentItem = F2_TAB }
        }
    }

    override fun onTabReselected(tab: TabLayout.Tab?){ /* EMPTY */ }

    override fun onTabUnselected(tab: TabLayout.Tab?){ /* EMPTY */ }

    companion object {
        const val F1_TAB = 0
        const val F2_TAB = 1
        const val TOTAL_TABS = 2
    }
}