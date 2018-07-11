package com.libstar.kb.spider.sp.cspd.yeartree;

import com.libstar.kb.spider.sp.cspd.entity.YearTreeEntity;
import com.libstar.kb.spider.sp.cspd.service.ArticleEntityService;
import com.libstar.kb.spider.sp.cspd.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.List;
import java.util.Map;

/**
 * 期刊年限列表爬取 http://www.wanfangdata.com.cn/perio/yearTree.do?perio_id=ycyyzz
 *
 * @author itguang
 * @create 2018-06-27 16:14
 **/
@Component
@Slf4j
public class YearTreeProcessor implements PageProcessor {

    public static final String baseUrl = "http://www.wanfangdata.com.cn/perio/yearTree.do";


    @Autowired
    ArticleEntityService articleEntityService;

    private Site site = Site.me().setRetryTimes(5).setSleepTime(1000);

    /**
     * 分页查询使用,从0开始,由于有flag标记过滤,固定即可
     */
    private static int PAGENUM = 0;
    /**
     * 由于有flag标记过滤,固定即可
     */
    private static int PAGESIZE = 10;


    /**
     * 记录标志
     */
    private static volatile boolean hasMore = true;


    @Override
    public void process(Page page) {

        if (hasMore) {
            //从article表中分页查找当flag为0时的perio_id,遍历之后拼接request中,并添加到待爬取任务队列中
            List<String> list = articleEntityService.findPageByFlag(PAGENUM, PAGESIZE, "0");

            if (list.size() > 0) {
                for (String perioId : list) {

                    //拼接url
                    String requestUrl = UrlUtils.appendParam(baseUrl, "perio_id", perioId);
                    Request request = new Request(requestUrl);
                    request.setMethod(HttpConstant.Method.GET);
                    //添加Request
                    page.addTargetRequest(request);

                    //把articleEntity表的标志位进行标记,下次不再查找
                    articleEntityService.updateFlagByPerioId(perioId, "1");
                }
            } else {
                hasMore = false;
                log.info("<<请求队列添加完成>>");
            }

        }



        Request request = page.getRequest();
        String url = request.getUrl();

        Map<String, String> map = UrlUtils.getParams(url);
        String perioId = map.get("perio_id");

        Json json = page.getJson();
        if (json != null) {
            //转为java对象设置perioId
            List<YearTreeEntity> entityList = json.toList(YearTreeEntity.class);

            for (YearTreeEntity entity : entityList) {
                entity.setPerioId(perioId);
            }
            page.putField("yeartree", entityList);
        }

    }

    @Override
    public Site getSite() {
        //该机制会将下载失败的url重新放入队列尾部重试，直到达到重试次数，以保证不因为某些网络原因漏抓页面。
        return site.setCycleRetryTimes(3);
    }
}
