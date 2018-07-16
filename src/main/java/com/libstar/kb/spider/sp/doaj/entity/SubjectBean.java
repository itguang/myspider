package com.libstar.kb.spider.sp.doaj.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author itguang
 * @create 2018-07-16 10:07
 **/
public class SubjectBean {
    /**
     * scheme : LCC
     * term : Ophthalmology
     * code : RE1-994
     */

    @SerializedName("scheme")
    private String scheme;
    @SerializedName("term")
    private String term;
    @SerializedName("code")
    private String code;

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
