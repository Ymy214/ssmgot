package com.ike.service;

import com.ike.dao.TeacherMapper;
import com.ike.pojo.Teacher;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {

    private TeacherMapper teacherMapper;
    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    public List<Teacher> getAllTeachers() {
        return teacherMapper.getAllTeachers();
    }

    public List<Teacher> getAllTeachers(int page, int limit) {
        return teacherMapper.getAllTeachers1((page-1)*limit, limit);
    }

    public int count() {
        return teacherMapper.count();
    }
}
