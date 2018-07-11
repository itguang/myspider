package com.libstar.kb.spider.sp.cspd.dao;

import com.libstar.kb.spider.sp.cspd.entity.YearTreeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YearTreeEntityRepostitory extends JpaRepository<YearTreeEntity,String> {


    /**
     * 通过 perioId 查找所有的期刊出版年限
     * @param perioId
     * @return
     */
    List<YearTreeEntity> findAllByPerioId(String perioId);








}
