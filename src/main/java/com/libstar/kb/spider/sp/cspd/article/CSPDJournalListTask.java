package com.libstar.kb.spider.sp.cspd.article;

import com.libstar.kb.spider.sp.cspd.dao.ArticleEntityRepository;
import com.libstar.kb.spider.sp.cspd.entity.ArticleEntity;
import com.libstar.kb.spider.sp.cspd.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.RedisScheduler;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开启抓取 http://www.wanfangdata.com.cn/perio/toIndex.do 期刊数据任务
 *
 * @author itguang
 * @create 2018-06-26 10:32
 **/
@Component
@Slf4j
public class CSPDJournalListTask {

    public static final String baseUrl = "http://www.wanfangdata.com.cn/perio/page.do";

    @Autowired
    CSPDJournalListPipline pipline;

    @Autowired
    RedisScheduler redisScheduler;

    @Autowired

    ArticleEntityRepository articleEntityRepository;


    @Async
    public void task2(){
        System.out.println("++++++++++++++++++");
        List<ArticleEntity> list = articleEntityRepository.findAll();
        System.out.println(list.toString());


    }

    @Async
    public void task() {


        Spider spider = Spider.create(new CSPDJournalListProcessor()).addPipeline(pipline).setScheduler(redisScheduler);


        Map<String, String> params = new HashMap<>(3);
        params.put("page", "1");
        params.put("pageSize", "100");
        params.put("selectOrder", "affectoi");

        String requestUrl = UrlUtils.appendParams(baseUrl, params);
        Request request = new Request(requestUrl);
        request.setMethod(HttpConstant.Method.GET);
        spider.addRequest(request);

        spider.thread(3).run();

        log.info("-->> end <<抓取期刊名称数据任务完毕>>");

    }


}
