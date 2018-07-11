package com.libstar.kb.spider.sp.datadryad.article;

import com.libstar.kb.spider.sp.datadryad.entity.DryadArticleEntity;
import com.libstar.kb.spider.sp.datadryad.service.DryadArticleEntityService;
import com.libstar.kb.spider.sp.datadryad.util.DryadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itguang
 * @create 2018-07-09 14:13
 **/
@Component
@Slf4j
public class ArticleProcessor implements PageProcessor {


    private Site site = Site.me().setRetryTimes(5).setSleepTime(1000);
    boolean flag = true;


    @Override
    public void process(Page page) {


        Html html = page.getHtml();

        //添加待爬取url
        if (flag) {
            Selectable xpath = html.xpath("//div[@class='pagination-masked clearfix top']//li[@class='last-page-link']//a//text()");
            String maxPage = xpath.toString();

            Integer toatlePage = Integer.valueOf(maxPage);
            log.info("一共{}页,正在添加...",toatlePage);

            //https://datadryad.org/discover?sort_by=dc.date.issued_dt_sort&order=DESC&rpp=100&page=1

            for (int i = 2; i <= toatlePage; i++) {
                String url = "https://datadryad.org/discover?sort_by=dc.date.issued_dt_sort&order=DESC&rpp=100&page=" + i;
                page.addTargetRequest(url);

            }
            flag = false;
            log.info("添加请求到待爬取队列完毕,正在爬取...");


        }

        List<Selectable> nodes = html.xpath("//ul[@class='ds-artifact-list']//li").nodes();

        ArrayList<DryadArticleEntity> list = new ArrayList<>();

        for (Selectable node : nodes) {
            String contentUrl = node.links().toString();
            log.info(contentUrl);
            String id = DryadUtil.getId(contentUrl);

            DryadArticleEntity entity = new DryadArticleEntity();
            entity.setId(id);
            entity.setUrl(contentUrl);
            list.add(entity);
        }
        page.putField("entity",list);
    }

    @Override
    public Site getSite() {

        //该机制会将下载失败的url重新放入队列尾部重试，直到达到重试次数，以保证不因为某些网络原因漏抓页面。
        return site.setCycleRetryTimes(3);
    }


}
