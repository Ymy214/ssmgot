package com.ike.dao;

import com.ike.pojo.Comment;
import com.ike.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    List<Comment> getCommentForCourse(int cou_id);
    List<Comment> getCommentFromCourse(int stu_id);

    List<Course> getAllComments();

    List<Course> getAllComments1(@Param("start") int s, @Param("limit") int l);

    int count();
}
