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
 * @create 2018-07-11 8:55
 **/
@Entity
@Data
@Table(name = "doaj_article_content", schema = "spider")
public class DoajArticleContentEntity {

    @Id
    private String id;
    private String articleTitle;
    private String doi;
    private String journalTitle;
    private String issn;
    private String publisher;
    private String society;
    private String lccSubjectCategory;
    private String countryOfPublisher;
    private String languageOfFulltext;
    private String formatsAvailable;
    private String authors;
    private String articleAbstract;


}
