package com.opsigte.demo.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.opsigte.demo.R;

public class StaggeredGridRecyclerAdapter extends RecyclerView.Adapter<StaggeredGridRecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater layoutInflater;

    public StaggeredGridRecyclerAdapter (Context context){
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public StaggeredGridRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.layout_staggered_grid_item, viewGroup, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredGridRecyclerAdapter.MyViewHolder viewHolder, int i) {
        if (i % 2 == 0) {
            viewHolder.iv1.setImageResource(R.drawable.image1);
        } else {
            viewHolder.iv1.setImageResource(R.drawable.image2);
        }
    }

    @Override
    public int getItemCount() {
        return 40;
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv1 = itemView.findViewById(R.id.stagger_recycler_iv1);
        }
    }
}
