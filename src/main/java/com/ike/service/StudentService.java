package com.ike.service;

import com.ike.pojo.Student;
import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    List<Student> getAllStudents(int page, int limit);
    List<Student> LoginCheck1(String tel, String password);
    List<Student> LoginCheck2(int id, String password);

    int signUp(Student student);
    int PickCourse(int course_id, int student_id);
    int setIcon(int sid, String icon);

    int count();
}
