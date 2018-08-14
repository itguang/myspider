package com.libstar.kb.spider.sp.doab.qingxi.dao;

import com.libstar.kb.spider.sp.doab.qingxi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 李增光
 * @create 2018-08-14 14:14
 **/
public interface DcBookRepository extends JpaRepository<Book,Long> {



    List<Book> findAllByIsbn10(String isbn10);


    List<Book> findAllByIsbn13(String isbn13);

}
