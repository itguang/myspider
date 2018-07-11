package com.libstar.kb.spider.sp.doaj.content;

import com.libstar.kb.spider.sp.doaj.service.DoajArticleContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

/**
 * @author itguang
 * @create 2018-07-11 10:06
 **/
@Component
@Slf4j
public class DoajArticleContentPipeline implements Pipeline {

    @Autowired
    DoajArticleContentService service;

    @Override
    public void process(ResultItems resultItems, Task task) {

    }
}
