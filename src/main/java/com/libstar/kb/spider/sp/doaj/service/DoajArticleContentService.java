package com.libstar.kb.spider.sp.doaj.service;

import com.libstar.kb.spider.sp.doaj.dao.DoajArticleContentRepository;
import com.libstar.kb.spider.sp.doaj.entity.DoajArticleContentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author itguang
 * @create 2018-07-11 10:01
 **/
@Service
@Transactional
public class DoajArticleContentService {

    @Autowired
    DoajArticleContentRepository repository;


    public void saveAll(List<DoajArticleContentEntity> list) {

        repository.saveAll(list);
    }


}
