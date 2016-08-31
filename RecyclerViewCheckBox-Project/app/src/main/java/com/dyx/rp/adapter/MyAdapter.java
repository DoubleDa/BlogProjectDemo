package com.dyx.rp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.dyx.rp.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * project name：RecyclerViewCheckBox-Project
 * class describe：
 * create person：dayongxin
 * create time：16/8/28 下午4:56
 * alter person：dayongxin
 * alter time：16/8/28 下午4:56
 * alter remark：
 */
public class MyAdapter extends BaseAdapter {
    private ArrayList<String> list;
    private static HashMap<Integer, Boolean> isSelected;
    private static HashMap<Integer, Boolean> isEnable;
    private Context context;
    private LayoutInflater inflater = null;

    public static HashMap<Integer, Boolean> getIsEnable() {
        return isEnable;
    }

    public static void setIsEnable(HashMap<Integer, Boolean> isEnable) {
        MyAdapter.isEnable = isEnable;
    }

    public MyAdapter(ArrayList<String> list, Context context) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
        isSelected = new HashMap<Integer, Boolean>();
        isEnable = new HashMap<Integer, Boolean>();
        initDate();
    }

    private void initDate() {
        for (int i = 0; i < list.size(); i++) {
            getIsSelected().put(i, false);
            getIsEnable().put(i, false);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_view_item_layout, null);
            holder.tv = (TextView) convertView.findViewById(R.id.item_tv);
            holder.cb = (CheckBox) convertView.findViewById(R.id.item_cb);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv.setText(list.get(position));
        holder.cb.setChecked(getIsSelected().get(position));
        //holder.cb.setChecked(false);
        holder.cb.setEnabled(getIsEnable().get(position));
        //holder.cb.setEnabled(false);
        return convertView;
    }

    public static HashMap<Integer, Boolean> getIsSelected() {
        return isSelected;
    }

    public static void setIsSelected(HashMap<Integer, Boolean> isSelected) {
        MyAdapter.isSelected = isSelected;
    }

    public static class ViewHolder {
        public TextView tv;
        public CheckBox cb;
    }
}
