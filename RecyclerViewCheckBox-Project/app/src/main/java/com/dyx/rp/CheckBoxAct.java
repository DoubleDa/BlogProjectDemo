package com.dyx.rp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * project name：RecyclerViewCheckBox-Project
 * class describe：
 * create person：dayongxin
 * create time：16/8/28 下午7:06
 * alter person：dayongxin
 * alter time：16/8/28 下午7:06
 * alter remark：
 */
public class CheckBoxAct extends Activity {
    @Bind(R.id.cb_test)
    CheckBox cbTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        ButterKnife.bind(this);
        //cbTest.setChecked(false);
        cbTest.setEnabled(false);
    }
}
