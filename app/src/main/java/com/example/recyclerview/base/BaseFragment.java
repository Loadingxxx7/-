package com.example.recyclerview.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.recyclerview.BuildConfig;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/29
 * @email xiaozihuan994@qq.com
 * @description .
 */
public abstract class BaseFragment extends Fragment {

    //是否懒加载
    private boolean isLoaded = false;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (BuildConfig.DEBUG){
            Log.d(this.getTag(), "onAttach: ");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(initLayout(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isLoaded) {
            lazyInit();
            isLoaded = true;
        }
        if (BuildConfig.DEBUG){
            Log.d(this.getTag(), "onResume:滑到此Fragment ");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isLoaded = false;
        if (BuildConfig.DEBUG){
            Log.d(this.getTag(), "onDestroyView: ");
        }
    }

    protected abstract void lazyInit();

    /**
     * 设置布局
     *
     * @return R.Layout.xxx
     */
    protected abstract int initLayout();



}
