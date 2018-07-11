package com.libstar.kb.spider.sp.datadryad.article;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.RedisScheduler;

/**
 * 爬取  https://datadryad.org/discover?rpp=10&page=1&sort_by=dc.date.issued_dt_sort&order=DESC
 *
 * @author itguang
 * @create 2018-07-09 14:08
 **/

@Component
@Slf4j
public class ArticleTask {

    String baseUrl = "https://datadryad.org/discover?rpp=100&page=1&sort_by=dc.date.issued_dt_sort&order=DESC";


    @Autowired
    ArticleProcessor processor;

    @Autowired
    ArticlePipeline pipeline;

    @Autowired
    RedisScheduler redisScheduler;


    @Async
    public void task() {

        //第一步: 添加 processor 和 pipline, Scheduler
        Spider spider = Spider.create(processor).addPipeline(pipeline).setScheduler(redisScheduler);

        //第二步: 添加初始化url
        spider.addUrl(baseUrl);

        spider.thread(3).run();
        log.info("-->> end <<抓取 datadryad.org 的任务完毕>>");


    }


}
