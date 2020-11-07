package com.ike.dao;

import com.ike.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//@Mapper
public interface CourseMapper {
    //@Select("select * from course")
    List<Course> getAllCourses();  //

    List<Course> getAllCourses1(@Param("start") int start, @Param("limit") int limit);

    List<Course> getCourseByType(String type);

    List<Course> getHotCourses(int num);  //

    List<Course> getNewCourses(int num);  //

    List<Course> SearchCourses(@Param("key1") String wd1, @Param("key2") String wd2);  //

    List<Course> getMyCourse(int stu_id);  //

    List<Course> getMyTeaches(int tea_id);  //

    int doZanCourse(int cou_id);

    int setCover(@Param("id") int cid, @Param("cover") String cover);

    int count();
}
