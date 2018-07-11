package com.libstar.kb.spider.sp.doaj.content;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @author itguang
 * @create 2018-07-11 10:05
 **/
@Component
@Slf4j
public class DoajArticleContentProcessor implements PageProcessor {




    @Override
    public void process(Page page) {

    }

    @Override
    public Site getSite() {
        return null;
    }
}
