package com.libstar.kb.spider.sp.datadryad.article;

import com.libstar.kb.spider.sp.datadryad.entity.DryadArticleEntity;
import com.libstar.kb.spider.sp.datadryad.service.DryadArticleEntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;

/**
 * @author itguang
 * @create 2018-07-09 14:14
 **/
@Component
@Slf4j
public class ArticlePipeline implements Pipeline {

    @Autowired
    DryadArticleEntityService dryadArticleEntityService;

    @Override
    public void process(ResultItems resultItems, Task task) {

        ArrayList<DryadArticleEntity> list = resultItems.get("entity");
        dryadArticleEntityService.save(list);
        log.info("新增DryadArticleEntity:{}条",list.size());


    }
}
