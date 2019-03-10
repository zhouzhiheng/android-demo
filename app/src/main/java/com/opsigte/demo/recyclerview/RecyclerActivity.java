package com.opsigte.demo.recyclerview;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.opsigte.demo.R;

public class RecyclerActivity extends AppCompatActivity {


    private RecyclerView rv;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        rv = findViewById(R.id.rv_tv);

        // onClick回调函数
        adapter = new RecyclerAdapter(this, new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(RecyclerActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(linearLayoutManager);

        // 下划线
        rv.addItemDecoration(new MyDecoration());

        rv.setAdapter(adapter);
    }


    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            // 下划线
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.underlineDimen));
        }
    }
}
