package dao.impl;

import dao.BaseDao;
import dao.ClassDao;
import model.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/8
 */
@Repository
public class ClassDaoImpl implements ClassDao {
    @Autowired
    private BaseDao baseDao;

    public List<Classroom> getClassOfOneCourse(int course_id) {
        String sql="select * from `class` where course_id="+course_id;
        List<Object[]> classrooms=baseDao.querySQL(sql);
        return this.getClassrooms(classrooms);
    }

    private List<Classroom> getClassrooms(List<Object[]> objects){
        List<Classroom> classroomList=new ArrayList<Classroom>();
        for(Object[] object:objects){
            Classroom classroom=new Classroom();
            classroom.setClass_id((Integer)object[0]);
            classroom.setClass_name(String.valueOf(object[1]));
            classroom.setCourse_id((Integer)object[2]);
            classroom.setTeacher_id((Integer)object[3]);
            classroom.setPrice((Double)object[4]);
            classroom.setAll_num((Integer)object[5]);
            classroom.setNow_num((Integer)object[6]);
            classroomList.add(classroom);
        }
        return classroomList;
    }
}
