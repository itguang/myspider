package com.libstar.kb.spider.sp.doaj.article;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author itguang
 * @create 2018-07-11 9:13
 **/

@Component
@Slf4j
public class DoajArticleProcessor implements PageProcessor {

    @Override
    public void process(Page page) {

    }

    @Override
    public Site getSite() {

        Site site = Site.me().setRetryTimes(5).setSleepTime(1000).setRetryTimes(5).setTimeOut(60*1000);
        return site;
    }
}
