package com.ike.service;

import com.ike.pojo.Course;
import java.util.List;

public interface CourseService {
    //@Select("select * from course")
    List<Course> getAllCourses();  //

    List<Course> getCourseByType(String type);

    List<Course> getAllCourses(int page, int limit);

    List<Course> getHotCourses(int num);  //

    List<Course> getNewCourses(int num);  //

    List<Course> SearchCourses(String wd);  //

    List<Course> getMyCourse(int stu_id);  //

    List<Course> getMyTeaches(int tea_id);  //

    int doZanCourse(int cou_id);

    int setCover(int cid, String cover);

    int count();
}
