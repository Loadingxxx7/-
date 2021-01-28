package com.example.recyclerview.recyclerview.kotlin

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.AssetManager
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.activity_image.*

class NewsActivity : AppCompatActivity() {

    private lateinit var mContent: Context

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContent = this
        setContentView(R.layout.activity_image)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        intent.run {
            val url = getStringExtra("url")
            val desc = getStringExtra("desc")
            val title = getStringExtra("title")

            girlText.text = desc

            Glide.with(mContent)
                    .load(url)
                    .into(girlImageView)

            collapsingToolbar.run {
                setTitle(title)
                setCollapsedTitleTextColor(Color.BLACK)
                setExpandedTitleColor(Color.BLACK)
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}