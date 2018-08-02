package com.libstar.kb.spider.sp.blyun.journal;

import com.libstar.kb.spider.sp.blyun.entity.JournalTempEntity;
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
import java.util.zip.CheckedOutputStream;

/**
 * @author 李增光
 * @create 2018-07-13 16:23
 **/
@Component
@Slf4j
public class JournalProcessor implements PageProcessor {

    @Autowired
    JournalTempService journalTempService;
    private static Integer size = 15;

    volatile int count = 2;
    volatile int num;

    @Override
    public void process(Page page) {

        //判断url的参数pages是否为1
         String p = UrlUtils.getParams(page.getUrl().get()).get("pages");
        if ("1".equals(p)) {
            count = 2;
            String gjflids = UrlUtils.getParams(page.getUrl().get()).get("gjflids");
            Integer total = Integer.valueOf(page.getJson().jsonPath("$.hitcount").get());
            num = total % size == 0 ? total / size : total / size + 1;
            for (int i = 2; i <= num; i++) {
                Request request = BlyunUtil.getUrl(gjflids, String.valueOf(i));
                page.addTargetRequest(request);
            }
        }
        if (count <= num) {
            count++;
            List<String> list = page.getJson().jsonPath("$.results").all();
            page.putField("results", list.toString());
            return;
        }

        JournalTempEntity entity = journalTempService.findOneByFlag("0");
        if (entity == null) {

            return;
        }
        Request request = BlyunUtil.getUrl(entity.getCategoryId(), "1");
        page.addTargetRequest(request);
        journalTempService.updateFlag("1", entity.getCategoryId());
    }

    @Override
    public Site getSite() {

        Site site = Site.me().setRetryTimes(5).setSleepTime(1000).setRetryTimes(5).setTimeOut(60 * 1000);
        return site;
    }
}
