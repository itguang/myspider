package com.libstar.kb.spider.sp.cspd.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author itguang
 * @create 2018-06-27 20:01
 **/
@Data
@Entity
public class PerioAuthorsBean {
    /**
     * 200241 :
     * 上海 :
     * perio_id : ycyyzz
     * unit_name_en : null
     * authors_role :
     * scholar_id : 2899960
     * is_group :
     * unit_name : 华东师范大学 经管学部 信息管理系
     * article_id : ycyyzz201705003
     * record_id : 324822
     * trans_authname : Ma Xiaoling
     * org_id : null
     * authors_seq : 3
     * id : f02d8d79-003d-472c-bd9e-6e8267a16ace
     * authors_name : 马晓玲
     * org_name : null
     * 200062 :
     */

    @Id
    @SerializedName("id")
    private String id;

    @SerializedName("perio_id")
    private String perioId;
    @SerializedName("unit_name_en")
    private String unitNameEn;
    @SerializedName("authors_role")
    private String authorsRole;
    @SerializedName("scholar_id")
    private String scholarId;
    @SerializedName("is_group")
    private String isGroup;
    @SerializedName("unit_name")
    private String unitName;
    @SerializedName("article_id")
    private String articleId;
    @SerializedName("record_id")
    private String recordId;
    @SerializedName("trans_authname")
    private String transAuthname;
    @SerializedName("org_id")
    private String orgId;
    @SerializedName("authors_seq")
    private String authorsSeq;

    @SerializedName("authors_name")
    private String authorsName;
    @SerializedName("org_name")
    private String orgName;


}
