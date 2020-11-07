package com.ike.dao;

import com.ike.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {


    List<Teacher> getAllTeachers();

    List<Teacher> getAllTeachers1(@Param("start") int s, @Param("limit") int l);

    int count();
}
