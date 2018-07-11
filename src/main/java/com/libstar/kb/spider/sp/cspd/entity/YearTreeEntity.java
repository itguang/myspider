package com.libstar.kb.spider.sp.cspd.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 期刊/杂志 发行年限实体类
 *
 * @author itguang
 * @create 2018-06-27 16:06
 **/

@Data
@Entity
public class YearTreeEntity {


    /**
     * count : 11
     * expand : "null"
     * field : issue_num
     * key : 6a495cf7e1644a0fb80c702b24163fad
     * name : 2
     * newName :
     * pivot : "null"
     * id : 6a495cf7e1644a0fb80c702b24163fad
     * pid : ae8e4edf2c4f4fcca23fa3a3e7edcaaa
     */

    @Id
    @SerializedName("id")
    private String id;

    private String perioId;

    @SerializedName("count")
    private String count;
    @SerializedName("expand")
    private String expand;
    @SerializedName("field")
    private String field;
    @SerializedName("key")
    @Column(name = "my_key")
    private String key;
    @SerializedName("name")
    private String name;
    @SerializedName("newName")
    private String newName;
    @SerializedName("pivot")
    private String pivot;
    @SerializedName("pid")
    private String pid;

    /**
     * 标记此期刊号对应内容数据是否入库
     */
    @SerializedName("flag")
    private Integer flag;


}
