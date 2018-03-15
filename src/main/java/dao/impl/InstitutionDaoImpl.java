package dao.impl;

import dao.BaseDao;
import dao.InstitutionDao;
import model.Course;
import model.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/7
 */
@Repository
public class InstitutionDaoImpl implements InstitutionDao {
    @Autowired
    private BaseDao baseDao;


    public List<Institution> getAllIns() {
        return baseDao.getAllList(Institution.class);
    }

    public List<String> getAllInsName() {
        String sql = "select distinct ins_name from `institution`";
        List<String> list = baseDao.querySQL(sql);
        return list;
    }

    public List<String> getAllLocation() {
        String sql = "select distinct location from `institution`";
        List<String> list = baseDao.querySQL(sql);
        return list;
    }

    public Institution getInsById(int insId) {
        return (Institution) baseDao.load(Institution.class,insId);
    }

    public void addIns(Institution institution) {
        try{
            baseDao.save(institution);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public long getNextId() {
        return baseDao.getTotalCount(Institution.class)+8000001;
    }

    public boolean whetherAct(int insId) {
        Institution institution=getInfoById(insId);
        if(institution.getState().equals("待审核")){
            return false;
        }
        return true;
    }

    public Institution getInfoById(int insId) {
        return (Institution)baseDao.load(Institution.class,insId);
    }

    public boolean checkPass(int id, String password) {
        Institution institution=getInfoById(id);
        if(institution.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public List<Course> getCoursesOfIns(int insId) {
        String sql="select * from `course` where institution_id="+insId;
        List<Object[]> courses=baseDao.querySQL(sql);
        return null;
    }

    public void change(int ins_id, String ins_name, String location, int classrooms) {
        String sql="update `institution` set changes='"+ins_name+"-"+location+"-"+classrooms+"' where ins_id="+ins_id;
        baseDao.excuteBySql(sql);
    }

    private List<Course> getCourseFromOb(List<Object[]> list){
        List<Course> courseList=new ArrayList<Course>();
        for(Object[] object:list){
            Course course=new Course();
            course.setCourse_id((Integer)object[0]);
            course.setInstitution_id((Integer)object[1]);
            course.setStart_time(String.valueOf(object[2]));
            course.setEnd_time(String.valueOf(object[3]));
            course.setBasic_price((Integer) object[4]);
            course.setTimes((Integer)object[5]);
            course.setType(String.valueOf(object[6]));
            courseList.add(course);
        }
        return courseList;
    }
}