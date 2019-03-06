package com.opsigte.demo;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TextVIewActivity extends AppCompatActivity {

    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        tv2 = findViewById(R.id.tv2);
        tv2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); // 中划线
        tv2.getPaint().setAntiAlias(true); // 去锯齿

        tv3 = findViewById(R.id.tv3);
        tv3.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); // 下划线

        /*跑马灯，设置默认选中*/
        tv4 = findViewById(R.id.tv4);
        tv4.setSelected(true);
    }
}
