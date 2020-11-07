package com.ike.service;

import com.ike.dao.CourseMapper;
import com.ike.pojo.Course;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private CourseMapper courseMapper;
    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }


    public List<Course> getAllCourses() {
        return courseMapper.getAllCourses();
    }

    public List<Course> getCourseByType(String type) {
        return courseMapper.getCourseByType('%'+type+'%');
    }

    public List<Course> getAllCourses(int page, int limit) {
        return courseMapper.getAllCourses1((page-1)*limit, limit);
    }

    public List<Course> getHotCourses(int num) {
        return courseMapper.getHotCourses(num);
    }

    public List<Course> getNewCourses(int num) {
        return courseMapper.getNewCourses(num);
    }

    public List<Course> SearchCourses(String wd) {
        return courseMapper.SearchCourses("%"+wd+"%", "%"+wd+"%");
    }

    public List<Course> getMyCourse(int stu_id) {
        return courseMapper.getMyCourse(stu_id);
    }

    public List<Course> getMyTeaches(int tea_id) {
        return courseMapper.getMyTeaches(tea_id);
    }

    public int doZanCourse(int cou_id) {
        return courseMapper.doZanCourse(cou_id);
    }

    public int setCover(int cid, String cover) {
        return courseMapper.setCover(cid, cover);
    }

    public int count() {
        return courseMapper.count();
    }
}
