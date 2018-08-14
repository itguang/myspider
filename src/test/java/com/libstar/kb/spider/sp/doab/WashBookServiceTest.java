package com.libstar.kb.spider.sp.doab;

import com.libstar.kb.spider.sp.doab.qingxi.WashBookService;
import com.libstar.kb.spider.sp.doab.qingxi.dao.KbComponentRepository;
import com.libstar.kb.spider.sp.doab.qingxi.entity.Book;
import com.libstar.kb.spider.sp.doab.qingxi.entity.KbComponent;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 李增光
 * @create 2018-08-14 10:34
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class WashBookServiceTest {


    @Autowired
    WashBookService washBookService;

    @Autowired
    KbComponentRepository kbComponentRepository;

    @Test
    public void test(){
        washBookService.wash();
    }


    @Test
    public void test2(){
        KbComponent kbComponent = kbComponentRepository.saveAndFlush(new KbComponent());
        long kbcId = kbComponent.getKbcId();
        System.out.println(kbcId);
    }


}
