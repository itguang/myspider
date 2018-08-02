package com.libstar.kb.spider.sp.blyun.dao;

import com.libstar.kb.spider.sp.blyun.entity.JournalTempEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author 李增光
 * @create 2018-07-31 17:29
 **/
public interface JournalTempRepository extends JpaRepository<JournalTempEntity, String> {

    @Modifying
    @Query("update JournalTempEntity  obj set obj.flag=:flag where obj.categoryId=:categoryId")
    void updateFlag(@Param("flag") String flag, @Param("categoryId") String categoryId);

    JournalTempEntity findDistinctFirstByFlag(String flag);


}
