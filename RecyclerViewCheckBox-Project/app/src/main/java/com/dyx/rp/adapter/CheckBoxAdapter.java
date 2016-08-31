package com.dyx.rp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.dyx.rp.R;
import com.dyx.rp.model.CbModel;

import java.util.List;

/**
 * project name：RecyclerViewCheckBox-Project
 * class describe：
 * create person：dayongxin
 * create time：16/8/25 下午7:57
 * alter person：dayongxin
 * alter time：16/8/25 下午7:57
 * alter remark：
 */
public class CheckBoxAdapter extends RecyclerView.Adapter<CheckBoxAdapter.ItemVH> {
    private Context mContext;
    private List<CbModel> mDatas;
    private OnCheckBoxClickListener mOnCheckBoxClickListener;

    public interface OnCheckBoxClickListener {
        void onCheckBoxClick(int pos, boolean isClick);
    }

    public void setmOnCheckBoxClickListener(OnCheckBoxClickListener mOnCheckBoxClickListener) {
        this.mOnCheckBoxClickListener = mOnCheckBoxClickListener;
    }

    public CheckBoxAdapter(Context mContext, List<CbModel> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public ItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_cb_layout, parent, false);
        return new ItemVH(view);
    }
    

    @Override
    public void onBindViewHolder(final ItemVH holder, int position) {
        holder.mTextView.setText(mDatas.get(position).getCbContent());
        holder.mCheckBox.setTag(position);
        if (mOnCheckBoxClickListener != null) {
            holder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    int pos = (int) holder.mCheckBox.getTag();
                    mOnCheckBoxClickListener.onCheckBoxClick(pos, b);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ItemVH extends RecyclerView.ViewHolder {
        CheckBox mCheckBox;
        TextView mTextView;

        public ItemVH(View itemView) {
            super(itemView);
            mCheckBox = (CheckBox) itemView.findViewById(R.id.cb);
            mTextView = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
