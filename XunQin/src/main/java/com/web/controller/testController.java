package com.web.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shiyi on 2016/12/14.
 */
@Controller("test")
@RequestMapping("/t")
public class testController {

    @RequestMapping("")
    public String x()
    {

        return  "uploadlost";
    }

    @RequestMapping("y")
    @ResponseBody
    public HashMap y()
    {

        HashMap s = new HashMap();
        s.put("s", "ydsfhjd啥都看见你撒飞机");
        return  s;
    }


    @RequestMapping("/a/*")
    @ResponseBody
    public Map shi(@PathVariable String name)
    {
        HashMap s = new HashMap();
        s.put("aaa", name);
        return s;
    }

    @RequestMapping("/a/**")
    @ResponseBody
    public Map yi(String name)
    {
        HashMap s = new HashMap();
        s.put("bbb", name);
        return s;
    }

    @RequestMapping("a")
    public String a()
    {

        return  "view/a";
    }
    @RequestMapping("in?")
    public String in()
    {

        return  "index";
    }

    @RequestMapping("c")
    @ResponseBody
    public Map c()
    {
        HashMap s = new HashMap();
        s.put("aaa", "你好啊");
        return s;
}

    @RequestMapping("d")
    @ResponseBody
    public String d()
    {
        HashMap s = new HashMap();
        s.put("aaa", "你好啊");
        return "index";
    }

    @RequestMapping("e")
    public ModelAndView e()
    {
        ModelAndView a = new ModelAndView();
        a.addObject("aaa", "asdasf");
        return a;
    }
}
