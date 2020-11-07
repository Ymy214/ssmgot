package com.ike.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class My {
    //引导cms入口
    @RequestMapping("/cms")
    public String cms() {
        return "toCMS";
    }
    @RequestMapping("/admin")
    public String admin() {
        return "toCMS";
    }
    @RequestMapping("/manage")
    public String manage() {
        return "toCMS";
    }
    //跳到首页
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    @RequestMapping("/idx")
    public String idx() {
        return "index";
    }
    @RequestMapping("/home")
    public String home() {
        return "index";
    }







}
