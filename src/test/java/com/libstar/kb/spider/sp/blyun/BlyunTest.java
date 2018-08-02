package com.libstar.kb.spider.sp.blyun;

import com.libstar.kb.spider.sp.blyun.entity.JournalTempEntity;
import com.libstar.kb.spider.sp.blyun.journal.JournalTask;
import com.libstar.kb.spider.sp.blyun.service.JournalTempService;
import com.libstar.kb.spider.sp.cspd.yeartree.YearTreeTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 遍历所有的 perio_id 查出所有的期刊发表年限数据 进行入库
 *
 * @author itguang
 * @create 2018-06-27 16:44
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BlyunTest {


    @Autowired
    JournalTempService journalTempService;


    @Autowired
    JournalTask task;



    @Test
    public void test1() {
        task.task();


    }

    @Test
    public void test2() {
        JournalTempEntity entity = journalTempService.findOneByFlag("1");

        log.info("entity={}",entity.toString());


    }


}
