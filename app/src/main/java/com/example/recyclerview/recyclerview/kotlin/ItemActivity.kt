package com.example.recyclerview.recyclerview.kotlin

import android.app.Instrumentation
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.activity_item.*

/**
 * @author Xiaozh
 * @version 1.0
 * @data 2020/12/30
 * @email xiaozihuan994@qq.com
 * @description .
 */
class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val intent: Intent = this.intent
        val bundle: Bundle? = intent.extras

        bundle?.let {
            val url = it.getString("data")
            Glide.with(this).load(url).fitCenter().into(item_image)
        }
        item_image.setOnClickListener {
            this.finish()
        }
    }

}

