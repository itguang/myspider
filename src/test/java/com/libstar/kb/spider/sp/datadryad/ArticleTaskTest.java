package com.libstar.kb.spider.sp.datadryad;

import com.libstar.kb.spider.sp.datadryad.article.ArticleTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author itguang
 * @create 2018-07-09 14:36
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleTaskTest {


    @Autowired
    ArticleTask articleTask;


    @Test
    public void test(){

        articleTask.task();

    }


}
