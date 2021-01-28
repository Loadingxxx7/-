package com.example.recyclerview.main.kotlin

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2021/1/4
 * @email xiaozihuan994@qq.com
 * @description .
 */
open class NoScrollViewPagerKotlin(
        context: Context,
        attrs: AttributeSet?
) : ViewPager(context, attrs) {

    private var noScroll:Boolean = true

    fun setNoScroll(noScroll:Boolean){
        this.noScroll = noScroll
    }

    override fun scrollTo(x: Int, y: Int) {
        super.scrollTo(x, y)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent?): Boolean = if (!noScroll) false else super.onTouchEvent(ev)

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return if (!noScroll){
            false
        }else{
            super.onInterceptTouchEvent(ev)
        }
    }

    fun setsetCurrentItem(item:Int){
        super.setCurrentItem(item)
    }
}