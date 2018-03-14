package service;

import model.Teacher;

import java.util.List;

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

    /**
     * 得到一个机构的师资信息
     * @param ins_id
     * @return
     */
    public List<Teacher> getTeachers(int ins_id);
}
