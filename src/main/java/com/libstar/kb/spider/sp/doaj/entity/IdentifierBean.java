package com.libstar.kb.spider.sp.doaj.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author itguang
 * @create 2018-07-16 10:07
 **/
public class IdentifierBean {
    /**
     * type : doi
     * id : 10.3980/j.issn.1672-5123.2015.10.16
     */

    @SerializedName("type")
    private String type;
    @SerializedName("id")
    private String id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
