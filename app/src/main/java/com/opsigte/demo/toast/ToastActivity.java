package com.opsigte.demo.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.opsigte.demo.R;

public class ToastActivity extends AppCompatActivity {

    private Button btnDefault,btnCenter,btnCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        btnDefault = findViewById(R.id.toast_button_default);
        btnCenter = findViewById(R.id.toast_button_center);
        btnCustom = findViewById(R.id.toast_button_custom);


        // 默认样式
        btnDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this, "默认样式", Toast.LENGTH_SHORT).show();
            }
        });


        // 居中
        btnCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(ToastActivity.this, "居中", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });

        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(ToastActivity.this);
                View view = LayoutInflater.from(ToastActivity.this).inflate(R.layout.layout_toast_view, null);
                ImageView imageView = view.findViewById(R.id.toast_iv);
                imageView.setImageResource(R.drawable.test);
                TextView textView = view.findViewById(R.id.toast_tv);
                textView.setText("自定义");
                toast.setView(view);
                toast.show();
            }
        });

    }
}
