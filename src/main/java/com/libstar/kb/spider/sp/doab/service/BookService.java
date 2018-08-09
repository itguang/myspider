package com.libstar.kb.spider.sp.doab.service;

import com.libstar.kb.spider.sp.doab.dao.BookRepository;
import com.libstar.kb.spider.sp.doab.entity.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李增光
 * @create 2018-08-09 18:01
 **/
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void saveAll(List<BookEntity> bookEntities){
        bookRepository.saveAll(bookEntities);

    }


}
