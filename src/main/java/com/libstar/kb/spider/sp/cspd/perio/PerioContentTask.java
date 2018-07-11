package com.libstar.kb.spider.sp.cspd.perio;

import com.libstar.kb.spider.sp.cspd.entity.YearTreeEntity;
import com.libstar.kb.spider.sp.cspd.service.ArticleEntityService;
import com.libstar.kb.spider.sp.cspd.service.YearTreeEntityService;
import com.libstar.kb.spider.sp.cspd.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;
import us.codecraft.webmagic.scheduler.RedisScheduler;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 开启抓取 http://www.wanfangdata.com.cn/perio/articleList.do?page=1&pageSize=100&issue_num=1&publish_year=2018&perio_id=cwycnyy 的任务
 *
 * @author itguang
 * @create 2018-06-28 16:36
 **/

@Component
@Slf4j
public class PerioContentTask {


    public static final String BASEURL = "http://www.wanfangdata.com.cn/perio/articleList.do";

    /**
     * url拼接使用,起始页从1开始,数据在100条以内,固定为1即可
     */
    private static final String PAGE = "1";
    /**
     * 页大小,数据在100条以内,固定为100即可
     */
    private static final String PAGESIZE = "500";


    @Autowired
    PerioContentProcessor processor;

    @Autowired
    PerioContentPipline pipline;

    @Autowired
    ArticleEntityService articleEntityService;

    @Autowired
    YearTreeEntityService yearTreeEntityService;

    @Autowired
    RedisScheduler redisScheduler;


    @Async
    public void task() {
        //第一步: 添加 processor 和 pipline, Scheduler
        Spider spider = Spider.create(processor).addPipeline(pipline).setScheduler(redisScheduler);
        spider.addUrl("http://www.wanfangdata.com.cn/perio/articleList.do?page=1&pageSize=100&issue_num=1&publish_year=2018&perio_id=cwycnyy");

        //添加代理
       /* HttpClientDownloader downloader = new HttpClientDownloader();
        downloader.setProxyProvider(SimpleProxyProvider.from(new Proxy("127.0.0.1", 8888)));
        spider.setDownloader(downloader);*/


        //第二步: 添加请求 Request 到待爬取队列
        addRequest(spider);

        //第三步: 开启爬虫

        spider.thread(4).run();
        log.info("-->> end <<抓取 期刊内容 的任务完毕>>");

    }

    /**
     * 给Spider添加请求
     *
     * @param spider
     */
    public void addRequest(Spider spider) {
        //查找期刊内容未持久化的 perioId
        List<String> perioIdList = articleEntityService.findPageByFlag(0, 20, "1");

        if (perioIdList.size() == 0) {
            log.info("<<----没有待爬取的期刊内容数据--->>");
            return;
        }

        for (String periodId : perioIdList) {


            List<YearTreeEntity> list = yearTreeEntityService.findAllByPerioId(periodId);

            if (list.size() == 0) {
                continue;
            }

            List<YearTreeEntity> publishYearList = list.stream()
                    .filter(entity -> entity.getField().equals("common_year"))
                    .collect(Collectors.toList());

            for (YearTreeEntity entity : publishYearList) {
                String pid = entity.getId();

                //通过pid过滤出该pid的对应的issue_num
                List<String> issumNumList = list.stream()
                        .filter(yearTreeEntity -> yearTreeEntity.getPid().equals(pid))
                        .map(YearTreeEntity::getName)
                        .collect(Collectors.toList());

                //遍历该年份对应的isum_num
                for (String issumNum : issumNumList) {

                    HashMap<String, String> params = new HashMap<>(5);
                    //page=1&pageSize=100&issue_num=1&publish_year=2018&perio_id=cwycnyy
                    params.put("page", PAGE);
                    params.put("pageSize", PAGESIZE);
                    params.put("issue_num", issumNum);
                    params.put("publish_year", entity.getName());
                    params.put("perio_id", periodId);
                    String requestUrl = UrlUtils.appendParams(BASEURL, params);
                    Request request = new Request(requestUrl).setMethod(HttpConstant.Method.POST);

                    spider.addRequest(request);


                }
            }
            //修改articleEntity表的标志位为2,表示已经爬取过perioContent数据
            articleEntityService.updateFlagByPerioId(periodId, "2");
        }

    }


}
