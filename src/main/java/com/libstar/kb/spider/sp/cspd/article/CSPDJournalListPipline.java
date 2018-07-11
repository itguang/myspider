package com.libstar.kb.spider.sp.cspd.article;

import com.libstar.kb.spider.sp.cspd.entity.ArticleEntity;
import com.libstar.kb.spider.sp.cspd.service.ArticleEntityService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * 保存 http://www.wanfangdata.com.cn/perio/toIndex.do 期刊数据
 *
 * @author itguang
 * @create 2018-06-26 10:30
 **/
@Service
@Slf4j
public class CSPDJournalListPipline implements Pipeline {

    @Autowired
    ArticleEntityService articleEntityService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        String cspd = resultItems.get("cspd");

        if (cspd == null) {
            log.info("<<CSPDJournalList期刊名称持久化完毕>>");
            return;

        }

        JsonObject jsonObject = new JsonParser().parse(cspd).getAsJsonObject();

        JsonElement pageRowElement = jsonObject.get("pageRow");

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(String.class, new CSPDJournalListAdapter())
                .create();

        String articleJson = gson.toJson(pageRowElement);

        List<ArticleEntity> list = gson.fromJson(articleJson, new TypeToken<List<ArticleEntity>>() {
        }.getType());

        //持久化到musql数据库
        articleEntityService.saveAll(list);
    }
}
