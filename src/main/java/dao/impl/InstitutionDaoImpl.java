package dao.impl;

import dao.BaseDao;
import dao.InstitutionDao;
import model.Course;
import model.Institution;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import util.ToPayOrderVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author YZ
 * @Date 2018/3/7
 */
@Transactional
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
        String sql="select coalesce(sum(money),0) from `orders` where ins_id="+ins_id;
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

    public Map<String, Integer> getOrderNumChange(int ins_id) {
        String sql="select distinct DATE_FORMAT(order_time,'%Y-%m'),count(*) from orders where ins_id="+ins_id+" and DATE_FORMAT(order_time,'%Y%m')>DATE_FORMAT(date_sub(curdate(), interval 12 month),'%Y-%m') group by DATE_FORMAT(order_time,'%Y-%m')";
        Map<String,Integer> map=new HashMap<String, Integer>();
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            map.put(String.valueOf(object[0]),Integer.parseInt(String.valueOf(object[1])));
        }
//        System.out.print(map);
        return map;
    }

    public Map<String, Double> getOrderMoneyChange(int ins_id) {
        String sql="select distinct DATE_FORMAT(order_time,'%Y-%m'),sum(money) from orders where ins_id="+ins_id+" and DATE_FORMAT(order_time,'%Y%m')>DATE_FORMAT(date_sub(curdate(), interval 12 month),'%Y-%m') group by DATE_FORMAT(order_time,'%Y-%m')";
        Map<String,Double> map=new HashMap<String, Double>();
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            map.put(String.valueOf(object[0]),Double.parseDouble(String.valueOf(object[1])));
        }
        return map;
    }

    public Map<String, Integer> getStudentNumChange(int ins_id) {

        return null;
    }

    public Map<String, Double> getOKRateChange(int ins_id) {
        return null;
    }

    public Map<String, Double> getAveragePrice(int ins_id) {
        return null;
    }

    public Map<String, Double> getBuyMethod(int ins_id) {
        return null;
    }

    public List getTopCourseMonth(int ins_id) {
        String sql="select co.type,count(*) from orders o, course co, order_classes oc, class cl where o.ins_id="+ins_id+" and DATE_FORMAT(o.order_time,'%Y-%m')=DATE_FORMAT(curdate(),'%Y-%m') and o.order_id=oc.itorder_id and oc.class_id=cl.class_id and cl.course_id=co.course_id group by co.type order by count(*) desc limit 6;";
        List<String> list=new ArrayList<String>();
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            list.add(String.valueOf(object[0]));
        }
        return list;
    }

    public List getTopCourseAll(int ins_id) {
        String sql="select co.type,count(*) from orders o, course co, order_classes oc, class cl where o.ins_id="+ins_id+" and o.order_id=oc.itorder_id and oc.class_id=cl.class_id and cl.course_id=co.course_id group by co.type order by count(*) desc limit 6;";
        List<String> list=new ArrayList<String>();
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            list.add(String.valueOf(object[0]));
        }
        return list;
    }

    public List getTopClassMonth(int ins_id) {
        String sql="select cl.class_name,count(*) from class cl, orders o, order_classes oc where o.order_id=oc.itorder_id and o.ins_id="+ins_id+" and oc.class_id=cl.class_id and DATE_FORMAT(o.order_time,'%Y-%m')=DATE_FORMAT(curdate(),'%Y-%m') group by cl.class_name order by count(*) desc limit 10;";
        List<String> list=new ArrayList<String>();
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            list.add(String.valueOf(object[0]));
        }
        return list;
    }

    public List getTopClassAll(int ins_id) {
        String sql="select cl.class_name,count(*) from class cl, orders o, order_classes oc where o.order_id=oc.itorder_id and o.ins_id="+ins_id+" and oc.class_id=cl.class_id group by cl.class_name order by count(*) desc limit 10;";
        List<String> list=new ArrayList<String>();
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            list.add(String.valueOf(object[0]));
        }
        return list;
    }

    public Map<String, Integer> getClassType(int ins_id) {
        String sql="select co.type,count(*) from orders o, course co, order_classes oc, class cl where o.ins_id="+ins_id+" and o.order_id=oc.itorder_id and oc.class_id=cl.class_id and cl.course_id=co.course_id group by co.type order by count(*) desc;";
        Map<String,Integer> map=new HashMap<String, Integer>();
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            map.put(String.valueOf(object[0]),Integer.parseInt(String.valueOf(object[1])));
        }
        return map;
    }

    public Map<String, Integer> getClassStatus(int ins_id) {
        String sql="select oc.state, count(*) from orders o, order_classes oc where oc.itorder_id=o.order_id and o.ins_id="+ins_id+" group by oc.state;";
        Map<String,Integer> map=new HashMap<String, Integer>();
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            map.put(String.valueOf(object[0]),Integer.parseInt(String.valueOf(object[1])));
        }
        return map;
    }

    public Map<String, Integer> getClassGrades(int ins_id) {
        String sql0_59="select count(*) from orders o, order_classes oc where oc.itorder_id=o.order_id and o.ins_id="+ins_id+" and oc.grade between 1 and 59;";
        String sql60_74="select count(*) from orders o, order_classes oc where oc.itorder_id=o.order_id and o.ins_id="+ins_id+" and oc.grade between 60 and 74;";
        String sql75_84="select count(*) from orders o, order_classes oc where oc.itorder_id=o.order_id and o.ins_id="+ins_id+" and oc.grade between 75 and 84;";
        String sql85_100="select count(*) from orders o, order_classes oc where oc.itorder_id=o.order_id and o.ins_id="+ins_id+" and oc.grade between 85 and 100;";
        Map<String,Integer> map=new HashMap<String, Integer>();
        map.put("0-59",Integer.parseInt(baseDao.querySQL(sql0_59).get(0).toString()));
        map.put("60-74",Integer.parseInt(baseDao.querySQL(sql60_74).get(0).toString()));
        map.put("75-84",Integer.parseInt(baseDao.querySQL(sql75_84).get(0).toString()));
        map.put("85-100",Integer.parseInt(baseDao.querySQL(sql85_100).get(0).toString()));
        return map;
    }

    /**
     * 需要解决HashMap没有顺序的问题
     * @param ins_id
     * @return
     */
    public Map<String, Double> getTop5(int ins_id) {
        String sql="select o.vip_name, v.vipLevel, sum(money) from orders o, vip v where o.vip_name=v.vipName and o.vip_name<>'非会员' and o.ins_id="+ins_id+" group by o.vip_name order by sum(money) desc limit 5;";
        Map<String,Double> map=new HashMap<String, Double>();
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            map.put(String.valueOf(object[0])+'-'+String.valueOf(object[1]),Double.parseDouble(String.valueOf(object[2])));
        }
        System.out.println(map);
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