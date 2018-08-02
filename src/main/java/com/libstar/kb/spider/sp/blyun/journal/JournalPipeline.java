package com.libstar.kb.spider.sp.blyun.journal;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.libstar.kb.spider.sp.blyun.entity.BlyunArticleEntity;
import com.libstar.kb.spider.sp.blyun.service.BlyunArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;

/**
 * @author itguang
 * @create 2018-07-13 16:25
 **/
@Component
@Slf4j
public class JournalPipeline implements Pipeline {

    @Autowired
    BlyunArticleService blyunArticleService;

    int total = 0;


    @Override
    public void process(ResultItems resultItems, Task task) {

        String results = resultItems.get("results");

        if (StringUtils.isEmpty(results)) {
            return;

        }

        Gson gson = new Gson();
        List<BlyunArticleEntity> list = gson.fromJson(results, new TypeToken<List<BlyunArticleEntity>>() {
        }.getType());

        if (list != null && list.size() > 0) {
            int i = blyunArticleService.saveAll(list);
            total = total + i;
            log.info("入库 + {} 条,total = {}", i, total);

        }


    }


}
