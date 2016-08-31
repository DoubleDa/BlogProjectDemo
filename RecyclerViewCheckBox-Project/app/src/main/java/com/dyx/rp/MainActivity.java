package com.dyx.rp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;

import com.dyx.rp.adapter.CheckBoxAdapter;
import com.dyx.rp.model.CbModel;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
    @Bind(R.id.rv)
    RecyclerView rv;
    private CheckBoxAdapter adapter;
    private SparseBooleanArray array = new SparseBooleanArray();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        adapter = new CheckBoxAdapter(this, getData());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
        adapter.setmOnCheckBoxClickListener(new CheckBoxAdapter.OnCheckBoxClickListener() {
            @Override
            public void onCheckBoxClick(int pos, boolean isClick) {
                if (array.size() == 3) {

                } else {
                    if (isClick) {
                        array.put(pos, true);
                        Logger.d("选中：" + array.size());
                    } else {
                        array.delete(pos);
                        Logger.d("取消：" + array.size());
                    }
                }
            }
        });
    }

    private List<CbModel> getData() {
        List<CbModel> lists = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            lists.add(new CbModel(i, "测试" + i));
        }
        return lists;
    }
}
