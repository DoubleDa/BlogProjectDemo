package com.dyx.anc.designmodel;

/**
 * project name：AndroidNativeComponent
 * class describe：
 * create person：dayongxin
 * create time：16/9/1 下午10:06
 * alter person：dayongxin
 * alter time：16/9/1 下午10:06
 * alter remark：
 */
public class ImageLoader {
    private static ImageLoader ourInstance = new ImageLoader();

    public static ImageLoader getInstance() {
        return ourInstance;
    }

    private ImageLoader() {
    }
}
