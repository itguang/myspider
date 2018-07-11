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
public class PerioUnitBean {
    /**
     * area : 33
     * area_code : 310030
     * pubunit_norm : null
     * perio_id : ycyyzz
     * id : 6bba2915-23f0-4358-93ef-3a3457b4f1ab
     * pubunit_name : 《远程教育杂志》编辑部
     */

    @Id
    @SerializedName("id")
    private String id;

    @SerializedName("area")
    private String area;
    @SerializedName("area_code")
    private String areaCode;
    @SerializedName("pubunit_norm")
    private String pubunitNorm;
    @SerializedName("perio_id")
    private String perioId;


    @SerializedName("pubunit_name")
    private String pubunitName;


}
