package dao.impl;

import dao.BaseDao;
import dao.TeacherDao;
import model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author YZ
 * @Date 2018/3/8
 */
@Repository
public class TeacherDaoImpl implements TeacherDao {
    @Autowired
    private BaseDao baseDao;

    public Teacher getTeacherById(int id) {
        return (Teacher)baseDao.load(Teacher.class,id);
    }
}
