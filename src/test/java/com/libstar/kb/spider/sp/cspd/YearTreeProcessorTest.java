package com.libstar.kb.spider.sp.cspd;

import com.libstar.kb.spider.sp.cspd.yeartree.YearTreeTask;
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
public class YearTreeProcessorTest {

    @Autowired
    YearTreeTask yearTreeTask;


    @Test
    public void test1() {
        yearTreeTask.task();


    }


}
