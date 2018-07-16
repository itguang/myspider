package com.libstar.kb.spider.sp.doaj.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author itguang
 * @create 2018-07-16 10:07
 **/
public class AuthorBean {
    /**
     * affiliation : Department of Ophthalmology, No.2 People's Hospital of Xintai, Xintai 271200, Shandong Province, China
     * name : Bo Gao
     */

    @SerializedName("affiliation")
    private String affiliation;
    @SerializedName("name")
    private String name;

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
