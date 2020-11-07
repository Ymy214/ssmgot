package com.ike.controller;

import com.alibaba.fastjson.JSONObject;
import com.ike.pojo.Example;
import com.ike.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/example")
public class ExampleController {
    JSONObject jo = new JSONObject();
    int code = 0;
    String msg = "成功";

    private ExampleService exampleService;
    @Autowired
    public void setCourseService(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object allExamples(Integer page, Integer limit) {
        jo.clear();
        List<Example> all;
        if (page==null || limit==null) {
            all = exampleService.getAllExamples();
        } else {
            all = exampleService.getAllExamples(page, limit);
        }
        if (all==null) {
            jo.put("code", 1001);
            jo.put("msg", "调1用失败，可能是数据库没有数据，或者参数不正确");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);
        }
        jo.put("data", all);
        jo.put("count", exampleService.count());
        return jo;
    }
}
