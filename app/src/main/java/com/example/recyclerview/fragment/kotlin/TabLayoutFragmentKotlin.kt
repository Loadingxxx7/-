package com.example.recyclerview.fragment.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.recyclerview.R
import com.example.recyclerview.fragment.java.MyFragment
import com.example.recyclerview.fragment.java.RecyclerViewFragment
import com.example.recyclerview.fragment.java.WeatherFragment
import com.google.android.material.tabs.TabLayout

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/31
 * @email xiaozihuan994@qq.com
 * @description .
 */
class TabLayoutFragmentKotlin : Fragment() {
    fun newInstance(): TabLayoutFragmentKotlin{
        val args = Bundle()

        val fragment = TabLayoutFragmentKotlin()
        fragment.arguments = args
        return fragment
    }

    private val fragmentList: ArrayList<Fragment> = ArrayList()
    private val titleList: ArrayList<String> = ArrayList()

    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.activity_tab_layout, container, false)
        viewPager = view.findViewById(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabLayout)
        initFragmentList()
        initViewPager()
        return view
    }

    private fun initViewPager() {
        val fragmentAdapterKotlin = fragmentManager?.let {
            FragmentAdapterKotlin(
                    it,
                    FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                    fragmentList,
                    titleList)
        }
        viewPager.adapter = fragmentAdapterKotlin
        viewPager.offscreenPageLimit = fragmentList.size
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun initFragmentList() {
        fragmentList.run {
            add(RecyclerViewFragmentKotlin())
            add(RecyclerViewFragment.newInstance())
            add(MyFragment.newInstance())
            add(MyFragment.newInstance())
            add(MyFragment.newInstance())
        }
        titleList.run {
            add("新闻")
            add("图片")
            add("标题C")
            add("标题D")
            add("标题E")
        }

    }
}