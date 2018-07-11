package com.libstar.kb.spider.sp.cspd;


import com.libstar.kb.spider.sp.cspd.article.CSPDJournalListTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author itguang
 * @create 2018-06-26 11:05
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CSPDJournalListProcessorTest {


    @Autowired
    CSPDJournalListTask cspdJournalListTask;


    @Test
    public void test() {

        cspdJournalListTask.task();

    }


    @Test
     public void test2(){

        cspdJournalListTask.task2();

    }

}
