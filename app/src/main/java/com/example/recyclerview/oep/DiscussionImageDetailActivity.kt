package com.example.recyclerview.oep

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.activity_discussion_image_detail.*
import kotlinx.android.synthetic.main.activity_item.view.*

class DiscussionImageDetailActivity : AppCompatActivity() {

    var imageUrlList: ArrayList<String> = ArrayList()

    var position: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discussion_image_detail)

        intent.run {
            position = getIntExtra("position", 0)
            imageUrlList = getStringArrayListExtra("imageUrlList") as ArrayList<String>
        }

        vpImage.adapter = VpImageAdapter(position, imageUrlList)
        vpImage.currentItem = position
    }

    internal class VpImageAdapter(
            val position: Int,
            private val imageUrlList: ArrayList<String>
    ) : PagerAdapter() {

        override fun getCount(): Int {
            return imageUrlList.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }


        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val view = LayoutInflater.from(container.context)
                    .inflate(R.layout.activity_item, null)
            Glide.with(container.context)
                    .load(imageUrlList[position])
                    .into(view.item_image)
            container.addView(view)
            return view
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View?)
        }

    }
}