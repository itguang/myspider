package com.libstar.kb.spider.sp.cspd.yeartree;

import com.libstar.kb.spider.sp.cspd.dao.YearTreeEntityRepostitory;
import com.libstar.kb.spider.sp.cspd.service.ArticleEntityService;
import com.libstar.kb.spider.sp.cspd.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.RedisScheduler;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.List;

/**
 * 爬去期刊年限列表数据任务
 *
 * @author itguang
 * @create 2018-06-27 16:21
 **/
@Component
@Slf4j
public class YearTreeTask {


    public static final String baseUrl = "http://www.wanfangdata.com.cn/perio/yearTree.do";

    /**
     * 从表中分页查找,由于有flag进行标记过滤,起始页固定从0开始
     */
    private volatile int PAGENUM = 0;
    /**
     * 页大小
     */
    private static int PAGESIZE = 10;


    @Autowired
    YearTreeEntityRepostitory yearTreeEntityRepostitory;

    @Autowired
    ArticleEntityService articleEntityService;


    @Autowired
    YearTreeProcessor processor;

    @Autowired
    YearTreePipline pipline;

    @Autowired
    RedisScheduler redisScheduler;


    @Async
    public void task() {

        //第一步: 添加 processor 和 pipline
        Spider spider = Spider.create(processor).addPipeline(pipline).setScheduler(redisScheduler);

        //第二步: 添加初始请求 Request

        //从article表中分页查找查找所有perio_id,遍历之后拼接request中,并添加到待爬取任务队列中
        List<String> list = articleEntityService.findPageByFlag(PAGENUM, PAGESIZE,"0");
        for (String perioId : list) {

            //拼接url
            String requestUrl = UrlUtils.appendParam(baseUrl, "perio_id", perioId);
            Request request = new Request(requestUrl);
            request.setMethod(HttpConstant.Method.GET);

            //添加Request
            spider.addRequest(request);

            //把articleEntity表的标志位进行标记,下次不再查找
            articleEntityService.updateFlagByPerioId(perioId,"1");

        }

        //第三步: 开启爬虫
        spider.thread(3).run();

        log.info("-->> end <<爬去期刊号数据任务完成>>");

    }


}
