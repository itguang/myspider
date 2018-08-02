package com.libstar.kb.spider.sp.blyun.service;

import com.libstar.kb.spider.sp.blyun.dao.JournalTempRepository;
import com.libstar.kb.spider.sp.blyun.entity.JournalTempEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 李增光
 * @create 2018-07-31 17:30
 **/
@Service
@Slf4j
@Transactional
public class JournalTempService {

    @Autowired
    JournalTempRepository journalTempRepository;

    public  List<String> journalTempList(){
        List<JournalTempEntity> list = journalTempRepository.findAll();
        List<String> categoryIds = list.stream().filter(entity -> "0".equals(entity.getFlag())).map(JournalTempEntity::getCategoryId).distinct().collect(Collectors.toList());
        return categoryIds;
    }

    /**
     * 根据flag返回一个
     * @param flag
     * @return
     */
    public JournalTempEntity findOneByFlag(String flag){
        JournalTempEntity entity = journalTempRepository.findDistinctFirstByFlag(flag);
        return entity;
    }

    /**
     * 更新标记
     * @param flag
     * @param categoryId
     */
    public void updateFlag(String flag,String categoryId){
        journalTempRepository.updateFlag(flag,categoryId);
    }

}
