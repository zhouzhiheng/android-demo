package com.opsigte.demo.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.opsigte.demo.R;

public class StaggeredGridRecyclerActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered_grid_recycler);


        rv = findViewById(R.id.stagger_recycler_view);
        // 2列
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        // 设置布局管理器
        rv.setLayoutManager(manager);
        // 设置适配器
        rv.setAdapter(new StaggeredGridRecyclerAdapter(StaggeredGridRecyclerActivity.this));


    }
}
