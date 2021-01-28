package com.example.recyclerview.fragment.java;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/29
 * @email xiaozihuan994@qq.com
 * @description .
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragments;
    private final List<String> mTitle;

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior,
                           List<Fragment> fragments, List<String> title) {
        super(fm, behavior);
        this.mFragments = fragments;
        this.mTitle = title;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
