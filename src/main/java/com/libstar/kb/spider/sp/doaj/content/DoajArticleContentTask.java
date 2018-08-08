package com.libstar.kb.spider.sp.doaj.content;

import com.libstar.kb.spider.sp.doaj.util.DoajUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import sun.text.resources.en.FormatData_en_IE;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.RedisScheduler;

/**
 * @author itguang
 * @create 2018-07-11 10:05
 **/
@Component
@Slf4j
public class DoajArticleContentTask {



    @Autowired
    DoajArticleContentProcessor processor;
    @Autowired
    DoajArticleContentPipeline pipeline;
    @Autowired
    RedisScheduler redisScheduler;


    @Async
    public void task(){

        Spider spider = Spider.create(processor).addPipeline(pipeline).setScheduler(redisScheduler);

//        int total = 3248762;
//        int start = 2499150;
//
//        for (int i = start; i < total;i+=20) {
//            log.info("i={}",i);
//
//            String articleUrl = DoajUtil.getArticleUrl(String.valueOf(i));
//            log.info("url={}",articleUrl);
//            spider.addUrl(articleUrl);
//        }

        String articleUrl = DoajUtil.getArticleUrl("2499050");

        log.info("初始url={}",articleUrl);

        spider.addUrl(articleUrl);

        spider.thread(3).run();
        log.info("-->> end <<抓取 DoajArticleContentEntity 的任务完毕>>");


    }


}
