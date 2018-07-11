package com.libstar.kb.spider.sp.doaj.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author itguang
 * @create 2018-07-11 9:00
 **/
@Entity
@Data
@Table(name = "doaj_article", schema = "spider")
public class DoajArticleEntity {

    @Id
    private String id;
    private Integer flag;

}
