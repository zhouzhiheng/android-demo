package com.opsigte.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnTextView;
    private Button btnButtonView;
    private Button btnEditTextView;
    private Button btnRadioButtonView;
    private Button btnCheckButtonView;


    private void setListeners(){
        OnClick onClick = new OnClick();
        btnTextView.setOnClickListener(onClick);
        btnButtonView.setOnClickListener(onClick);
        btnEditTextView.setOnClickListener(onClick);
        btnRadioButtonView.setOnClickListener(onClick);
        btnCheckButtonView.setOnClickListener(onClick);

    }

    private class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.btn_text_view:
                    intent = new Intent(MainActivity.this,TextVIewActivity.class);
                    break;
                case R.id.btn_button_view:
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_edittext_view:
                    intent = new Intent(MainActivity.this,EditTextActivity.class);
                    break;
                case R.id.btn_radioButton_view:
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_CheckButton_view:
                    intent = new Intent(MainActivity.this, CheckButtonActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTextView = findViewById(R.id.btn_text_view);
        btnButtonView = findViewById(R.id.btn_button_view);
        btnEditTextView = findViewById(R.id.btn_edittext_view);
        btnRadioButtonView = findViewById(R.id.btn_radioButton_view);
        btnCheckButtonView = findViewById(R.id.btn_CheckButton_view);
        setListeners();
    }
}
