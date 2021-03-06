package service.impl;

import dao.TeacherDao;
import model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.TeacherService;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/8
 */
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService{
    @Autowired
    private TeacherDao teacherDao;

    public Teacher getTeacherById(int id) {
        return teacherDao.getTeacherById(id);
    }

    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    public long getNextId() {
        return teacherDao.getNextId();
    }

    public List<Teacher> getTeachers(int ins_id) {
        return teacherDao.getTeachers(ins_id);
    }

    public int getIdByName(String name) {
        return teacherDao.getIdByName(name);
    }
}
