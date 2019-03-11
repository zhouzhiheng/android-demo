package com.opsigte.demo.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.opsigte.demo.R;

public class ViewHolderRecyclerAdapter extends RecyclerView.Adapter {

    private Context mContent;
    private OnItemClickListener mListener;

    public ViewHolderRecyclerAdapter(Context context, OnItemClickListener listener) {
        this.mContent = context;
        this.mListener = listener;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new MyViewHolder1(LayoutInflater.from(mContent).inflate(R.layout.layout_viewholder_recycler_item1, viewGroup, false));
        } else {
            return new MyViewHolder2(LayoutInflater.from(mContent).inflate(R.layout.layout_viewholder_recycler_item2, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        // 这里设置值亦可
        if (getItemViewType(i) == 1) {
            ((MyViewHolder1)viewHolder).tv.setText("view holder 1");
        } else {
            ((MyViewHolder2)viewHolder).tv.setText("view holder 2");
            ((MyViewHolder2)viewHolder).iv.setImageResource(R.drawable.test);
        }

        // 给控件添加事件
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }


    class MyViewHolder1 extends RecyclerView.ViewHolder {

        private TextView tv;
        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.view_holder_item_tv);

            // 这里设置值亦可
            //tv.setText("test1");
        }
    }


    class MyViewHolder2 extends RecyclerView.ViewHolder {

        private TextView tv;
        private ImageView iv;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.view_holder_item_tv2);
            iv = itemView.findViewById(R.id.view_holder_item_iv2);

            // 这里设置值亦可
            //tv.setText("test2");
            //iv.setImageResource(R.drawable.test);

        }
    }

    public interface OnItemClickListener {
        void onClick(int position);
    }
}
