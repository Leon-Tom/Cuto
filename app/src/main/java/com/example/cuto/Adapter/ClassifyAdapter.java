package com.example.cuto.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class ClassifyAdapter extends BaseAdapter {        //同样使用一个BaseAdapter，继承，再写一个分类的页面的适配器
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
