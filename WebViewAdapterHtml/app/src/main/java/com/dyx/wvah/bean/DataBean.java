package com.dyx.wvah.bean;

/**
 * project name：WebViewAdapterHtml
 * class describe：
 * create person：dayongxin
 * create time：16/8/9 下午10:55
 * alter person：dayongxin
 * alter time：16/8/9 下午10:55
 * alter remark：
 */
public class DataBean {

    /**
     * details : <p><img src="http://img.i-kitchen.cn/upload/7424af75-838c-46ee-b3bf-a3848798691e.jpg"/><img src="http://img.i-kitchen.cn/upload/e4285eed-5856-4529-8745-56ac26854dec.jpg"/><img src="http://img.i-kitchen.cn/upload/bd1e58bc-9084-4f73-ba5d-8dbe096973f5.jpg"/><img src="http://img.i-kitchen.cn/upload/8215c536-734b-44bd-a052-9b0d71b3d83d.jpg"/><img src="http://img.i-kitchen.cn/upload/92a64e0c-8771-4837-b0b9-466634c89534.jpg"/></p>
     */

    private DataEntity data;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        private String details;

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }
}
