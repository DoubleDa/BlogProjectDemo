package com.dyx.wvah.utils;

import android.content.Context;

import org.apache.http.util.EncodingUtils;

import java.io.InputStream;

/**
 * project name：WebViewAdapterHtml
 * class describe：
 * create person：dayongxin
 * create time：16/8/9 下午11:00
 * alter person：dayongxin
 * alter time：16/8/9 下午11:00
 * alter remark：
 */
public class AssetsUtil {
    public static String getTextFromAssets(final Context context, String fileName) {
        String result = "";
        try {
            InputStream in = context.getResources().getAssets().open(fileName);
            // 获取文件的字节数
            int lenght = in.available();
            // 创建byte数组
            byte[] buffer = new byte[lenght];
            // 将文件中的数据读到byte数组中
            in.read(buffer);
            result = EncodingUtils.getString(buffer, "UTF-8");
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
