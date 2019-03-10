package com.opsigte.demo.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.opsigte.demo.R;

public class RecyclerActivity extends AppCompatActivity {

    private Button btnRecyclerLinearView,btnRecyclerGridView,btnStaggeredView;


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

        // Staggered Recycler view
        btnStaggeredView = findViewById(R.id.btn_recycler_staggered_view);
        btnStaggeredView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerActivity.this,StaggeredGridRecyclerActivity.class);
                startActivity(intent);
            }
        });
    }
}
