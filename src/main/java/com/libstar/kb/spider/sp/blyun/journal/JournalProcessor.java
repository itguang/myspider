package com.libstar.kb.spider.sp.blyun.journal;

import com.libstar.kb.spider.sp.blyun.service.JournalTempService;
import com.libstar.kb.spider.sp.blyun.util.BlyunUtil;
import com.libstar.kb.spider.sp.blyun.util.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * @author itguang
 * @create 2018-07-13 16:23
 **/
@Component
@Slf4j
public class JournalProcessor implements PageProcessor {

    @Autowired
    JournalTempService journalTempService;

    private static Integer size = 15;

    volatile boolean done = false;


    @Override
    public void process(Page page) {

        if (!done) {
            List<String> ids = journalTempService.journalTempList();
            for (String categoryId : ids) {
                Request request = BlyunUtil.getUrl(categoryId, "1");
                page.addTargetRequest(request);
                journalTempService.updateFlag("1", categoryId);
            }
            done = true;
        }


        //判断url的参数page是否为1
        String p = UrlUtils.getParams(page.getUrl().get()).get("page");

        if ("1".equals(p)) {

            String gjflids = UrlUtils.getParams(page.getUrl().get()).get("gjflids");
            Integer total = Integer.valueOf(page.getJson().jsonPath("$.hitcount").get());
            int num = total % size == 0 ? total / size : total / size + 1;
            for (int i = 2; i <= num; i++) {
                Request request = BlyunUtil.getUrl(gjflids, String.valueOf(i));
                page.addTargetRequest(request);
            }
        }

        List<String> list = page.getJson().jsonPath("$.results").all();
        page.putField("results", list.toString());

    }

    @Override
    public Site getSite() {

        Site site = Site.me().setRetryTimes(5).setSleepTime(1000).setRetryTimes(5).setTimeOut(60 * 1000);
        return site;
    }
}
