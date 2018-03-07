package service;

import model.Course;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/7
 */
public interface CourseService {
    /**
     * 获得所有课程，机构名分类，地点分类，学科分类
     * @return
     */
    public List<Course> getAllCourse();
    public List<Course> getCourseByIns(List<String> inses);
    public List<Course> getCourseByLocation(List<String> locs);
    public List<Course> getCourseBySubject(List<String> subs);
}
