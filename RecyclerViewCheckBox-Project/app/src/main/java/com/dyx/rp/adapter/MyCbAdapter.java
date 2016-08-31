package com.dyx.rp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.dyx.rp.R;
import com.dyx.rp.model.MyCbModel;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * project name：RecyclerViewCheckBox-Project
 * class describe：
 * create person：dayongxin
 * create time：16/8/29 上午11:42
 * alter person：dayongxin
 * alter time：16/8/29 上午11:42
 * alter remark：
 */
public class MyCbAdapter extends RecyclerView.Adapter<MyCbAdapter.MyVh> {

    private Context context;
    private List<MyCbModel> mDatas;
    public static SparseBooleanArray isSelected = new SparseBooleanArray();
    public static SparseBooleanArray isEnable = new SparseBooleanArray();
    private OnCbClickListener mOnCbClickListener;

    public interface OnCbClickListener {
        void onItemClick(int pos);
    }

    public static SparseBooleanArray getIsSelected() {
        return isSelected;
    }

    public static void setIsSelected(SparseBooleanArray isSelected) {
        MyCbAdapter.isSelected = isSelected;
    }

    public static SparseBooleanArray getIsEnable() {
        return isEnable;
    }

    public static void setIsEnable(SparseBooleanArray isEnable) {
        MyCbAdapter.isEnable = isEnable;
    }

    public MyCbAdapter(Context context, List<MyCbModel> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        initData();
    }

    private void initData() {
        for (int i = 0; i < mDatas.size(); i++) {
            isSelected.put(i, false);
            isEnable.put(i, true);
        }
    }

    @Override
    public MyVh onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_layout, parent, false);
        return new MyVh(view);
    }

    @Override
    public void onBindViewHolder(MyVh holder, final int position) {
        holder.tvTitle.setText(mDatas.get(position).getTitle());
        holder.cbTitle.setTag(position);
        holder.cbTitle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    isSelected.put(position, true);
                } else {
                    isSelected.put(position, false);
                }
            }
        });
        holder.cbTitle.setChecked(isSelected.get(position));
        holder.cbTitle.setEnabled(isEnable.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class MyVh extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_title)
        TextView tvTitle;
        @Bind(R.id.cb_title)
        CheckBox cbTitle;

        public MyVh(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
