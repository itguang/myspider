package com.libstar.kb.spider.sp.cspd.perio;

import com.libstar.kb.spider.sp.cspd.service.YearTreeEntityService;
import com.libstar.kb.spider.sp.cspd.entity.YearTreeEntity;
import com.libstar.kb.spider.sp.cspd.service.ArticleEntityService;
import com.libstar.kb.spider.sp.cspd.utils.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.HttpConstant;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 通过perio_id,publish_year,issue_num获取该杂志相应年份月份的期刊
 * http://www.wanfangdata.com.cn/perio/articleList.do?page=1&page=10&issue_num=5&publish_year=2017&perio_id=ycyyzz
 *
 * @author itguang
 * @create 2018-06-28 16:13
 **/

@Component
@Slf4j
public class PerioContentProcessor implements PageProcessor {


    public static final String BASEURL = "http://www.wanfangdata.com.cn/perio/articleList.do";

    /**
     * 起始页从1开始,固定为1
     */
    private static final String PAGE = "1";
    /**
     * 页大小,每一期的目录不超过200个
     */
    private static final String PAGESIZE = "500";


    private static volatile boolean hasMore = true;

    private Site site = Site.me().setRetryTimes(5).setTimeOut(20000).setSleepTime(2000);


    @Autowired
    ArticleEntityService articleEntityService;

    @Autowired
    YearTreeEntityService yearTreeEntityService;



    @Override
    public Site getSite() {
        //该机制会将下载失败的url重新放入队列尾部重试，直到达到重试次数，以保证不因为某些网络原因漏抓页面。
        return site.setCycleRetryTimes(10);
    }


    @Override
    public void process(Page page) {


        String perioContent = page.getRawText();

        if (!StringUtils.isEmpty(perioContent)){
            page.putField("perioContent",perioContent);
        }


        //添加请求到待爬取队列(待优化,使用全局Boolean变量做标记,当持久化期刊内容请求队列添加完毕后不再进行数据库查找)

        if (hasMore){
            addRequest(page);
        }



    }

    /**
     * 添加请求到待爬取队列
     * @param page
     */
    public void addRequest(Page page) {
        //查找期刊内容未持久化的 perioId
        List<String> perioIdList = articleEntityService.findPageByFlag(0, 20, "1");

        if (perioIdList.size()==0){
            hasMore = false;
            log.info("<<持久化期刊内容请求队列添加完毕,正在爬取数据进行入库...>>");
            return;
        }

        for (String periodId : perioIdList) {

            List<YearTreeEntity> list = yearTreeEntityService.findAllByPerioId(periodId);

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
                    params.put("page", PAGE);
                    params.put("pageSize", PAGESIZE);
                    params.put("issue_num", issumNum);
                    params.put("publish_year", entity.getName());
                    params.put("perio_id", periodId);

                    String requestUrl = UrlUtils.appendParams(BASEURL, params);
                    Request request = new Request(requestUrl).setMethod(HttpConstant.Method.POST);
                    page.addTargetRequest(request);


                }

            }
            //修改articleEntity表的标志位为2,表示已经爬取过perioContent数据
            articleEntityService.updateFlagByPerioId(periodId,"2");
        }

    }
}
