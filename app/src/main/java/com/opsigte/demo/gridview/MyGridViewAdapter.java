package com.opsigte.demo.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.opsigte.demo.R;

public class MyGridViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater layoutInflater;

    public MyGridViewAdapter(Context context){
        this.mContext = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 30;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    static class ViewHolder{
        public ImageView iv;
        public TextView tv;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolderGrid = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_grid_item, null);
            viewHolderGrid = new ViewHolder();
            viewHolderGrid.iv = convertView.findViewById(R.id.gr_iv);
            viewHolderGrid.tv = convertView.findViewById(R.id.gr_tv);
            convertView.setTag(viewHolderGrid);
        } else {
            viewHolderGrid = (ViewHolder) convertView.getTag();
        }
//        viewHolderGrid.iv.setBackground(mContext.getResources().getDrawable(R.drawable.test));
        Glide.with(mContext).load("https://www.baidu.com/img/bd_logo1.png?where=super").into(viewHolderGrid.iv);
        return convertView;
    }
}
