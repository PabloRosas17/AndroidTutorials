package coffee.flavors.androidtutorials.mdvm.controller.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * @author, evolandlupiz
 * @date, 2/28/2020
 * @property, AndroidTutorials
 * @purpose, TODO: drop comment for file header purpose.
 */

abstract class AdapterTabView(fm: FragmentManager): FragmentPagerAdapter(fm) {

    abstract override fun getCount(): Int

    abstract override fun getItem(position: Int): Fragment
}