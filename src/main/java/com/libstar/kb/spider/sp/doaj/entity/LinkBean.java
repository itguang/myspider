package com.libstar.kb.spider.sp.doaj.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author itguang
 * @create 2018-07-16 10:07
 **/
public class LinkBean {
    /**
     * url : http://ies.ijo.cn/cn_publish/2015/10/201510016.pdf
     * type : fulltext
     */

    @SerializedName("url")
    private String url;
    @SerializedName("type")
    private String type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
