package com.libstar.kb.spider.sp.doab.article;

import com.libstar.kb.spider.sp.doab.DoabUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.RedisScheduler;

/**
 * @author 李增光
 * @create 2018-08-09 10:50
 **/
@Component
@Slf4j
public class DoabArticleTask {

    @Autowired
    DoabArticleProcessor processor;

    @Autowired
    DoabArticlePipeline pipeline;

    @Autowired
    RedisScheduler redisScheduler;

    String articleUrl = "https://www.doabooks.org/doab?func=browse&page=1&queryField=#&uiLanguage=en";



//    @Async
    public void task(){

        Spider spider = Spider.create(processor).addPipeline(pipeline).setScheduler(redisScheduler);
       // spider.addUrl("https://www.doabooks.org/doab?func=browse&page=1&queryField=A&uiLanguage=en");

        char[] chars = DoabUtil.initArray();
        for (int i = 0; i < chars.length; i++) {
            char word = chars[i];
            String url = articleUrl.replace("#", String.valueOf(word));
            spider.addUrl(url);
        }
        spider.thread(3).run();
        log.info("-->> end <<抓取 DOAB 的任务完毕>>");

    }
}
