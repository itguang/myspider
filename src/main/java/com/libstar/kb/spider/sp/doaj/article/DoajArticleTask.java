package com.libstar.kb.spider.sp.doaj.article;

import com.libstar.kb.spider.sp.doaj.util.DoajUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.RedisScheduler;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @author itguang
 * @create 2018-07-11 9:17
 **/
@Component
@Slf4j
public class DoajArticleTask {

    @Autowired
    DoajArticleProcessor processor;
    @Autowired
    DoajArticlePipeline pipeline;
    @Autowired
    RedisScheduler redisScheduler;

//    @Async
    public void task(){

        String articleUrl = DoajUtil.getArticleUrl("0");

        log.info("url={}",articleUrl);

        Spider spider = Spider.create(processor).addPipeline(pipeline);//.setScheduler(redisScheduler);

        spider.addUrl(articleUrl);

        spider.thread(1).run();
        log.info("-->> end <<抓取 DoajArticleEntity 的任务完毕>>");
    }
}
