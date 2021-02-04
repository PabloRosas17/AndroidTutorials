package coffee.flavors.androidtutorials.mdvm.controller.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import coffee.flavors.androidtutorials.mdvm.views.fragments.ViewFragmentOneMVDM
import coffee.flavors.androidtutorials.mdvm.views.fragments.ViewFragmentTwoMVDM

/**
 * @author, evolandlupiz
 * @date, 2/28/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */


class TapPagerAdapter(fm: FragmentManager, private val tabs: Int) : AdapterTabView(fm){
    override fun getCount(): Int {
        return this.tabs
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> { ViewFragmentOneMVDM.instance() }
            1 -> { ViewFragmentTwoMVDM.instance() }
            else -> throw RuntimeException("TapPagerAdapter.kt, getItem(...), unknown type")
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Tab4-FragmentOne"
            1 -> return "Tab4-FragmentTwo"
        }
        return null
    }
}