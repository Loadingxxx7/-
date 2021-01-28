package com.example.recyclerview.baserecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recyclerview.R;

public class DetailsItemActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2);
        ImageView mImageView = findViewById(R.id.iv_details);
        TextView mTextView = findViewById(R.id.tv_details);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        String url = bundle.getString("url");
        String text = bundle.getString("size");
        int length = bundle.getInt("length");

        Glide.with(this).load(url).into(mImageView);
        mTextView.setText("ImageSiza:"+text+"\nImageFlielength:"+length);

    }
}