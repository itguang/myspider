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
public class PerioNewEvaluationBean {
    /**
     * from_db : null
     * affectoi : 11.0299997329712
     * perio_id : ycyyzz
     * id : 1c412523-b092-4d45-87f5-56b59a1afd27
     * core_version : 2014-2015
     * core_code : NJU
     */
    @Id
    @SerializedName("id")
    private String id;

    @SerializedName("affectoi")
    private String affectoi;
    @SerializedName("perio_id")
    private String perioId;


    @SerializedName("core_version")
    private String coreVersion;
    @SerializedName("core_code")
    private String coreCode;


}
