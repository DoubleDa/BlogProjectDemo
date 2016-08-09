package com.dyx.wvah;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.dyx.wvah.bean.DataBean;
import com.dyx.wvah.utils.AssetsUtil;
import com.dyx.wvah.utils.HtmlUtil;
import com.dyx.wvah.utils.JsonHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.wv)
    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //第四种方法注释
        //initView();
        //第一种方法：设置LayoutAlgorithm属性
        //useLayoutAlgorithm();

        //第二种方法：设置View
        //useView();

        //第三种方法：使用DisplayMetrics
        //useDisplayMetrics();

        //第四种方法：组装html代码
        generateHtml();
    }

    private void generateHtml() {
        String result = AssetsUtil.getTextFromAssets(this, "temp.json");
        try {
            DataBean dataBean = JsonHelper.fromJson(result, DataBean.class);
            wv.loadData(HtmlUtil.getFormatHtml(dataBean.getData().getDetails()), "text/html", "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void useDisplayMetrics() {
        WebSettings settings = wv.getSettings();
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int mDensity = metrics.densityDpi;


        if (mDensity == 120) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.CLOSE);
        } else if (mDensity == 160) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
        } else if (mDensity == 240) {
            settings.setDefaultZoom(WebSettings.ZoomDensity.FAR);
        }
    }

    private void useView() {
        WebSettings settings = wv.getSettings();
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
    }

    private void initView() {
        String result = AssetsUtil.getTextFromAssets(this, "temp.json");
        try {
            DataBean dataBean = JsonHelper.fromJson(result, DataBean.class);
            wv.loadData(dataBean.getData().getDetails(), "text/html", "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void useLayoutAlgorithm() {
        WebSettings settings = wv.getSettings();
        /**
         * NARROW_COLUMNS:可能的话使所有列的宽度不超过屏幕宽度
         * NORMAL:正常显示不做任何渲染
         * SINGLE_COLUMN:把所有内容放大webview等宽的一列中
         */
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
    }
}
