package com.libstar.kb.spider.sp.blyun.controller;

import com.libstar.kb.spider.sp.blyun.journal.JournalTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author itguang
 * @create 2018-07-20 17:44
 **/
@RestController
public class BlyunController {

    @Autowired
    JournalTask task;

    @RequestMapping("/blyun")
    public String test(){


        task.task();

        return "ok";
    }


}
