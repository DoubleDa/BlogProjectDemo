package com.dyx.anc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * project name：AndroidNativeComponent
 * class describe：
 * create person：dayongxin
 * create time：16/9/1 下午3:38
 * alter person：dayongxin
 * alter time：16/9/1 下午3:38
 * alter remark：
 */
public class MenuAct extends Activity {
    @Bind(R.id.btn_basic)
    Button btnBasic;
    @Bind(R.id.btn_empty)
    Button btnEmpty;
    @Bind(R.id.btn_full_screen)
    Button btnFullScreen;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.btn_master_detail)
    Button btnMasterDetail;
    @Bind(R.id.btn_navigation_drawer)
    Button btnNavigationDrawer;
    @Bind(R.id.btn_scrolling)
    Button btnScrolling;
    @Bind(R.id.btn_settings)
    Button btnSettings;
    @Bind(R.id.btn_tabbed)
    Button btnTabbed;
    @Bind(R.id.btn_custom)
    Button btnCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_basic, R.id.btn_empty, R.id.btn_full_screen, R.id.btn_login, R.id.btn_master_detail, R.id.btn_navigation_drawer, R.id.btn_scrolling, R.id.btn_settings, R.id.btn_tabbed, R.id.btn_custom})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_basic:
                intentTo(BasicActivity.class);
                break;
            case R.id.btn_empty:
                intentTo(EmptyActivity.class);
                break;
            case R.id.btn_full_screen:
                intentTo(FullScreenActivity.class);
                break;
            case R.id.btn_login:
                intentTo(LoginActivity.class);
                break;
            case R.id.btn_master_detail:
                intentTo(MasterDetailActivityListActivity.class);
                break;
            case R.id.btn_navigation_drawer:
                intentTo(NavigationDrawerActivity.class);
                break;
            case R.id.btn_scrolling:
                intentTo(ScrollingActivity.class);
                break;
            case R.id.btn_settings:
                intentTo(SettingsActivity.class);
                break;
            case R.id.btn_tabbed:
                intentTo(TabbedActivity.class);
                break;
            case R.id.btn_custom:
                intentTo(CustomActivity.class);
                break;
            default:
                break;
        }
    }


    private void intentTo(Class<?> cla) {
        startActivity(new Intent(this, cla));
    }
}
