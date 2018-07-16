package com.libstar.kb.spider.sp.doaj.content;

import com.libstar.kb.spider.sp.doaj.entity.DoajArticleContentEntity;
import com.libstar.kb.spider.sp.doaj.entity.IdentifierBean;
import com.libstar.kb.spider.sp.doaj.entity.RepositoryEntity;
import com.libstar.kb.spider.sp.doaj.service.DoajArticleContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * @author itguang
 * @create 2018-07-11 10:06
 **/
@Component
@Slf4j
public class DoajArticleContentPipeline implements Pipeline {

    @Autowired
    DoajArticleContentService doajArticleContentService;

    @Override
    public void process(ResultItems resultItems, Task task) {

        List<RepositoryEntity> list = resultItems.get("list");
        ArrayList<DoajArticleContentEntity> doajArticleContentEntities = new ArrayList<>();

        for (RepositoryEntity entity : list) {

            DoajArticleContentEntity articleContentEntity = new DoajArticleContentEntity();

            articleContentEntity.setId(entity.getId());
            articleContentEntity.setArticleAbstract(entity.getSource().getBibjson().getAbstractX());
            articleContentEntity.setArticleTitle(entity.getSource().getBibjson().getTitle());
            articleContentEntity.setAuthors(entity.getSource().getBibjson().getAuthor().toString());
            articleContentEntity.setCountryOfPublisher(entity.getSource().getBibjson().getJournal().getCountry());
            articleContentEntity.setIssn(entity.getSource().getIndex().getIssn().toString());
            articleContentEntity.setLanguageOfFulltext(entity.getSource().getIndex().getLanguage().toString());
            articleContentEntity.setLccSubjectCategory(entity.getSource().getIndex().getClassificationPaths().toString());

            articleContentEntity.setJournalTitle(entity.getSource().getBibjson().getJournal().getTitle());
            articleContentEntity.setStartPage(entity.getSource().getBibjson().getStartPage());
            articleContentEntity.setEndPage(entity.getSource().getBibjson().getEndPage());
            articleContentEntity.setCreatedDate(entity.getSource().getCreatedDate());
            articleContentEntity.setLastUpdated(entity.getSource().getLastUpdated());
            articleContentEntity.setArticleFulltext(entity.getSource().getBibjson().getLink().get(0).getUrl());
            articleContentEntity.setPublisher(entity.getSource().getBibjson().getJournal().getPublisher());

            List<IdentifierBean> identifier = entity.getSource().getBibjson().getIdentifier();
            for (IdentifierBean bean : identifier) {
                if ("doi".equals(bean.getType())) {
                    articleContentEntity.setDoi(bean.getId());
                    break;
                }
            }


            doajArticleContentEntities.add(articleContentEntity);
        }

        doajArticleContentService.saveAll(doajArticleContentEntities);
        log.info("DoajArticleContentEntity 入库: {} 条", doajArticleContentEntities.size());
    }
}
