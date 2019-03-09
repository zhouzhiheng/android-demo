package com.opsigte.demo.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.opsigte.demo.R;


public class GridLayoutRecyclerAdapter extends RecyclerView.Adapter<GridLayoutRecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private LayoutInflater layoutInflater;

    public GridLayoutRecyclerAdapter(Context context){
        this.mContext = context;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.layout_grid_recycler_item, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GridLayoutRecyclerAdapter.MyViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 40;
    }

     class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.grid_recycler_tv);

            itemView.setBackground(mContext.getResources().getDrawable(R.drawable.test));
        }
    }
}
