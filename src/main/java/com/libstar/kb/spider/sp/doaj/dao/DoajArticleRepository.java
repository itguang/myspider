package com.libstar.kb.spider.sp.doaj.dao;

import com.libstar.kb.spider.sp.doaj.entity.DoajArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author itguang
 * @create 2018-07-11 9:42
 **/
public interface DoajArticleRepository extends JpaRepository<DoajArticleEntity,String> {

    /**
     * 构建条件分页查询
     *
     * @param specification
     * @param pageable
     * @return
     */
    Page<DoajArticleEntity> findAll(Specification<DoajArticleEntity> specification, Pageable pageable);

    /**
     * 更新 flag
     * @param id
     * @param flag
     */
    @Modifying
    @Query("update DoajArticleEntity obj set obj.flag=:flag where obj.id =:id")
    void updateFlag(@Param("id") String id, @Param("flag") int flag);


}
