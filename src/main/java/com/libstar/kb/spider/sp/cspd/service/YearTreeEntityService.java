package com.libstar.kb.spider.sp.cspd.service;

import com.libstar.kb.spider.sp.cspd.dao.YearTreeEntityRepostitory;
import com.libstar.kb.spider.sp.cspd.entity.YearTreeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author itguang
 * @create 2018-06-28 17:34
 **/
@Service
@Transactional
public class YearTreeEntityService {


    @Autowired
    YearTreeEntityRepostitory yearTreeEntityRepostitory;


    /**
     * 通过 perioId 查找所有的期刊出版年限
     * @param perioId
     * @return
     */
    public List<YearTreeEntity> findAllByPerioId(String perioId){


        List<YearTreeEntity> list = yearTreeEntityRepostitory.findAllByPerioId(perioId);


        return list;
    }





}
