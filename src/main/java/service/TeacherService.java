package service;

import model.Teacher;

/**
 * @Author YZ
 * @Date 2018/3/8
 */
public interface TeacherService {
    /**
     * 根据教师编号获得教师的信息
     * @param id
     * @return
     */
    public Teacher getTeacherById(int id);
}
