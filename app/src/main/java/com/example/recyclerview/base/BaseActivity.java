package com.example.recyclerview.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/29
 * @email xiaozihuan994@qq.com
 * @description .
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(initLayoutId());
        initView();
    }

    /**
     * 设置ContentView
     *
     * @return R.layout.xxx
     */
    protected abstract int initLayoutId();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * Toast
     */
    public void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
