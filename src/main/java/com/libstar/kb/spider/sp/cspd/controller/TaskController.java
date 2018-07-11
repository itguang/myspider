package com.libstar.kb.spider.sp.cspd.controller;

import com.libstar.kb.spider.sp.cspd.article.CSPDJournalListTask;
import com.libstar.kb.spider.sp.cspd.perio.PerioContentTask;
import com.libstar.kb.spider.sp.cspd.yeartree.YearTreeTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author itguang
 * @create 2018-07-03 9:04
 **/
@RestController
@Slf4j
public class TaskController {


    @Autowired
    CSPDJournalListTask cspdJournalListTask;
    @Autowired
    YearTreeTask yearTreeTask;
    @Autowired
    PerioContentTask perioContentTask;


    @RequestMapping("/article")
    public String articleSP() {


        cspdJournalListTask.task();

        log.info("开始爬取期刊名称数据入库");


        return "开始爬取期刊名称数据入库";


    }

    @RequestMapping("/yeartree")
    public String yeartreeSP() {

        yearTreeTask.task();
        log.info("开始爬取期刊号数据入库");

        return "开始爬取期刊号数据入库";

    }

    @RequestMapping("/perio")
    public String perioSP() {

        perioContentTask.task();

        log.info("开始爬取期刊目录数据入库");

        return "开始爬取期刊目录数据入库";

    }





}
