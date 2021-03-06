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

    /**
     * 根据选择的筛选条件，选择对应的课程；机构，地点，学科每样至多选择一个
     * @param ins
     * @param loc
     * @param sub
     * @return
     */
    public List<Course> getCourseByILS(String ins,String loc,String sub);

    /**
     * 得到所有学科
     * @return
     */
    public List<String> getAllSubjects();

    /**
     * 根据课程编号获得课程信息
     * @param courseId
     * @return
     */
    public Course getInfoByCourseId(int courseId);

    /**
     * 新发布课程
     * @param course
     */
    public void save(Course course);

    /**
     * 得到下一个可用的课程编号
     * @return
     */
    public int getNextId();
}
