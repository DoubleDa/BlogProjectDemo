package com.dyx.bpls;

import android.os.Bundle;
import android.widget.Button;

import com.dyx.bpls.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * project name：BlogProjectLoginScreen
 * class describe：
 * create person：dayongxin
 * create time：16/8/9 上午11:11
 * alter person：dayongxin
 * alter time：16/8/9 上午11:11
 * alter remark：
 */
public class LaunchActivity extends BaseActivity {
    @Bind(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login)
    public void onClick() {
        intentTo(LoginActivity.class);
        finish();
    }
}
