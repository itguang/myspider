package com.libstar.kb.spider.sp.datadryad.service;

import com.libstar.kb.spider.sp.datadryad.dao.GryadArticleContentRepository;
import com.libstar.kb.spider.sp.datadryad.entity.DryadArticleContentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author itguang
 * @create 2018-07-10 16:24
 **/
@Service
@Transactional
public class GryadArticleContentService {


    @Autowired
    GryadArticleContentRepository repository;


    public void save(DryadArticleContentEntity entity) {

        repository.save(entity);

    }


}
