package com.ike.controller;

import com.alibaba.fastjson.JSONObject;
import com.ike.pojo.Course;
import com.ike.service.CourseService;
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
@RequestMapping("/course")
public class CourseController {

    JSONObject jo = new JSONObject();
    int code = 0;
    String msg = "成功";

    private CourseService courseService;
    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object allCourses(Integer page, Integer limit) {
        jo.clear();
        List<Course> all;
        if (page==null || limit==null) {
            all = courseService.getAllCourses();
        } else {
            all = courseService.getAllCourses(page, limit);
        }
        if (all==null) {
            jo.put("code", 1001);
            jo.put("msg", "调用失败，可能是数据库1没有数据，或者参数不正确");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);
        }
        jo.put("data", all);
        jo.put("count", courseService.count());
        return jo;
    }

    @RequestMapping(value = "/hot", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object hotCourses(int num) {
        jo.clear();
        if (num<10 || num>100) {
            num = 10;  // 默认10个
        }
        List<Course> hot = courseService.getHotCourses(num);
        if (hot==null) {
            jo.put("code", 1001);
            jo.put("msg", "调用失败，可能是课程数据不足，或者参数不正确");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);
        }
        jo.put("data", hot);
        jo.put("count", courseService.count());
        return jo;
    }

    @RequestMapping(value = "/new", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object newCourses(int num) {
        jo.clear();
        if (num<10 || num>100) {
            num = 10;
        }
        List<Course> newc = courseService.getNewCourses(num);
        if (newc==null) {
            jo.put("code", 1001);
            jo.put("msg", "调用失败，可能是参数不正确");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);
        }
        jo.put("data", newc);
        jo.put("count", courseService.count());
        return jo;
    }

    @RequestMapping(value = "/type/{type}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getCourseByType(@PathVariable String type) {
        jo.clear();
        List<Course> typecourse = courseService.getCourseByType(type);
        if (typecourse==null) {
            jo.put("code", 1001);
            jo.put("msg", "调用失1败，可能是关键字参数不正确");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);
        }
        jo.put("data", typecourse);
        jo.put("count", courseService.count());

        return jo;
    }

    @RequestMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object searchCourses(String wd) {
        jo.clear();
        List<Course> search = courseService.SearchCourses(wd);
        if (search==null) {
            jo.put("code", 1001);
            jo.put("msg", "调用失败，可能是关键字参数不正确");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);
        }
        jo.put("data", search);
        jo.put("count", courseService.count());
        return jo;
    }

    @RequestMapping(value = "/myjoin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object myJoinCourses(int stu_id) {
        jo.clear();
        List<Course> myjoin = courseService.getMyCourse(stu_id);
        if (myjoin==null) {
            jo.put("code", 1001);
            jo.put("msg", "调用失败，可能是学生id不正确或者参数不正确");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);

        }
        jo.put("data", myjoin);
        jo.put("count", courseService.count());
        return jo;
    }

    @RequestMapping(value = "/myteach", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object myTeachCourses(int tea_id) {
        jo.clear();
        List<Course> myteach = courseService.getMyTeaches(tea_id);
        if (myteach==null) {
            jo.put("code", 1001);
            jo.put("msg", "调用失败，可能是教师id不正确");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);

        }
        jo.put("data", myteach);
        jo.put("count", courseService.count());
        return jo;
    }

    @RequestMapping(value = "/zan", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object doZan(int cou_id) {
        jo.clear();
        int rows = courseService.doZanCourse(cou_id);
        if (rows==0) {
            jo.put("code", 1001);
            jo.put("msg", "调用失败，可能是点赞的课程不存在或者已被删除");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);

        }
        return jo;
    }

    @RequestMapping(value = "/cover", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object setCoverAndUpload(@RequestParam("file") CommonsMultipartFile file, int cid, HttpServletRequest request) throws IOException {
        jo.clear();
        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload/img/cover");

        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        String cover =  "http://localhost:8080/ike/upload/img/cover/" + cid + suffix;
        file.transferTo(new File(String.format("%s/%d%s", realPath, cid, suffix)));
        int rows = courseService.setCover(cid, cover);
        if (rows==0) {
            jo.put("code", 1001);
            jo.put("msg", "更换封面失败，可能是文件过大或者格式不对");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);

        }
        jo.put("cover", cover);
        return jo;

    }






}



