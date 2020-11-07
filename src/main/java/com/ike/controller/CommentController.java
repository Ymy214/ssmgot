package com.ike.controller;

import com.alibaba.fastjson.JSONObject;
import com.ike.pojo.Comment;
import com.ike.pojo.Course;
import com.ike.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    JSONObject jo = new JSONObject();
    int code = 0;
    String msg = "成功";

    private CommentService commentService;
    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object getAllComments(Integer page, Integer limit) {
        jo.clear();
        List<Course> all;
        if (page==null || limit==null) {
            all = commentService.getAllComments();
        } else {
            all = commentService.getAllComments(page, limit);
        }
        if (all==null) {
            jo.put("code", 1001);
            jo.put("msg", "调用失败，可能是数据库没有数据，或者参数不正确");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);
        }
        jo.put("data", all);
        jo.put("count", commentService.count());
        return jo;
    }

    @RequestMapping(value = "/received", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object courseReceivedComments(int cou_id) {
        jo.clear();
        List<Comment> received = commentService.getCommentForCourse(cou_id);
        if (received==null) {
            jo.put("code", 1001);
            jo.put("msg", "调用失败，可能是课程暂时没获得评论，或者参数不正确");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);
        }
        jo.put("data", received);
        jo.put("count", commentService.count());

        return jo;
    }

    @RequestMapping(value = "/mysend", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object mySendComments(int stu_id) {
        jo.clear();
        List<Comment> mysend = commentService.getCommentFromCourse(stu_id);
        if (mysend==null) {
            jo.put("code", 1001);
            jo.put("msg", "调用失败，可能是没有这个学生或者该学生暂时没有发表评论，或者参数不正确");
        } else {
            jo.put("code", code);
            jo.put("msg", msg);
        }
        jo.put("data", mysend);
        jo.put("count", commentService.count());

        return jo;
    }






}
