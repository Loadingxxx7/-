package com.example.recyclerview.recyclerview.kotlin

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/5
 * @email xiaozihuan994@qq.com
 * @description 设置RecyclerView中item的间距
 */
class SpaceItemDecorationKotlin(
        var space: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.run {
            left = space
            right = space
            bottom = space

            top = space

        }

    }

}