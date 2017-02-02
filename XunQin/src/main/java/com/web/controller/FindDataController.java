package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shiyi on 2016/12/16.
 */
@Controller("FindDataController")
@RequestMapping("/finddata")
public class FindDataController {

    //信息列表
    @RequestMapping("list")
    public void showMoreLostMess() {

    }

    //信息详情页
    @RequestMapping("{dataid}")
    public void showOneLostMess() {

    }
}