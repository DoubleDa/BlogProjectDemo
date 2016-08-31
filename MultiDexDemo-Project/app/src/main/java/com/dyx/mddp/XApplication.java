package com.dyx.mddp;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * project name：MultiDexDemo-Project
 * class describe：
 * create person：dayongxin
 * create time：16/8/20 下午8:49
 * alter person：dayongxin
 * alter time：16/8/20 下午8:49
 * alter remark：
 */
public class XApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
