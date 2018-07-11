package com.libstar.kb.spider.sp.datadryad.content;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.RedisScheduler;

/**
 * 爬取  https://datadryad.org/resource/doi:10.5061/dryad.vv183?show=full
 *
 * @author itguang
 * @create 2018-07-09 19:13
 **/
@Component
@Slf4j
public class DryadContentTask {

    String baseUrl = "https://datadryad.org/resource/doi:10.5061/dryad.vv183?show=full";

    @Autowired
    RedisScheduler redisScheduler;

    @Autowired
    DryadContentPipeline pipeline;

    @Autowired
    DryadContentprocessor processor;

//   @Async
    public void task() {

       //第一步: 添加 processor 和 pipline, Scheduler
       Spider spider = Spider.create(processor).addPipeline(pipeline).setScheduler(redisScheduler);

       //第二步: 添加初始化url
       spider.addUrl("https://datadryad.org/resource/doi:10.5061/dryad.vt536?show=full");

       spider.thread(10).run();
       log.info("-->> end <<抓取 DryadContent 的任务完毕>>");

    }


}



