package com.dyx.rp.model;

/**
 * project name：RecyclerViewCheckBox-Project
 * class describe：
 * create person：dayongxin
 * create time：16/8/25 下午8:24
 * alter person：dayongxin
 * alter time：16/8/25 下午8:24
 * alter remark：
 */
public class CbModel {

    public CbModel(int cbType, String cbContent) {
        this.cbType = cbType;
        this.cbContent = cbContent;
    }

    /**
     * cbType : 2
     * cbContent : 测试
     */

    private int cbType;
    private String cbContent;

    public int getCbType() {
        return cbType;
    }

    public void setCbType(int cbType) {
        this.cbType = cbType;
    }

    public String getCbContent() {
        return cbContent;
    }

    public void setCbContent(String cbContent) {
        this.cbContent = cbContent;
    }
}
