package dao.impl;

import dao.BaseDao;
import dao.CourseDao;
import model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/7
 */
@Repository
public class CourseDaoImpl implements CourseDao{
    @Autowired
    private BaseDao baseDao;

    public List<Course> getAllCourse() {
        return baseDao.getAllList(Course.class);
    }

    public List<Course> getCourseByIns(List<String> inses) {
        String sql="select * from `course` c,`institution` i where c.institution_id=i.ins_id and i.ins_name=";
        for(String ins:inses){
            sql+=" '"+ins+"' or";
        }
        sql=sql.substring(0,sql.length()-2);
        return baseDao.querySQL(sql);
    }

    public List<Course> getCourseByLocation(List<String> locs) {
        return null;
    }

    public List<Course> getCourseBySubject(List<String> subs) {
        return null;
    }

    /**
     * 根据选择的筛选条件，选择对应的课程；机构，地点，学科每样至多选择一个
     * @param ins
     * @param loc
     * @param sub
     * @return
     */
    public List<Course> getCourseByILS(String ins,String loc,String sub){
        return null;
    }

    public List<String> getAllSubjects() {
        String sql = "select distinct type from `course`";
        List<String> list = baseDao.querySQL(sql);
        return list;
    }
}
