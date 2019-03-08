package com.opsigte.demo.gridview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.opsigte.demo.R;

public class GridViewActivity extends AppCompatActivity {

    private GridView gv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gv = findViewById(R.id.gv1);
        gv.setAdapter(new MyGridViewAdapter(GridViewActivity.this));

        /*点击事件*/
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "click pos:" + position, Toast.LENGTH_SHORT).show();
            }
        });

        /*长按事件*/
        gv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "长按pos:" + position, Toast.LENGTH_SHORT).show();
                // 返回true表示其他事件不再执行
                return true;
            }
        });

    }
}
