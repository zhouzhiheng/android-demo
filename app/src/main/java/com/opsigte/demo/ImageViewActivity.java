package com.opsigte.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);


        iv2 = findViewById(R.id.iv_2);
        Glide.with(this).load("https://www.baidu.com/img/bd_logo1.png?where=super").into(iv2);
        Toast.makeText(this, "提示", Toast.LENGTH_LONG).show();

    }
}
