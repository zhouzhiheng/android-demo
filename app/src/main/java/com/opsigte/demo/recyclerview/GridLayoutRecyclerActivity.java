package com.opsigte.demo.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.opsigte.demo.R;

public class GridLayoutRecyclerActivity extends AppCompatActivity {

    private RecyclerView gridRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout_recycler);

        gridRecyclerView = findViewById(R.id.grid_recycler_view);
        // 设置网格管理器
        gridRecyclerView.setLayoutManager(new GridLayoutManager(GridLayoutRecyclerActivity.this,4));
        // 设置适配器
        gridRecyclerView.setAdapter(new GridLayoutRecyclerAdapter(GridLayoutRecyclerActivity.this));

    }
}
