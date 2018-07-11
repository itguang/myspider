package com.libstar.kb.spider.sp.doaj.service;

import com.libstar.kb.spider.sp.datadryad.entity.DryadArticleEntity;
import com.libstar.kb.spider.sp.doaj.dao.DoajArticleRepository;
import com.libstar.kb.spider.sp.doaj.entity.DoajArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author itguang
 * @create 2018-07-11 9:50
 **/
@Service
@Transactional
public class DoajArticleService {

    @Autowired
    DoajArticleRepository repository;


    /**
     * 更新flag
     * @param entity
     */
    public void updateFlag(DoajArticleEntity entity){
        repository.updateFlag(entity.getId(),entity.getFlag());
    }


    /**
     * 批量保存
     * @param list
     */
    public void saveAll(List<DoajArticleEntity> list){

        repository.saveAll(list);

    }

    /**
     *分页查找
     * @param pageNum
     * @param pageSize
     * @param flag
     * @return
     */
    public List<DoajArticleEntity> findPage(int pageNum,int pageSize,int flag){

        PageRequest pageRequest = new PageRequest(pageNum, pageSize);

        Specification<DoajArticleEntity> specification = new Specification<DoajArticleEntity>() {

            @Override
            public Predicate toPredicate(Root<DoajArticleEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

                Path<Integer> path = root.get("flag");
                Predicate predicate = cb.equal(path, flag);
                return predicate;
            }
        };

        Page<DoajArticleEntity> page = repository.findAll(specification, pageRequest);

        List<DoajArticleEntity> list = page.getContent();

        return list;
    }



}
