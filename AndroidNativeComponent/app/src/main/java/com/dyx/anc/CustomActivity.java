package com.dyx.anc;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * project name：AndroidNativeComponent
 * class describe：
 * create person：dayongxin
 * create time：16/9/1 下午11:37
 * alter person：dayongxin
 * alter time：16/9/1 下午11:37
 * alter remark：
 */
public class CustomActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        ButterKnife.bind(this);
    }
}
