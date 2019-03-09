package com.opsigte.demo.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.opsigte.demo.R;

public class LinearRecyclerviewActivity extends AppCompatActivity {


    private RecyclerView rv;
    private LinearLayoutRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recyclerview);


        rv = findViewById(R.id.rv_tv);
        adapter = new LinearLayoutRecyclerAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);

        rv.setAdapter(adapter);


    }
}
