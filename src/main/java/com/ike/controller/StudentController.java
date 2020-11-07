package com.ike.controller;

import com.alibaba.fastjson.JSONObject;
import com.ike.pojo.Student;
import com.ike.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    JSONObject jo = new JSONObject();
    int code = 0;
    String msg = "成功";

    private StudentService studentService;
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object allStudents(Integer page, Integer limit) {
        jo.clear();
        List<Student> all;
        if (page==null || limit==null) {
            all = studentService.getAllStudents();
        } else {
            all = studentService.getAllStudents(page, limit);
        }
        if (all==null) {
            jo.put("code", 1001);
            jo.put("msg", "调用失败，可能是数据库没有数据，或者参数不正确2");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);
        }
        jo.put("data", all);
        jo.put("count", studentService.count());
        return jo;
    }

    @RequestMapping(value = "/loginByTel/{tel}/{pass}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object login1(@PathVariable String tel, @PathVariable String pass) {
        jo.clear();
        List<Student> stu = studentService.LoginCheck1(tel, pass);
        if (stu==null) {
            jo.put("code", 1001);
            jo.put("msg", "登陆失败，可能手机号错误，或者参数不正确");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);
        }
        jo.put("data", stu);
        jo.put("count", studentService.count());
        return jo;
    }
    @RequestMapping(value = "/loginById/{id}/{pass}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object login2(@PathVariable int id, @PathVariable String pass) {
        jo.clear();
        List<Student> stu = studentService.LoginCheck2(id, pass);
        if (stu==null) {
            jo.put("code", 1001);
            jo.put("msg", "登陆失败，可能没有该学生，或者参数不正确");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);
        }
        jo.put("data", stu);
        jo.put("count", studentService.count());
        return jo;
    }

    @RequestMapping(value = "/pickCourse/{course_id}/{student_id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object pickCourse(@PathVariable int course_id, @PathVariable int student_id) {
        jo.clear();
        int rows = studentService.PickCourse(course_id, student_id);
        if (rows==0) {
            jo.put("code", 1001);
            jo.put("msg", "选课失败，可能是课程不存在或者学生能够不存在");
        }
        jo.put("code", code);
        jo.put("msg", msg);
        return jo;
    }

    @RequestMapping(value = "/avatar", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object setIconAndUpload(@RequestParam("file") CommonsMultipartFile file, int sid, HttpServletRequest request) throws IOException {
        jo.clear();
        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload/img/head");

        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        String avatar =  "http://localhost:8080/ike/upload/img/head/" + sid + suffix;
        file.transferTo(new File(String.format("%s/%d%s", realPath, sid, suffix)));
        int rows = studentService.setIcon(sid, avatar);
        if (rows==0) {
            jo.put("code", 1001);
            jo.put("msg", "更换头像失败，可能是文件过大或者格式不对");
        }
        jo.put("code", code);
        jo.put("msg", msg);
        jo.put("avatar", avatar);
        return jo;

    }

    @RequestMapping(value = "/signUp", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object addStu() {
        jo.clear();

        studentService.signUp(new Student());
        return jo;

    }




}
