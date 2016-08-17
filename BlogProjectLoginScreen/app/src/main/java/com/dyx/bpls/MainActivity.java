package com.dyx.bpls;

import android.os.Bundle;
import android.widget.TextView;

import com.dyx.bpls.base.BaseActivity;
import com.dyx.bpls.util.FileUtils;
import com.orhanobut.logger.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * project name：BlogProjectLoginScreen
 * class describe：
 * create person：dayongxin
 * create time：16/8/7 下午10:51
 * alter person：dayongxin
 * alter time：16/8/7 下午10:51
 * alter remark：
 */
public class MainActivity extends BaseActivity {
    @Bind(R.id.show_pw)
    TextView showPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        FileUtils utils = new FileUtils(this);
        try {
            String result = utils.readDateFile("blog");
            Logger.d(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
