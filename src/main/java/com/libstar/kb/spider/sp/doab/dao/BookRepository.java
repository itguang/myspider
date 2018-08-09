package com.libstar.kb.spider.sp.doab.dao;

import com.libstar.kb.spider.sp.doab.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 李增光
 * @create 2018-08-09 18:00
 **/
public interface BookRepository extends JpaRepository<BookEntity,Integer> {
}
