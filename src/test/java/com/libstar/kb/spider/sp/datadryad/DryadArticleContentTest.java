package com.libstar.kb.spider.sp.datadryad;

import com.libstar.kb.spider.sp.datadryad.content.DryadContentTask;
import com.libstar.kb.spider.sp.datadryad.entity.DryadArticleEntity;
import com.libstar.kb.spider.sp.datadryad.service.DryadArticleEntityService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author itguang
 * @create 2018-07-09 20:00
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DryadArticleContentTest {

    @Autowired
    DryadArticleEntityService dryadArticleEntityService;

    @Autowired
    DryadContentTask  dryadContentTask;

    @Test
    public void test(){

        dryadContentTask.task();

    }


}
