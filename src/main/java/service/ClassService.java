package service;

import model.Classroom;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/8
 */
public interface ClassService {
    /**
     * 获得某个课程下的所有班级
     * @return
     */
    public List<Classroom> getClassOfOneCourse(int course_id);
}
