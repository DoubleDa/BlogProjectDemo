package com.dyx.rp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dyx.rp.adapter.MyCbAdapter;
import com.dyx.rp.model.MyCbModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * project name：RecyclerViewCheckBox-Project
 * class describe：
 * create person：dayongxin
 * create time：16/8/29 上午11:37
 * alter person：dayongxin
 * alter time：16/8/29 上午11:37
 * alter remark：
 */
public class MyCbAct extends Activity {
    @Bind(R.id.rv_my_cb)
    RecyclerView rvMyCb;
    private MyCbAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cb);
        ButterKnife.bind(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvMyCb.setLayoutManager(manager);

        adapter = new MyCbAdapter(this, getDatas());
        rvMyCb.setAdapter(adapter);
        dataChenged();
    }

    private void dataChenged() {
        for (int i = 0; i < getDatas().size(); i++) {
            if (i % 2 == 0) {
                MyCbAdapter.getIsSelected().put(i, true);
            } else {
                MyCbAdapter.getIsEnable().put(i, false);
            }
        }
        adapter.notifyDataSetChanged();
    }

    private List<MyCbModel> getDatas() {
        List<MyCbModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new MyCbModel("标题" + i));
        }
        return list;
    }


}
