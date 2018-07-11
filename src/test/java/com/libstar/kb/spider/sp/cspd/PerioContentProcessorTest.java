package com.libstar.kb.spider.sp.cspd;

import com.libstar.kb.spider.sp.cspd.perio.PerioContentTask;
import com.libstar.kb.spider.sp.cspd.service.ArticleEntityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author itguang
 * @create 2018-06-28 16:38
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class PerioContentProcessorTest {

    @Autowired
    PerioContentTask perioContentTask;

    @Autowired
    ArticleEntityService articleEntityService;

    @Test
    public void test() {
        perioContentTask.task();

    }



    @Test
    public void test2(){
        List<String> perioIdList = articleEntityService.findPageByFlag(0, 100, "1");


    }



}
