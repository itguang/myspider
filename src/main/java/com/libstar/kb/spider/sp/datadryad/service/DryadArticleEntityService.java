package com.libstar.kb.spider.sp.datadryad.service;

import com.libstar.kb.spider.sp.datadryad.dao.DryadArticleEntityRepository;
import com.libstar.kb.spider.sp.datadryad.entity.DryadArticleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author itguang
 * @create 2018-07-09 17:00
 **/
@Service
@Transactional
public class DryadArticleEntityService {


    @Autowired
    DryadArticleEntityRepository repository;


    /**
     * 更新flag
     * @param entity
     */
    public void updateFlag(DryadArticleEntity entity){
        repository.updateFlag(entity.getId(),entity.getFlag());
    }





    /**
     * 保存实体类,不存在就保存
     * @param list
     */
    public void save(List<DryadArticleEntity> list){

        ArrayList<DryadArticleEntity> entities = new ArrayList<>();
        for (DryadArticleEntity entity: list) {
            Optional<DryadArticleEntity> optional = repository.findById(entity.getId());
            if (!optional.isPresent()){
                entities.add(entity);
            }
        }
        repository.saveAll(entities);
    }

    /**
     *  分页查询相应标记位的article
     * @param pageNum
     * @param pageSize
     * @param flag
     * @return
     */
    public List<DryadArticleEntity> findPage(int pageNum,int pageSize,int flag){

        Pageable pageable = new PageRequest(pageNum, pageSize);

        Specification<DryadArticleEntity> specification = new Specification<DryadArticleEntity>() {

            @Override
            public Predicate toPredicate(Root<DryadArticleEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {

                Path<Integer> path = root.get("flag");
                Predicate predicate = cb.equal(path, flag);
                return predicate;
            }
        };

        Page<DryadArticleEntity> page = repository.findAll(specification, pageable);
        List<DryadArticleEntity> list = page.getContent();

        return list;
    }









}
