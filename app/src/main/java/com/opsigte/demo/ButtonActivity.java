package com.opsigte.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity {

    private Button btn_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        btn_5 = findViewById(R.id.btn_5);
    }

    public void showToast(View view){
        Toast.makeText(this, "btn5被点击了", Toast.LENGTH_LONG).show();
    }
}
