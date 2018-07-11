package com.libstar.kb.spider.sp.datadryad.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author itguang
 * @create 2018-07-09 16:58
 **/
@Entity
@Table(name = "dryad_article", schema = "spider")
@Data
@DynamicInsert
public class DryadArticleEntity {


    @Id
    private String id;
    private String url;
    private int flag = 0;

}
