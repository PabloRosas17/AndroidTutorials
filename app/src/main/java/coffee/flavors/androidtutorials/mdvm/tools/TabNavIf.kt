package coffee.flavors.androidtutorials.mdvm.tools

import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

/**
 * @author, evolandlupiz
 * @date, 2/28/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

interface TabNavIf: TabLayout.OnTabSelectedListener {

    var mTabLayout: TabLayout

    var mViewPager: ViewPager

    override fun onTabSelected(tab: TabLayout.Tab?)

    override fun onTabReselected(tab: TabLayout.Tab?)

    override fun onTabUnselected(tab: TabLayout.Tab?)
}