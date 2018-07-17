package com.libstar.kb.spider.sp.doaj.content;

import com.libstar.kb.spider.sp.doaj.entity.AuthorBean;
import com.libstar.kb.spider.sp.doaj.entity.DoajArticleContentEntity;
import com.libstar.kb.spider.sp.doaj.entity.IdentifierBean;
import com.libstar.kb.spider.sp.doaj.entity.LicenseBean;
import com.libstar.kb.spider.sp.doaj.entity.LinkBean;
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
import java.util.stream.Collectors;

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
        int from = resultItems.get("from");
        ArrayList<DoajArticleContentEntity> doajArticleContentEntities = new ArrayList<>();

        for (RepositoryEntity entity : list) {

            DoajArticleContentEntity articleContentEntity = new DoajArticleContentEntity();

            articleContentEntity.setId(entity.getId());
            articleContentEntity.setArticleAbstract(entity.getSource().getBibjson().getAbstractX());
            articleContentEntity.setArticleTitle(entity.getSource().getBibjson().getTitle());

            List<AuthorBean> author = entity.getSource().getBibjson().getAuthor();
            if (author != null && author.size() > 0) {
                articleContentEntity.setAuthors(author.toString());
            }


            try {
                articleContentEntity.setCountryOfPublisher(entity.getSource().getBibjson().getJournal().getCountry());
            } catch (NullPointerException e) {
                log.info("no Country!");
            } finally {
                articleContentEntity.setCountryOfPublisher("NO");
            }

            articleContentEntity.setIssn(entity.getSource().getIndex().getIssn().toString());
            articleContentEntity.setLanguageOfFulltext(entity.getSource().getIndex().getLanguage().toString());

            List<String> classificationPaths = entity.getSource().getIndex().getClassificationPaths();
            if (classificationPaths != null && classificationPaths.size() > 0) {
                articleContentEntity.setLccSubjectCategory(classificationPaths.toString());
            }


            articleContentEntity.setJournalTitle(entity.getSource().getBibjson().getJournal().getTitle());
            articleContentEntity.setStartPage(entity.getSource().getBibjson().getStartPage());
            articleContentEntity.setEndPage(entity.getSource().getBibjson().getEndPage());
            articleContentEntity.setCreatedDate(entity.getSource().getCreatedDate());
            articleContentEntity.setLastUpdated(entity.getSource().getLastUpdated());
            articleContentEntity.setPublisher(entity.getSource().getBibjson().getJournal().getPublisher());

            List<LinkBean> links = entity.getSource().getBibjson().getLink();
            if (links != null && links.size() > 0) {
                for (LinkBean bean : links) {
                    if ("fulltext".equals(bean.getType())) {
                        articleContentEntity.setArticleFulltext(bean.getUrl());
                    }
                }

            }


            List<IdentifierBean> identifier = entity.getSource().getBibjson().getIdentifier();
            if (identifier.size() > 0) {
                for (IdentifierBean bean : identifier) {
                    if ("doi".equals(bean.getType())) {
                        articleContentEntity.setDoi(bean.getId());
                        break;
                    }
                }

            }


            doajArticleContentEntities.add(articleContentEntity);
        }

        doajArticleContentService.saveAll(doajArticleContentEntities);
        log.info("from = {} , DoajArticleContentEntity 入库: {} 条", from, doajArticleContentEntities.size());
//        List<String> ids = doajArticleContentEntities.stream().map(DoajArticleContentEntity::getId).collect(Collectors.toList());
//        log.info("ids={}",ids.toString());

    }
}
