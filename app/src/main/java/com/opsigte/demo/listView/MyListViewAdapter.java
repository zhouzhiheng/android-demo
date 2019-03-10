package com.opsigte.demo.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.opsigte.demo.R;

public class MyListViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater layoutInflater;

    public MyListViewAdapter(Context context){
        Toast.makeText(context, "构造方法", Toast.LENGTH_LONG).show();
        this.mContext = context;
        this.layoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return 10;
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
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContent;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.list_iv);
            viewHolder.tvTitle = convertView.findViewById(R.id.list_tv_title);
            viewHolder.tvTime = convertView.findViewById(R.id.list_tv_time);
            viewHolder.tvContent = convertView.findViewById(R.id.list_tv_content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 赋值
        viewHolder.tvTitle.setText("我是标题");
        viewHolder.tvTime.setText("2019-03-07");
        viewHolder.tvContent.setText("我是内容内容....");

        // 设置本地图片
        viewHolder.imageView.setBackground(mContext.getResources().getDrawable(R.drawable.test));
        // 设置网络图片
//        Glide.with(mContext).load("https://www.baidu.com/img/bd_logo1.png?where=super").into(viewHolder.imageView);

        return convertView;
    }
}
