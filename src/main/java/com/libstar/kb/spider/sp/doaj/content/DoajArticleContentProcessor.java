package com.libstar.kb.spider.sp.doaj.content;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.libstar.kb.spider.sp.cspd.utils.UrlUtils;
import com.libstar.kb.spider.sp.doaj.entity.RepositoryEntity;
import com.libstar.kb.spider.sp.doaj.util.DoajUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * @author itguang
 * @create 2018-07-11 10:05
 **/
@Component
@Slf4j
public class DoajArticleContentProcessor implements PageProcessor {

    public static int pageSize = 10;

    public  Boolean flag = true;

    @Override
    public void process(Page page) {

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(page.getRawText()).getAsJsonObject();
        JsonObject hits1 = jsonObject.get("hits").getAsJsonObject();

        if(flag) {

                //总数
                int total = hits1.get("total").getAsInt();
                int num = total % pageSize==0?total/pageSize:total/pageSize+1;
                log.info("正在添加 {} 条请求...",num);
                for (int i = 1; i < num; i++) {
                    String size = String.valueOf(i * pageSize);
                    String articleUrl = DoajUtil.getArticleUrl(size);
                    page.addTargetRequest(articleUrl);
                }
                flag = false;
                log.info("添加 {} 条请求完毕!",num);

        }

        JsonArray hits = hits1.get("hits").getAsJsonArray();
        Gson gson = new Gson();
        List<RepositoryEntity> list = gson.fromJson(hits, new TypeToken<List<RepositoryEntity>>() {
        }.getType());

        String url = page.getUrl().get();
        int from = DoajUtil.getFrom(url);

        page.putField("from",from);
        page.putField("list",list);

    }

    @Override
    public Site getSite() {

        Site site = Site.me().setRetryTimes(5).setSleepTime(1000).setRetryTimes(5).setTimeOut(60*1000);
        return site;
    }
}
