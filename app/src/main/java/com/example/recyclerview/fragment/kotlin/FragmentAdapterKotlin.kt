package com.example.recyclerview.fragment.kotlin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/31
 * @email xiaozihuan994@qq.com
 * @description .
 */
class FragmentAdapterKotlin(
        fm: FragmentManager,
        behavior: Int,
        val fragment: List<Fragment>,
        private val title: List<String>
) : FragmentPagerAdapter(fm, behavior) {

    override fun getItem(position: Int): Fragment {
        return fragment[position]
    }

    override fun getCount(): Int {
        return fragment.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return title[position]
    }
}

