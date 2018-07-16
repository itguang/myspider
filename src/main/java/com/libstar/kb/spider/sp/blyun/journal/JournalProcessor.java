package com.libstar.kb.spider.sp.blyun.journal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

/**
 * @author itguang
 * @create 2018-07-13 16:23
 **/
@Component
@Slf4j
public class JournalProcessor implements PageProcessor {



    @Override
    public void process(Page page) {


        Json json = page.getJson();
        log.info("json={}",json);

    }

    @Override
    public Site getSite() {

        Site site = Site.me().setRetryTimes(5).setSleepTime(1000).setRetryTimes(5).setTimeOut(60*1000);
        return site;
    }
}
