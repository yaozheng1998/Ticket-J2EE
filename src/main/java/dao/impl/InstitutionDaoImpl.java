package dao.impl;

import dao.BaseDao;
import dao.InstitutionDao;
import model.Course;
import model.Institution;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.ToPayOrderVO;

import java.util.ArrayList;
import java.util.HashMap;
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
        if(!institution.getState().equals("已审核")){
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
        return this.getCourseFromOb(courses);
    }

    public void change(int ins_id, String ins_name, String location, int classrooms) {
        String sql="update `institution` set changes='"+ins_name+"-"+location+"-"+classrooms+"' where ins_id="+ins_id;
        baseDao.excuteBySql(sql);
    }

    public void setMoney(int ins_id,double money) {
        String sql="update `institution` set money=money+"+money+"where ins_id="+ins_id;
        baseDao.excuteBySql(sql);
    }

    public List<Object[]> getInsOrdersByState(int ins_id,String state) {
        String sql="select oc.orderclass_id,oc.itorder_id,oc.class_id,oc.real_name,oc.phone,oc.grade,oc.refund_time,oc.refund_money,o.vip_name,o.order_time,o.money,o.pay_type from `order_classes` oc,`orders` o where o.order_id=oc.itorder_id and o.ins_id="+ins_id+" and oc.state='"+state+"'";
        return baseDao.querySQL(sql);
    }

    public int getOrderNum(int ins_id) {
        String sql="select count(*) from `orders` where ins_id="+ins_id;
        return Integer.parseInt(String.valueOf(baseDao.querySQL(sql).get(0)));
    }

    public int getStudentNum(int ins_id) {
        String sql="select count(*) from `orders` o,`order_classes` oc where oc.itorder_id=o.order_id and ins_id="+ins_id;
        return Integer.parseInt(String.valueOf(baseDao.querySQL(sql).get(0)));
    }

    public double getMoney(int ins_id) {
        String sql="select sum(money) from `orders` where ins_id="+ins_id;
        return Double.parseDouble(String.valueOf(baseDao.querySQL(sql).get(0)));
    }

    public int getNumByState(int ins_id, String state) {
        String sql="select count(*) from `orders` o,`order_classes` oc where oc.itorder_id=o.order_id and o.ins_id='"+ins_id+"' and oc.state='"+state+"'";
        return Integer.parseInt(String.valueOf(baseDao.querySQL(sql).get(0)));
    }

    public HashMap getNumByTeacher(int ins_id) {
        HashMap map=new HashMap();
        String sql="select t.name,count(*) from `orders` o,`teacher` t,`order_classes` oc,`class` c where oc.itorder_id=o.order_id and oc.class_id=c.class_id and c.teacher_id=t.teacher_id and o.ins_id="+ins_id+" group by t.name";
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            map.put(String.valueOf(object[0]),Integer.parseInt(String.valueOf(object[1])));
        }
        return map;
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

    private List<Order> getO(List<Object[]> list){
        List<Order> orders=new ArrayList<Order>();
        for(Object[] objects:list){
            Order vo=new Order();
            vo.setOrder_id((Integer) objects[0]);
            vo.setVip_name(String.valueOf(objects[1]));
            vo.setIns_id((Integer)objects[2]);
            vo.setOrder_time(String.valueOf(objects[3]));
            vo.setMoney((Double)objects[4]);
            vo.setPay_type(String.valueOf(objects[5]));
            orders.add(vo);
        }
        return orders;

    }
}