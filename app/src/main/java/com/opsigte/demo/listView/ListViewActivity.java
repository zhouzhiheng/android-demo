package com.opsigte.demo.listView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.opsigte.demo.R;

public class ListViewActivity extends AppCompatActivity {

    private ListView lv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        lv1 = findViewById(R.id.lv_1);
        lv1.setAdapter(new MyListViewAdapter(ListViewActivity.this));

    }
}
