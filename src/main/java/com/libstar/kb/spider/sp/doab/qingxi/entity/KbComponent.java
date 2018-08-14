package com.libstar.kb.spider.sp.doab.qingxi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author 李增光
 * @create 2018-08-14 14:13
 **/
@Entity
@Table(name = "kb_component", schema = "spider", catalog = "")
public class KbComponent {
    private long kbcId;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KBC_ID", nullable = false)
    public long getKbcId() {
        return kbcId;
    }

    public void setKbcId(long kbcId) {
        this.kbcId = kbcId;
    }


}
