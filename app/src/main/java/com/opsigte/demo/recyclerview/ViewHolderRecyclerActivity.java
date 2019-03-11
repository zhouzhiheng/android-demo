package com.opsigte.demo.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.opsigte.demo.R;

public class ViewHolderRecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_holder_recycler);

        recyclerView = findViewById(R.id.holder_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(ViewHolderRecyclerActivity.this));
        recyclerView.setAdapter(new ViewHolderRecyclerAdapter(ViewHolderRecyclerActivity.this, new ViewHolderRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(ViewHolderRecyclerActivity.this, "pos:" + position, Toast.LENGTH_SHORT).show();
            }
        }));

    }
}
