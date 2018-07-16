package com.libstar.kb.spider.sp.blyun;

import com.libstar.kb.spider.sp.blyun.journal.JournalTask;
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
    JournalTask task;


    @org.junit.Test
    public void test(){

        task.task();

    }


}
