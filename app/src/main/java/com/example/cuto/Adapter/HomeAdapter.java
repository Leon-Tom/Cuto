package com.example.cuto.Adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.cuto.R;


public class HomeAdapter extends BaseAdapter {

    private Context context;
    private int[] data;

    public HomeAdapter(Context context,int[] data){
        super();
        this.context = context;
        this.data = data;
    }

    @Override  //要绑定的条目的数目，比如格子的数量
    public int getCount() {
        return data.length;  //返回了需要传入的数量
    }

    @Override //根据一个索引（位置）获得该位置的对象
    public Object getItem(int position) {
        return null;
    }

    @Override  //获取条目的Id 直接传入position 默认为null, 为空的话我也不知道，反正是获取去不到条目 (裂开+1)
    public long getItemId(int position) {
        return position;
    }

    @Override //获取该条目要显示的界面
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_listview,null); //注意XML文件名 我裂开了好几次
        ImageView imageView = view.findViewById(R.id.home_list_view);  // 还要关联控件，就像activity里面一样
        imageView.setImageResource(data[position]);
        return view;
    }
}
