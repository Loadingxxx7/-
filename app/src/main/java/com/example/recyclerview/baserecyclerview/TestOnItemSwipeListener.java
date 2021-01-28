package com.example.recyclerview.baserecyclerview;

import android.graphics.Canvas;

import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.listener.OnItemSwipeListener;

/**
 * @author Xiaozh
 * @data 2021/1/18
 * @email xiaozihuan994@qq.com
 * @description .
 */
public abstract class TestOnItemSwipeListener implements OnItemSwipeListener {


    @Override
    public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public void clearView(RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float v, float v1, boolean b) {

    }
}
