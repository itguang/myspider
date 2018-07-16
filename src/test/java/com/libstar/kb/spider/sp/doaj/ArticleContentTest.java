package com.libstar.kb.spider.sp.doaj;

import com.libstar.kb.spider.sp.doaj.article.DoajArticleTask;
import com.libstar.kb.spider.sp.doaj.content.DoajArticleContentTask;
import com.libstar.kb.spider.sp.doaj.dao.DoajArticleContentRepository;
import com.libstar.kb.spider.sp.doaj.entity.DoajArticleContentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @author itguang
 * @create 2018-07-16 15:35
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleContentTest {


    @Autowired
    DoajArticleContentRepository repository;


    @Autowired
    DoajArticleContentTask task;


    @Test
    public void test() {

        task.task();

    }


    @Test
    public void test2() {

        DoajArticleContentEntity entity = new DoajArticleContentEntity();
        entity.setId("test");

         repository.save(entity);

        Optional<DoajArticleContentEntity> test = repository.findById("test1");

    }

}
