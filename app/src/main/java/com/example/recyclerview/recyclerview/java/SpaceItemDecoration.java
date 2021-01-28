package com.example.recyclerview.recyclerview.java;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/24
 * @email xiaozihuan994@qq.com
 * @description 设置RecyclerView中item的间距
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    int mSpace;

    public SpaceItemDecoration(int space) {
        this.mSpace = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view,
                               @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = mSpace;
        outRect.right = mSpace;
        outRect.bottom = mSpace;
        if (parent.getChildAdapterPosition(view) != 0) {
            outRect.top = mSpace;
        }
    }
}
