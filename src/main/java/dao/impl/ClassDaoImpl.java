package dao.impl;

import dao.BaseDao;
import dao.ClassDao;
import model.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.CourseClassVO;

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

    public Classroom getInfoByClassId(int class_id) {
        return (Classroom)baseDao.load(Classroom.class,class_id);
    }

    public void save(Classroom classroom) {
        try{
            baseDao.save(classroom);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getIdFromName(String name) {
        String sql="select class_id from `class` where class_name='"+name+"'";
        int id=(Integer)baseDao.querySQL(sql).get(0);
        return id;
    }

    public double getMoneyFromName(String name) {
        String sql="select price from `class` where class_name='"+name+"'";
        double money=(Integer)baseDao.querySQL(sql).get(0);
        return money;
    }

    public List<CourseClassVO> getClassOfIns(int insId) {
        String sql="select co.course_id,co.type,co.start_time,co.end_time,co.times,cl.class_name,t.name,cl.price,cl.all_num,cl.now_num from `class` cl,`course` co,`teacher` t where cl.course_id=co.course_id and cl.teacher_id=t.teacher_id and co.institution_id="+insId;
        List<Object[]> list=baseDao.querySQL(sql);
        return this.getCC(list);
    }

    public int getNextId() {
        String sql="select coalesce(max(`class_id`),0) from `class`";
        return Integer.parseInt(String.valueOf(baseDao.querySQL(sql).get(0)))+1;
    }

    public void minus(int class_id) {
        String sql="update `class` set now_num=now_num+1 where class_id="+class_id;
        baseDao.excuteBySql(sql);
    }

    private List<CourseClassVO> getCC(List<Object[]> objects){
        List<CourseClassVO> courseClassVOList=new ArrayList<CourseClassVO>();
        for(Object[] object:objects){
            CourseClassVO vo=new CourseClassVO();
            vo.setCourse_id((Integer)object[0]);
            vo.setCourse_name(String.valueOf(object[1]));
            vo.setStart_time(String.valueOf(object[2]));
            vo.setEnd_time(String.valueOf(object[3]));
            vo.setTimes((Integer)object[4]);
            vo.setClass_name(String.valueOf(object[5]));
            vo.setTeacher_name(String.valueOf(object[6]));
            vo.setPrice((Double)object[7]);
            vo.setAll_num((Integer)object[8]);
            vo.setNow_num((Integer)object[9]);
            courseClassVOList.add(vo);
        }
        return courseClassVOList;
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
//            System.out.println("banji"+classroom);
            classroomList.add(classroom);
        }
        return classroomList;
    }
}
