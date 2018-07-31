package com.libstar.kb.spider.sp.blyun.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author 李增光
 * @create 2018-07-31 17:23
 **/
@Entity
@Data
@Table(name = "journal_temp", schema = "spider")
public class JournalTempEntity {
    private String id;
    private String categoryId;
    private String dataShopId;
    private String categoryName;
    private String dataShopName;
    private String dataType;
    private String dataName;
    private  String flag;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "category_id")
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "data_shop_id")
    public String getDataShopId() {
        return dataShopId;
    }

    public void setDataShopId(String dataShopId) {
        this.dataShopId = dataShopId;
    }

    @Basic
    @Column(name = "category_name")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "data_shop_name")
    public String getDataShopName() {
        return dataShopName;
    }

    public void setDataShopName(String dataShopName) {
        this.dataShopName = dataShopName;
    }

    @Basic
    @Column(name = "data_type")
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @Basic
    @Column(name = "data_name")
    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }


}
