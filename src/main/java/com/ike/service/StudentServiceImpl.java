package com.ike.service;

import com.ike.dao.StudentMapper;
import com.ike.pojo.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService{

    private StudentMapper studentMapper;
    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }

    public List<Student> getAllStudents(int page, int limit) {
        return studentMapper.getAllStudents1((page-1)*limit, limit);
    }

    public List<Student> LoginCheck1(String tel, String password) {
        return studentMapper.LoginCheck1(tel, password);
    }

    public List<Student> LoginCheck2(int id, String password) {
        return studentMapper.LoginCheck2(id, password);
    }

    public int signUp(Student student) {
        return studentMapper.signUp(student);
    }

    public int PickCourse(int course_id, int student_id) {
        return studentMapper.PickCourse(course_id, student_id);
    }

    public int setIcon(int sid, String icon) {
        return studentMapper.setIcon(sid, icon);
    }

    public int count() {
        return studentMapper.count();
    }
}
