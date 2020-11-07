package com.ike.dao;
import com.ike.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    List<Student> LoginCheck1(@Param("tel") String tel, @Param("pwd") String password);

    List<Student> LoginCheck2(@Param("id") int id, @Param("pwd") String password);

    int PickCourse(@Param("cou") int course_id, @Param("stu") int student_id);


    int setIcon(@Param("id") int sid, @Param("icon") String icon);

    int signUp(Student student);

    List<Student> getAllStudents();

    List<Student> getAllStudents1(@Param("start") int start, @Param("limit") int limit);

    int count();
}
