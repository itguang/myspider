package com.libstar.kb.spider.sp.blyun.journal;

import com.libstar.kb.spider.sp.blyun.util.MD5Utils;
import com.libstar.kb.spider.sp.blyun.util.UrlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;
import us.codecraft.webmagic.scheduler.RedisScheduler;

import java.util.HashMap;

/**
 * @author itguang
 * @create 2018-07-13 16:24
 **/
@Component
@Slf4j
public class JournalTask {

    static String BASEURL = "http://fjour.blyun.com/magguide";

    static String key = "CA8768191C13390AC8CA476A87D97A6E";


    @Autowired
    JournalPipeline pipeline;

    @Autowired
    JournalProcessor processor;

    @Autowired
    RedisScheduler redisScheduler;


    //@Async
    public void task() {

        Request request = new Request();

        HashMap<String, String> map = new HashMap<>();

        //机构id
        map.put("unitid", "33736");

        //个人用户ID
        map.put("userid", "1");

        //个人用户类型  正式用户：1    临时用户：0
        map.put("usertype", "1");

        //字典顺序排序,MD5
        String cookie = "key=" + key + UrlUtils.sort(map);
        String msign = MD5Utils.md5(cookie);

        //设置cookie
        request.addCookie("msign", msign);
        log.info("msign={}", msign);

        //设置header
        request.addHeader("x-real-ip", "106.15.229.61");
        log.info("x-real-ip={}", "106.15.229.61");

        //毫秒级系统时间
        map.put("timestr", String.valueOf(System.currentTimeMillis()));

        //固定值
        map.put("go", "magsearch");
        map.put("json", "djson");

        //额外参数
        map.put("gjflids", "2");
        map.put("choren", "0");
        map.put("field", "1");

        //检索词
        String keyword = "哲学";
        map.put("sw", keyword);
        map.put("page", "1");

        //字典顺序排序
        String sort = UrlUtils.sort(map);
        log.info("sort={}", sort);
        //MD5 加密
        String md5 = MD5Utils.md5(sort + key);
        log.info("encStr={}", sort + key);

        //用户验证加密串
        map.put("enc", md5);

        String encode = UrlUtils.encode(keyword);
        map.put("sw", encode);

        //拼接url
        String requestUrl = UrlUtils.appendParams(BASEURL, map);
        log.info("requestUrl={}", requestUrl);

        Spider spider = Spider.create(processor).addPipeline(pipeline);//.setScheduler(redisScheduler);

        HttpClientDownloader downloader = new HttpClientDownloader();
        downloader.setProxyProvider(SimpleProxyProvider.from(new Proxy("106.15.229.61", 8011)));
        spider.setDownloader(downloader);
        request.setUrl(requestUrl);
        spider.addRequest(request);

        spider.thread(1).run();
        log.info("-->> end <<抓取 http://fjour.blyun.com/magguide 的任务完毕>>");

    }


}
