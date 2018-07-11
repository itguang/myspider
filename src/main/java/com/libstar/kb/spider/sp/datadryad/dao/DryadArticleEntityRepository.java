package com.libstar.kb.spider.sp.datadryad.dao;

import com.libstar.kb.spider.sp.cspd.entity.ArticleEntity;
import com.libstar.kb.spider.sp.datadryad.entity.DryadArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DryadArticleEntityRepository extends JpaRepository<DryadArticleEntity, String> {


    /**
     * 构建条件分页查询
     *
     * @param specification
     * @param pageable
     * @return
     */
    Page<DryadArticleEntity> findAll(Specification<DryadArticleEntity> specification, Pageable pageable);

    @Modifying
    @Query("update DryadArticleEntity obj set obj.flag=:flag where obj.id =:id")
    void updateFlag(@Param("id") String id, @Param("flag") int flag);

}
