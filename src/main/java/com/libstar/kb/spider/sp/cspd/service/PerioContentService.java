package com.libstar.kb.spider.sp.cspd.service;

import com.libstar.kb.spider.sp.cspd.dao.PerioAuthorsBeanRepository;
import com.libstar.kb.spider.sp.cspd.dao.PerioContentRepository;
import com.libstar.kb.spider.sp.cspd.dao.PerioNewEvaluationBeanRepository;
import com.libstar.kb.spider.sp.cspd.dao.PerioOldEvaluationBeanRepository;
import com.libstar.kb.spider.sp.cspd.dao.PerioUnitBeanRepository;
import com.libstar.kb.spider.sp.cspd.entity.OpBean;
import com.libstar.kb.spider.sp.cspd.entity.PerioAuthorsBean;
import com.libstar.kb.spider.sp.cspd.entity.PerioContentEntity;
import com.libstar.kb.spider.sp.cspd.entity.PerioNewEvaluationBean;
import com.libstar.kb.spider.sp.cspd.entity.PerioOldEvaluationBean;
import com.libstar.kb.spider.sp.cspd.entity.PerioUnitBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author itguang
 * @create 2018-06-29 10:33
 **/
@Service
@Transactional
public class PerioContentService {



    @Autowired
    PerioContentRepository perioContentRepository;

    @Autowired
    PerioAuthorsBeanRepository perioAuthorsBeanRepository;

    @Autowired
    PerioUnitBeanRepository perioUnitBeanRepository;

    @Autowired
    PerioNewEvaluationBeanRepository perioNewEvaluationBeanRepository;

    @Autowired
    PerioOldEvaluationBeanRepository perioOldEvaluationBeanRepository;


    /**
     * 持久化 PerioContentEntity及其关联表
     * @param list
     */
    public void saveAll(List<PerioContentEntity> list){

        perioContentRepository.saveAll(list);


        //保存 PerioContentEntity 的 关联表
        for (PerioContentEntity entity:list) {

            OpBean op = entity.getOp();

            List<PerioAuthorsBean> perioAuthorsBeans = op.getPerioAuthors();
            if (perioAuthorsBeans!=null) {
                perioAuthorsBeanRepository.saveAll(perioAuthorsBeans);
            }
            List<PerioNewEvaluationBean> perioNewEvaluationBeans = op.getPerioNewEvaluation();
            if (perioNewEvaluationBeans!=null){
                perioNewEvaluationBeanRepository.saveAll(perioNewEvaluationBeans);
            }
            List<PerioOldEvaluationBean> perioOldEvaluationBeans = op.getPerioOldEvaluation();
            if (perioOldEvaluationBeans!=null){
                    perioOldEvaluationBeanRepository.saveAll(perioOldEvaluationBeans);
            }
            List<PerioUnitBean> perioUnitBeans = op.getPerioUnit();
            if (perioUnitBeans!=null){
                perioUnitBeanRepository.saveAll(perioUnitBeans);
            }
        }




    }




}
