package com.example.recyclerview.oep

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.R
import com.example.recyclerview.materialdialogs.MaterialDialogManager
import kotlinx.android.synthetic.main.activity_set.*
import kotlinx.android.synthetic.main.set_item_1.view.*

/**
 * @author Xiaozh
 * @data 2021/1/26
 * @email xiaozihuan994@qq.com
 * @description .
 */

class SetActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set)
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = ""

        itemOne.run {
            tv_content.text = "分辨率设置"
            tv_content2.text = "480P"
            switch1.visibility = View.GONE
            setOnClickListener {
                MaterialDialogManager.showListMaterialDialog(context, R.array.resolutionRatio, listener = {
                    tv_content2.text = it.toString()
                })
            }
        }

        itemTwo.run {
            tv_content.text = "非WIFI网络播放"
            tv_content2.visibility = View.GONE
            imageView.visibility = View.GONE
        }

        itemThree.run {
            tv_content.text = "语言"
            tv_content2.text = "简体"
            switch1.visibility = View.GONE
        }

        itemFour.run {
            tv_content.text = "常见问题"
            tv_content2.visibility = View.GONE
            switch1.visibility = View.GONE
        }

        itemFive.run {
            tv_content.text = "面容ID/指纹ID 登录"
            tv_content2.visibility = View.GONE
            imageView.visibility = View.GONE
        }

        itemSix.run {
            tv_content.text = "版本"
            tv_content2.text = "V0.1.0"
            switch1.visibility = View.GONE
            imageView.visibility = View.GONE
        }

        itemSev.run {
            tv_content.text = "清除缓存"
            tv_content2.text = "20M"
            switch1.visibility = View.GONE
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}