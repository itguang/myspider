package com.libstar.kb.spider.sp.cspd.dao;

import com.libstar.kb.spider.sp.cspd.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 保存 ArticleEntity的Repository
 *
 * @author itguang
 * @create 2018-06-27 10:28
 **/
public interface ArticleEntityRepository extends JpaRepository<ArticleEntity, String> {


    /**
     * 构建条件分页查询
     *
     * @param specification
     * @param pageable
     * @return
     */
    Page<ArticleEntity> findAll(Specification<ArticleEntity> specification, Pageable pageable);


    /**
     * 查找article表中flag为0的所有 perioId 字段
     *
     * @return
     */
    @Query("select obj.perioId from ArticleEntity obj where obj.flag='0'")
    List<String> findAllPerioId();


    /**
     * 通过perioId 更新标记位
     *
     * @param perioId
     */
    @Modifying
    @Query("update ArticleEntity  obj set obj.flag=:flag where obj.perioId=:perioId")
    void updateFlagByPerioId(@Param("perioId") String perioId, @Param("flag") String flag);





}
