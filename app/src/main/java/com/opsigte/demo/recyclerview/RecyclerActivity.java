package com.opsigte.demo.recyclerview;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.opsigte.demo.R;

public class RecyclerActivity extends AppCompatActivity {

    private Button btnRecyclerLinearView,btnRecyclerGridView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        // LinearLayout Recycler view
        btnRecyclerLinearView = findViewById(R.id.btn_recycler_linear_view);
        btnRecyclerLinearView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerActivity.this,LinearRecyclerviewActivity.class);
                startActivity(intent);
            }
        });

        // GridLayout Recycler view
        btnRecyclerGridView = findViewById(R.id.btn_recycler_grid_view);
        btnRecyclerGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerActivity.this,GridLayoutRecyclerActivity.class);
                startActivity(intent);
            }
        });
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
