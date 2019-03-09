package com.opsigte.demo.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.opsigte.demo.R;

public class LinearLayoutRecyclerAdapter extends RecyclerView.Adapter<LinearLayoutRecyclerAdapter.MyViewHolder> {

    private Context mContent;

    public LinearLayoutRecyclerAdapter(Context context){
        this.mContent = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_recycler_item, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LinearLayoutRecyclerAdapter.MyViewHolder viewHolder, int i) {
        final int j = i;
        // 给控件添加事件
        viewHolder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContent, "click pos:" + j, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.item_recycler_tv);
        }
    }
}
