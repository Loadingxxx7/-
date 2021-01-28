package com.example.recyclerview.fragment.java;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.recyclerview.R;
import com.example.recyclerview.base.BaseFragment;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/29
 * @email xiaozihuan994@qq.com
 * @description .
 */
public class MyFragment extends BaseFragment {
    public static MyFragment newInstance() {

        Bundle args = new Bundle();

        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void lazyInit() {
        TextView textView = getView().findViewById(R.id.tv_fragment);
        textView.setText("Fragment....");
        Log.d("123", "lazyInit: 滑到");
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment;
    }


}
