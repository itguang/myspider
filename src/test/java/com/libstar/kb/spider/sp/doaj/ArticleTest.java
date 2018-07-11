package com.libstar.kb.spider.sp.doaj;

import com.libstar.kb.spider.sp.doaj.article.DoajArticleTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author itguang
 * @create 2018-07-11 9:32
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTest {


    @Autowired
    DoajArticleTask task;


    @Test
    public void test(){

        task.task();

    }



}
