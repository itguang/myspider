package com.libstar.kb.spider.sp.cspd.service;

import com.libstar.kb.spider.sp.cspd.dao.ArticleEntityRepository;
import com.libstar.kb.spider.sp.cspd.entity.ArticleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author itguang
 * @create 2018-06-28 10:29
 **/
@Service
@Transactional
@Slf4j
public class ArticleEntityService {


    @Autowired
    ArticleEntityRepository articleEntityRepository;


    /**
     * 分页查询,返回标记位相应flag的 perioId 集合
     *
     * @param pageNum  页码
     * @param pageSize 页大小
     * @param flag     0:年限列表未持久化 <br/> 1:年限列表已持久化,期刊内容未持久化 <br/> 3:期刊内容已持久化
     * @return
     */
    public List<String> findPageByFlag(Integer pageNum, Integer pageSize, String flag) {

        Pageable pageable = new PageRequest(pageNum, pageSize);


        //构建查询条件: 相应flag标记位的记录

        Specification<ArticleEntity> specification = new Specification<ArticleEntity>() {
            @Override
            public Predicate toPredicate(Root<ArticleEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Path<Integer> path = root.get("flag");
                Predicate predicate = cb.equal(path, flag);
                return predicate;
            }
        };

        Page<ArticleEntity> page = articleEntityRepository.findAll(specification, pageable);
        List<ArticleEntity> list = page.getContent();
        List<String> perioIds = list.stream().map(ArticleEntity::getPerioId).collect(Collectors.toList());

        return perioIds;
    }

    /**
     * 通过perioId 更新标记位
     *
     * @param perioId
     */
    public void updateFlagByPerioId(String perioId, String flag) {

        articleEntityRepository.updateFlagByPerioId(perioId, flag);
    }

    /**
     * 查找表中flag标记位为0的所有的 perio_id
     *
     * @return
     */
    public List<String> findAllPerioId() {
        List<String> list = articleEntityRepository.findAllPerioId();
        return list;
    }


    /**
     * 批量保存 需要注意去重
     * @param list
     */
    public synchronized void saveAll(List<ArticleEntity> list) {

        ArrayList<ArticleEntity> entities = new ArrayList<>();
        for (ArticleEntity entity : list) {

            Optional<ArticleEntity> optional = articleEntityRepository.findById(entity.getId());
            if (!optional.isPresent()) {
                entities.add(entity);
            }

        }

        if (entities.size() > 0) {
            articleEntityRepository.saveAll(entities);
        }
        log.info("新增入库{}个",entities.size());

    }

}
