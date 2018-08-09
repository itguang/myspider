package com.libstar.kb.spider.sp.doab.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 李增光
 * @create 2018-08-09 16:53
 **/
@Data
@Entity
@Table(name = "doab_book", schema = "spider")
public class BookEntity {

   @Id
   @GeneratedValue
   private  Integer id;
   private String author;
   private String name;
   private String img;
   private String isbn;
   private String year;
   private String pages;
   private String publisher;
   private String subject;
   private String description;
   private String keywords;
   private String doi;
   private String language;
   private String dateOfAddDoab;


}
