package com.ike.controller;

import com.alibaba.fastjson.JSONObject;
import com.ike.pojo.Teacher;
import com.ike.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    JSONObject jo = new JSONObject();
    int code = 0;
    String msg = "成功";

    private TeacherService teacherService;
    @Autowired
    public void setStudentService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getAllTeachers(Integer page, Integer limit) {
        jo.clear();
        List<Teacher> all;
        if (page==null || limit==null) {
            all = teacherService.getAllTeachers();
        } else {
            all = teacherService.getAllTeachers(page, limit);
        }
        if (all==null) {
            jo.put("code", 1001);
            jo.put("msg", "调用失败，可能是数据库没有数据，或者参数不正确1");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);
        }
        jo.put("data", all);
        jo.put("count", teacherService.count());
        return jo;
    }



}
