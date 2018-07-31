package com.libstar.kb.spider.sp.blyun;

import com.libstar.kb.spider.sp.blyun.journal.JournalTask;
import com.libstar.kb.spider.sp.blyun.service.JournalTempService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author itguang
 * @create 2018-07-13 15:44
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    JournalTempService journalTempService;


    @Autowired
    JournalTask task;


    @org.junit.Test
    public void test(){

        task.task();

    }

    @org.junit.Test
    public void journalTempList(){
        journalTempService.updateFlag("1","1");


    }




}
