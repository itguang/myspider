package com.libstar.kb.spider.sp.cspd.perio;

import com.libstar.kb.spider.sp.cspd.entity.PerioContentEntity;
import com.libstar.kb.spider.sp.cspd.service.PerioContentService;
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
 * 持久化期刊内容
 *
 * @author itguang
 * @create 2018-06-28 16:32
 **/

@Service
@Slf4j
public class PerioContentPipline implements Pipeline {


    @Autowired
    PerioContentService perioContentService;


    @Override
    public void process(ResultItems resultItems, Task task) {

        String perioContent = resultItems.get("perioContent");

        JsonObject jsonObject = new JsonParser().parse(perioContent).getAsJsonObject();

        JsonElement jsonElement = jsonObject.get("pageRow");

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(String.class, new PerioContentAdapter())
                .create();

        List<PerioContentEntity> list = gson.fromJson(jsonElement, new TypeToken<List<PerioContentEntity>>() {
        }.getType());

        //保存 PerioContentEntity 及其关联表 PerioAuthorsBean PerioNewEvaluationBean PerioOldEvaluationBean PerioUnitBean
        perioContentService.saveAll(list);

        log.info("PerioContentEntity 入库:{}条",list.size());

        }



}
