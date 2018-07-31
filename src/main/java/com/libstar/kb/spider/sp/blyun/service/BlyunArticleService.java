package com.libstar.kb.spider.sp.blyun.service;

import com.libstar.kb.spider.sp.blyun.dao.BlyunArticleEntityRepository;
import com.libstar.kb.spider.sp.blyun.entity.BlyunArticleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李增光
 * @create 2018-07-31 17:55
 **/
@Service
@Slf4j
public class BlyunArticleService {

    @Autowired
    BlyunArticleEntityRepository blyunArticleEntityRepository;


    public void saveAll(List<BlyunArticleEntity> list){
        blyunArticleEntityRepository.saveAll(list);
    }






}
