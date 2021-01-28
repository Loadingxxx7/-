package com.example.recyclerview.recyclerview.kotlin

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/5
 * @email xiaozihuan994@qq.com
 * @description .
 */
abstract class EndlessRecyclerOnScrollListenerKotlin : RecyclerView.OnScrollListener() {

    private var isSlidingUpward: Boolean = false

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        val manager: LinearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            val lastItemPosition: Int = manager.findLastVisibleItemPosition()
            val itemCount: Int = manager.itemCount

            if (lastItemPosition == (itemCount - 1) && isSlidingUpward) {
                onLoadMore()
            }
        }
    }

    abstract fun onLoadMore()

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        isSlidingUpward = dy > 0
    }
}