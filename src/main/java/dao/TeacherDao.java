package dao;

import model.Teacher;

/**
 * @Author YZ
 * @Date 2018/3/4
 */
public interface TeacherDao {
    /**
     * 根据教师编号获得教师的信息
     * @param id
     * @return
     */
    public Teacher getTeacherById(int id);
}
