package com.ike.service;

import com.ike.dao.CommentMapper;
import com.ike.pojo.Comment;
import com.ike.pojo.Course;

import java.util.List;

public class CommentServiceImpl implements CommentService{

    private CommentMapper commentMapper;
    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }


    public List<Comment> getCommentForCourse(int cou_id) {
        return commentMapper.getCommentForCourse(cou_id);
    }

    public List<Comment> getCommentFromCourse(int stu_id) {
        return commentMapper.getCommentFromCourse(stu_id);
    }

    public List<Course> getAllComments() {
        return commentMapper.getAllComments();
    }

    public List<Course> getAllComments(int page, int limit) {
        return commentMapper.getAllComments1((page-1)*limit, limit);
    }

    public int count() {
        return commentMapper.count();
    }
}
