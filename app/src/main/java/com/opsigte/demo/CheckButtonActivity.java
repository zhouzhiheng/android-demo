package com.opsigte.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckButtonActivity extends AppCompatActivity {

    private CheckBox cb3,cb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_button);

        cb3 = findViewById(R.id.cb_3);
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckButtonActivity.this, isChecked?"3选中":"3未选中", Toast.LENGTH_LONG).show();
            }
        });

        cb4 = findViewById(R.id.cb_4);
        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckButtonActivity.this, isChecked?"4选中":"4未选中", Toast.LENGTH_LONG).show();
            }
        });
    }
}
