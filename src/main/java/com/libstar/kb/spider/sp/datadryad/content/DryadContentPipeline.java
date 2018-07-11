package com.libstar.kb.spider.sp.datadryad.content;

import com.libstar.kb.spider.sp.cspd.service.ArticleEntityService;
import com.libstar.kb.spider.sp.datadryad.entity.DryadArticleContentEntity;
import com.libstar.kb.spider.sp.datadryad.entity.DryadArticleEntity;
import com.libstar.kb.spider.sp.datadryad.service.DryadArticleEntityService;
import com.libstar.kb.spider.sp.datadryad.service.GryadArticleContentService;
import com.libstar.kb.spider.sp.datadryad.util.DryadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
import java.util.Map;

/**
 * @author itguang
 * @create 2018-07-09 19:12
 **/
@Component
@Slf4j
public class DryadContentPipeline implements Pipeline {


    @Autowired
    GryadArticleContentService gryadArticleContentService;

    @Override
    public void process(ResultItems resultItems, Task task) {

        Map<String,String> map = resultItems.get("map");

        DryadArticleContentEntity entity = new DryadArticleContentEntity();
        entity.setId(DryadUtil.getId(map.get("dc.identifier")));
        log.info("保存id= {}",DryadUtil.getId(map.get("dc.identifier")));
        entity.setContributorAuthor(map.get("dc.contributor.author"));
        entity.setCoverageSpatial(map.get("dc.coverage.spatial"));
        entity.setDateAccessioned(map.get("dc.date.accessioned"));
        entity.setDateAvailable(map.get("dc.date.available"));
        entity.setDateIssued(map.get("dc.date.issued"));
        entity.setIdentifier(map.get("dc.identifier"));
        entity.setIdentifierUri(map.get("dc.identifier.uri"));
        entity.setDescription(map.get("dc.description"));
        entity.setRelationHaspart(map.get("dc.relation.haspart"));
        entity.setRelationIsreferencedby(map.get("dc.relation.isreferencedby"));
        entity.setSubject(map.get("dc.subject"));
        entity.setTitle(map.get("dc.title"));
        entity.setType(map.get("dc.type"));
        entity.setScientificName(map.get("dwc.ScientificName"));
        entity.setPublicationName(map.get("prism.publicationName"));
        entity.setDansTransferDate(map.get("dryad.dansTransferDate"));
        entity.setDansEditIri(map.get("dryad.dansEditIRI"));
        entity.setDansArchiveDate(map.get("dryad.dansArchiveDate"));

        gryadArticleContentService.save(entity);


    }
}
