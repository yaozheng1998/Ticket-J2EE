package dao.impl;

import dao.BaseDao;
import dao.ClassDao;
import model.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        return baseDao.querySQL(sql);
    }
}
