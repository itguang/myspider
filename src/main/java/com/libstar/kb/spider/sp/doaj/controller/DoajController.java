package com.libstar.kb.spider.sp.doaj.controller;

import com.libstar.kb.spider.sp.doaj.article.DoajArticleTask;
import com.libstar.kb.spider.sp.doaj.content.DoajArticleContentTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author itguang
 * @create 2018-07-17 11:24
 **/
@RestController
@Slf4j
public class DoajController {

    @Autowired
    DoajArticleContentTask task;

    @RequestMapping("/doaj")
    public String start() {
        task.task();
        log.info("开始爬取doaj期刊数据");
        return "开始爬取doaj期刊数据";
    }
}
