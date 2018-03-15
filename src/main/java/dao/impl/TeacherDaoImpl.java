package dao.impl;

import dao.BaseDao;
import dao.TeacherDao;
import model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    public void addTeacher(Teacher teacher) {
        try{
            baseDao.save(teacher);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public long getNextId() {
        return baseDao.getTotalCount(Teacher.class)+200;
    }

    public List<Teacher> getTeachers(int ins_id) {
        String sql="select * from `teacher` where ins_id="+ins_id;
        return this.getTFO(baseDao.querySQL(sql));
    }

    public int getIdByName(String name) {
        String sql="select teacher_id from `teacher` where name='"+name+"'";
        return (Integer) baseDao.querySQL(sql).get(0);
    }

    private List<Teacher> getTFO(List<Object[]> list){
        List<Teacher> teacherList=new ArrayList<Teacher>();
        for(Object[] objects:list){
            Teacher teacher=new Teacher();
            teacher.setTeacher_id((Integer) objects[0]);
            teacher.setIns_id((Integer) objects[1]);
            teacher.setName(String.valueOf(objects[2]));
            teacher.setRank(String.valueOf(objects[3]));
            teacher.setSubject(String.valueOf(objects[4]));
            teacherList.add(teacher);
        }
        return teacherList;
    }
}
