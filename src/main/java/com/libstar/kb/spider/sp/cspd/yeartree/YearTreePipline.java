package com.libstar.kb.spider.sp.cspd.yeartree;

import com.libstar.kb.spider.sp.cspd.dao.YearTreeEntityRepostitory;
import com.libstar.kb.spider.sp.cspd.entity.YearTreeEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * 保存期刊年限列表数据
 *
 * @author itguang
 * @create 2018-06-27 16:16
 **/
@Service
@Slf4j
public class YearTreePipline implements Pipeline {

   @Autowired
   YearTreeEntityRepostitory yearTreeEntityRepostitory;


    /**
     * 持久化
     * @param resultItems
     * @param task
     */
    @Override
    public void process(ResultItems resultItems, Task task) {

        List<YearTreeEntity> list = resultItems.get("yeartree");
        if (list.size()>0){

            //持久化
            yearTreeEntityRepostitory.saveAll(list);

            log.info(" 持久化 期刊号 PerioId={}--{}个",list.get(0).getPerioId(),list.size());

        }

    }
}
