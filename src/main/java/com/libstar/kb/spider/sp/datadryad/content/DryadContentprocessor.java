package com.libstar.kb.spider.sp.datadryad.content;

import com.libstar.kb.spider.sp.datadryad.entity.DryadArticleEntity;
import com.libstar.kb.spider.sp.datadryad.service.DryadArticleEntityService;
import com.libstar.kb.spider.sp.datadryad.util.DryadUtil;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author itguang
 * @create 2018-07-09 19:11
 **/
@Component
@Slf4j
public class DryadContentprocessor implements PageProcessor {

    @Autowired
    DryadArticleEntityService dryadArticleEntityService;

    volatile boolean flag = true;

    volatile int pageNum = 0;


    @Override
    public void process(Page page) {

        while (flag) {
            List<DryadArticleEntity> list = dryadArticleEntityService.findPage(pageNum, 500, 0);

            if (list.size() == 0) {
                flag = false;

                log.info("DryadContent 请求队列添加完毕!开始爬取入库...");
            }
            log.info("正在添加待爬取请求{}条", list.size());

            for (DryadArticleEntity entity : list) {

                String url = entity.getUrl() + "?show=full";
                page.addTargetRequest(url);

                // 修改标记
                entity.setFlag(1);
                dryadArticleEntityService.updateFlag(entity);
            }
        }


        Html html = page.getHtml();
        Selectable table = html.xpath("//table[@class='ds-includeSet-table detailtable']");
        Map<String, String> map = DryadUtil.getMap(table.get());

        page.putField("map",map);

    }

    @Override
    public Site getSite() {
        Site site = Site.me().setRetryTimes(5).setSleepTime(1000).setRetryTimes(5);
        return site;
    }
}
