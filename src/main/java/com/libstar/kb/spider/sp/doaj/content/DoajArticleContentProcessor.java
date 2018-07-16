package com.libstar.kb.spider.sp.doaj.content;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.libstar.kb.spider.sp.doaj.entity.RepositoryEntity;
import com.libstar.kb.spider.sp.doaj.util.DoajUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

import java.util.List;

/**
 * @author itguang
 * @create 2018-07-11 10:05
 **/
@Component
@Slf4j
public class DoajArticleContentProcessor implements PageProcessor {

    public static int pageSize = 10;

    public volatile boolean flag = false;

    @Override
    public void process(Page page) {

        Json json = page.getJson();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(page.getRawText()).getAsJsonObject();
        JsonObject hits1 = jsonObject.get("hits").getAsJsonObject();

        if(flag){

            //总数
            int total = hits1.get("total").getAsInt();
            int num = total % pageSize==0?total/pageSize:total/pageSize+1;
            for (int i = 0; i < num; i++) {
                String size = String.valueOf(i * pageSize);
                String articleUrl = DoajUtil.getArticleUrl(size);
                page.addTargetRequest(articleUrl);
            }
            flag = false;
        }

        JsonArray hits = hits1.get("hits").getAsJsonArray();
        Gson gson = new Gson();
        List<RepositoryEntity> list = gson.fromJson(hits, new TypeToken<List<RepositoryEntity>>() {
        }.getType());

        page.putField("list",list);

    }

    @Override
    public Site getSite() {

        Site site = Site.me().setRetryTimes(5).setSleepTime(1000).setRetryTimes(5).setTimeOut(60*1000);
        return site;
    }
}
