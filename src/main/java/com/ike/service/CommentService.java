package com.ike.service;

import com.ike.pojo.Comment;
import com.ike.pojo.Course;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentForCourse(int cou_id);
    List<Comment> getCommentFromCourse(int stu_id);

    List<Course> getAllComments();

    List<Course> getAllComments(int page, int limit);

    int count();
}
