package com.dyx.sapb;

import android.app.Application;

import com.antfortune.freeline.FreelineCore;

/**
 * project name：SpeedAndroidProjectBuild
 * class describe：
 * create person：dayongxin
 * create time：16/8/31 上午11:37
 * alter person：dayongxin
 * alter time：16/8/31 上午11:37
 * alter remark：
 */
public class XApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 第三步
         */
        FreelineCore.init(this);
    }
}