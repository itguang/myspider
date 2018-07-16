package com.libstar.kb.spider.sp.doaj.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author itguang
 * @create 2018-07-16 10:07
 **/
public class LicenseBean {
    /**
     * url : http://ies.ijo.cn/gjykcn/ch/reader/view_news.aspx?id=20130815015707001
     * open_access : true
     * type : CC BY-NC-ND
     * title : CC BY-NC-ND
     */

    @SerializedName("url")
    private String url;
    @SerializedName("open_access")
    private boolean openAccess;
    @SerializedName("type")
    private String type;
    @SerializedName("title")
    private String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isOpenAccess() {
        return openAccess;
    }

    public void setOpenAccess(boolean openAccess) {
        this.openAccess = openAccess;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
