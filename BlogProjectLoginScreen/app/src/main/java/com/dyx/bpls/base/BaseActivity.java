package com.dyx.bpls.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * project name：BlogProjectLoginScreen
 * class describe：
 * create person：dayongxin
 * create time：16/8/7 下午8:39
 * alter person：dayongxin
 * alter time：16/8/7 下午8:39
 * alter remark：
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showSnackbar(View view, String msg) {
        if (msg == null) {
            return;
        }
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    public boolean isNetworkOn(Context context) {
        ConnectivityManager connMgr =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    public void intentTo(Class<?> cla) {
        startActivity(new Intent(this, cla));
    }

    public void showSnackBarLoc(View myView, String msg) {
        Snackbar snackbar = Snackbar.make(myView, msg, Snackbar.LENGTH_SHORT);
        View view = snackbar.getView();
        ViewGroup.LayoutParams params = view.getLayoutParams();
        CoordinatorLayout.LayoutParams cl = new CoordinatorLayout.LayoutParams(params.width, params.height);
        cl.gravity = Gravity.TOP;
        view.setLayoutParams(cl);
        snackbar.show();
    }
}
