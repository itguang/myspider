package com.libstar.kb.spider.sp.doab.article;

import com.libstar.kb.spider.sp.doab.entity.BookEntity;
import com.libstar.kb.spider.sp.doab.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;

/**
 * @author 李增光
 * @create 2018-08-09 10:53
 **/
@Component
@Slf4j
public class DoabArticlePipeline implements Pipeline {

    @Autowired
    BookService bookService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        ArrayList<BookEntity> list = resultItems.get("list");
        bookService.saveAll(list);

        log.info("入库+:{}",list.size());


    }

}
