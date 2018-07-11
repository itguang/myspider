package com.libstar.kb.spider.sp.cspd.article;


import com.libstar.kb.spider.sp.cspd.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * 抓取 http://www.wanfangdata.com.cn/perio/toIndex.do 期刊数据
 *
 * @author itguang
 * @create 2018-06-26 10:29
 **/
@Component
@Slf4j
public class CSPDJournalListProcessor implements PageProcessor {

    /**
     * 起始页从2开始
     */
    private volatile int pageNum = 2;

    private static volatile boolean isAddRequest = false;

    private static String PAGESIZE = "100";


    private Site site = Site.me().setRetryTimes(5).setSleepTime(1000);

    public static String baseUrl = "http://www.wanfangdata.com.cn/perio/page.do";

    @Override
    public void process(Page page) {

        String json = page.getRawText();
        //记录当前页数
        String num = new JsonPathSelector("$.pageNum").select(json);
        log.info("===========第{}页===============", num);

        if (!("[]").equals(new JsonPathSelector("$.pageRow").select(json))) {

            //放进Pipline中
            page.putField("cspd", json);

            //添加所有的请求

            if (!isAddRequest) {

                //总页数
                String pageTotal = new JsonPathSelector("$.pageTotal").select(json);
                Integer total = Integer.valueOf(pageTotal);


                for (pageNum = 2; pageNum <= total; pageNum++) {

                    Map<String, String> params = new HashMap<>(3);
                    params.put("page", String.valueOf(pageNum));
                    params.put("pageSize", PAGESIZE);
                    params.put("selectOrder", "affectoi");

                    String requestUrl = UrlUtils.appendParams(baseUrl, params);
                    Request request = new Request(requestUrl);
                    request.setMethod(HttpConstant.Method.GET);
                    page.addTargetRequest(request);

                }
                //标记为已添加所有请求到请求队列中
                isAddRequest = true;
            }

        }

    }

    @Override
    public Site getSite() {
        //该机制会将下载失败的url重新放入队列尾部重试，直到达到重试次数，以保证不因为某些网络原因漏抓页面。
        return site.setCycleRetryTimes(3);
    }

}
