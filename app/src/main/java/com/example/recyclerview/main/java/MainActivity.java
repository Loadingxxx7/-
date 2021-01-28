package com.example.recyclerview.main.java;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.recyclerview.R;
import com.example.recyclerview.fragment.java.MyFragment;
import com.example.recyclerview.fragment.java.WeatherFragment;
import com.example.recyclerview.fragment.kotlin.FragmentAdapterKotlin;
import com.example.recyclerview.fragment.kotlin.TabLayoutFragmentKotlin;
import com.example.recyclerview.main.kotlin.NoScrollViewPagerKotlin;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private MenuItem menuItem;
    private NoScrollViewPagerKotlin viewPager;

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> titleList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationMain);
        viewPager = findViewById(R.id.viewPagerMain);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        initFragmentList();
        initViewPager();
        initBottomNavigationView();
    }

    private void initFragmentList() {
        fragmentList.add(new TabLayoutFragmentKotlin());
        fragmentList.add(new TabLayoutFragmentKotlin().newInstance());
        fragmentList.add(new WeatherFragment());
        fragmentList.add(MyFragment.newInstance());
        fragmentList.add(new MyFragment());
    }

    private void initViewPager() {
        FragmentAdapterKotlin fragmentAdapter = new FragmentAdapterKotlin(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                fragmentList,titleList);
        viewPager.setAdapter(fragmentAdapter);
        viewPager.setOffscreenPageLimit(5);
        viewPager.setNoScroll(false);//禁止滑动


    }

    @SuppressLint("NonConstantResourceId")
    private void initBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            switch (itemId){
                case R.id.tab_1:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.tab_2:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.tab_3:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.tab_4:
                    viewPager.setCurrentItem(3);
                    break;
                case R.id.tab_5:
                    viewPager.setCurrentItem(4);
                    break;
            }
            return false;
        });
    }


}