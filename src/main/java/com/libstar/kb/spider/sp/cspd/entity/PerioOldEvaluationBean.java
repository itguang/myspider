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
public class PerioOldEvaluationBean {
    /**
     * from_db : null
     * affectoi : 8.02799987792969
     * perio_id : ycyyzz
     * id : a68f933f-a3cc-4a14-9832-a8756dfd65ea
     * core_version : 2014-2015
     * core_code : NJU
     */

    @Id
    @SerializedName("id")
    private String id;

    @SerializedName("from_db")
    private String fromDb;
    @SerializedName("affectoi")
    private String affectoi;
    @SerializedName("perio_id")
    private String perioId;


    @SerializedName("core_version")
    private String coreVersion;
    @SerializedName("core_code")
    private String coreCode;

}
