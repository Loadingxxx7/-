package com.example.recyclerview.main.kotlin

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.recyclerview.R
import com.example.recyclerview.baserecyclerview.BaseRecyclerViewFragment
import com.example.recyclerview.baserecyclerview.MultipleItemFragment
import com.example.recyclerview.fragment.java.MyFragment
import com.example.recyclerview.fragment.java.WeatherFragment
import com.example.recyclerview.fragment.kotlin.FragmentAdapterKotlin
import com.example.recyclerview.fragment.kotlin.TabLayoutFragmentKotlin
import com.example.recyclerview.materialdialogs.DialogsFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/4
 * @email xiaozihuan994@qq.com
 * @description .
 */
class MainActivityKotlin : AppCompatActivity() {

    private val fragmentList: ArrayList<Fragment> = ArrayList()
    private val titleList: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPagerMain.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                val menuItem = bottomNavigationMain.menu.getItem(position)
                menuItem.isChecked = true
            }

            override fun onPageSelected(position: Int) {
            }

        })
        initFragmentList()
        initViewPager()
        initBottomNavigationView()
    }

    private fun initFragmentList() {
        fragmentList.run {
            add(TabLayoutFragmentKotlin().newInstance())
            add(WeatherFragment.newInstance())
            add(BaseRecyclerViewFragment.newInstance())
            add(DialogsFragment())
            add(MyFragment.newInstance())
        }
    }

    private fun initViewPager() {
        val fragmentAdapterKotlin = FragmentAdapterKotlin(
                supportFragmentManager,
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                fragmentList,
                titleList
        )
        viewPagerMain.run {
            adapter = fragmentAdapterKotlin
            offscreenPageLimit = 5
            setNoScroll(false)
        }
    }

    private fun initBottomNavigationView() {
        bottomNavigationMain.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.tab_1 -> {
                    viewPagerCurrentItem(viewPagerMain, 0)
                }
                R.id.tab_2 -> {
                    viewPagerCurrentItem(viewPagerMain, 1)
                }
                R.id.tab_3 -> {
                    viewPagerCurrentItem(viewPagerMain, 2)
                }
                R.id.tab_4 -> {
                    viewPagerCurrentItem(viewPagerMain, 3)
                }
                R.id.tab_5 -> {
                    viewPagerCurrentItem(viewPagerMain, 4)
                }
                else -> false

            }
        }
    }

    private fun viewPagerCurrentItem(viewPager: ViewPager, item: Int): Boolean {
        viewPager.currentItem = item
        return false
    }
}