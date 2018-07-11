package com.libstar.kb.spider.sp.datadryad.entity;

import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author itguang
 * @create 2018-07-10 16:05
 **/
@Entity
@Data
@Table(name = "dryad_article_content", schema = "spider", catalog = "")
public class DryadArticleContentEntity {

    @Id
    private String id;
    private String contributorAuthor;
    private String coverageSpatial;
    private String dateAccessioned;
    private String dateAvailable;
    private String dateIssued;
    private String identifier;
    private String identifierUri;
    private String description;
    private String relationHaspart;
    private String relationIsreferencedby;
    private String subject;
    private String title;
    private String type;
    private String scientificName;
    private String publicationName;
    private String dansTransferDate;
    private String dansEditIri;
    private String dansArchiveDate;


}
