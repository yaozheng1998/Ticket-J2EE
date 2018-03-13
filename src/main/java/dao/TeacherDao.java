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

    /**
     * 新增教师
     * @param teacher
     */
    public void addTeacher(Teacher teacher);

    /**
     * 得到下一个可用的教师编号
     * @return
     */
    public long getNextId();


}
