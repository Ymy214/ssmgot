package com.ike.service;

import com.ike.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    List<Teacher> getAllTeachers(int page, int limit);

    int count();
}
