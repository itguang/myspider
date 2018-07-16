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
 * @create 2018-07-16 15:00
 **/
@Entity
@Data
@Table(name = "doaj_article_content", schema = "spider")
public class DoajArticleContentEntity {

    @Id
    private String id;
    private String articleTitle;
    private String journalTitle;
    private String issn;
    private String publisher;
    private String lastUpdated;
    private String createdDate;
    private String lccSubjectCategory;
    private String countryOfPublisher;
    private String languageOfFulltext;
    private String authors;
    private String endPage;
    private String startPage;
    private String articleAbstract;
    private String doi;
    private String fulltext;


}
