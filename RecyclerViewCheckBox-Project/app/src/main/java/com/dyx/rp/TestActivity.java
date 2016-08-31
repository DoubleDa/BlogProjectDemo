package com.dyx.rp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.dyx.rp.adapter.MyAdapter;
import com.dyx.rp.adapter.MyAdapter.ViewHolder;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * project name：RecyclerViewCheckBox-Project
 * class describe：
 * create person：dayongxin
 * create time：16/8/28 下午4:54
 * alter person：dayongxin
 * alter time：16/8/28 下午4:54
 * alter remark：
 */
public class TestActivity extends Activity {
    @Bind(R.id.tv)
    TextView tv;
    @Bind(R.id.bt_selectall)
    Button btSelectall;
    @Bind(R.id.bt_cancleselectall)
    Button btCancleselectall;
    @Bind(R.id.bt_deselectall)
    Button btDeselectall;
    @Bind(R.id.line)
    LinearLayout line;
    @Bind(R.id.lv)
    ListView lv;
    @Bind(R.id.bt_limit)
    Button btLimit;
    private MyAdapter mAdapter;
    //记录选中的条目数量
    private int checkNum;
    private ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        list = new ArrayList<String>();
        initData();
        mAdapter = new MyAdapter(list, this);
        lv.setAdapter(mAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ViewHolder holder = (ViewHolder) view.getTag();
                holder.cb.toggle();
                MyAdapter.getIsSelected().put(i, holder.cb.isChecked());

                if (holder.cb.isChecked() == true) {
                    checkNum++;
                } else {
                    checkNum--;
                }

                tv.setText("已选中" + checkNum + "项");
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 100; i++) {
            list.add("data" + " " + i);
        }
    }

    @OnClick({R.id.bt_selectall, R.id.bt_cancleselectall, R.id.bt_deselectall, R.id.bt_limit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_selectall:
                selectAll();
                break;
            case R.id.bt_cancleselectall:
                cancelAll();
                break;
            case R.id.bt_deselectall:
                deselectAll();
                break;
            case R.id.bt_limit:
                limit();
                break;
            default:
                break;
        }
    }

    private void limit() {
        for (int i = 0; i < list.size(); i++) {
            MyAdapter.getIsEnable().put(i, false);
        }
        checkNum = list.size();
        dataChanged();
    }

    private void deselectAll() {
        for (int i = 0; i < list.size(); i++) {
            if (MyAdapter.getIsSelected().get(i)) {
                MyAdapter.getIsSelected().put(i, false);
                checkNum--;
            }
        }
        dataChanged();
    }

    /**
     * 反选
     */
    private void cancelAll() {
        for (int i = 0; i < list.size(); i++) {
            if (MyAdapter.getIsSelected().get(i)) {
                MyAdapter.getIsSelected().put(i, false);
                checkNum--;
            } else {
                MyAdapter.getIsSelected().put(i, true);
                checkNum++;
            }
        }
        dataChanged();
    }

    private void selectAll() {
        for (int i = 0; i < list.size(); i++) {
            MyAdapter.getIsSelected().put(i, true);
        }
        checkNum = list.size();
        dataChanged();
    }

    private void dataChanged() {
        mAdapter.notifyDataSetChanged();
        tv.setText("已选中" + checkNum + "项");
    }

}
