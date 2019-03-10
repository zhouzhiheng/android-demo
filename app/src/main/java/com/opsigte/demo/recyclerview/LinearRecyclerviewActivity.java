package com.opsigte.demo.recyclerview;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.opsigte.demo.R;

public class LinearRecyclerviewActivity extends AppCompatActivity {


    private RecyclerView rv;
    private LinearLayoutRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recyclerview);


        rv = findViewById(R.id.rv_tv);
        adapter = new LinearLayoutRecyclerAdapter(this, new LinearLayoutRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(LinearRecyclerviewActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });

        // 设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);

        // 设置下划线
        rv.addItemDecoration(new MyItemDecora());

        // 设置适配器
        rv.setAdapter(adapter);
    }


    class MyItemDecora extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            // 下划线
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.underlineDimen));
        }
    }
}
