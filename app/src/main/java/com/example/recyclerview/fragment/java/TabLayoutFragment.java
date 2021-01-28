package com.example.recyclerview.fragment.java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.recyclerview.R;
import com.example.recyclerview.fragment.kotlin.RecyclerViewFragmentKotlin;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutFragment extends Fragment {
    public static TabLayoutFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TabLayoutFragment fragment = new TabLayoutFragment();
        fragment.setArguments(args);
        return fragment;
    }



    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> titleList = new ArrayList<>();
    //    private final List<View> viewList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.activity_tab_layout,container,false);

        mTabLayout = view.findViewById(R.id.tabLayout);
        mViewPager = view.findViewById(R.id.viewPager);
        initFragmentList();
        initViewPager();
        return view;
    }

    private void initFragmentList() {
        fragmentList.add(RecyclerViewFragment.newInstance());
        fragmentList.add(new MyFragment());
        fragmentList.add(new RecyclerViewFragmentKotlin());
        fragmentList.add(new MyFragment());
        fragmentList.add(new MyFragment());
        titleList.add("标题1");
        titleList.add("标题2");
        titleList.add("标题3");
        titleList.add("标题4");
        titleList.add("标题5");

    }

    private void initViewPager() {
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                fragmentList, titleList);
        mViewPager.setAdapter(fragmentAdapter);
        mViewPager.setOffscreenPageLimit(4);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}