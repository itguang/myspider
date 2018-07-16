package com.libstar.kb.spider.sp.doaj.content;

import com.libstar.kb.spider.sp.doaj.util.DoajUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
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


        String articleUrl = DoajUtil.getArticleUrl("0");

        log.info("url={}",articleUrl);

        Spider spider = Spider.create(processor).addPipeline(pipeline);//.setScheduler(redisScheduler);

        spider.addUrl(articleUrl);

        spider.thread(1).run();
        log.info("-->> end <<抓取 DoajArticleEntity 的任务完毕>>");




    }


}
