package dao.impl;

import dao.BaseDao;
import dao.ManageDao;
import model.Institution;
import model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import util.InsStaVO;
import util.SumPayVO;
import util.VIPStaVO;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author YZ
 * @Date 2018/3/15
 */
@Transactional
@Repository
public class ManageDaoImpl implements ManageDao{
    @Autowired
    private BaseDao baseDao;

    private List insList=new ArrayList();
    private List insMoneyList=new ArrayList();
    private List vipList=new ArrayList();
    private List vipMoneyList=new ArrayList();

    public List<Institution> getAllIns() {
        String sql="select * from `institution` where state='未审核'";
        List<Object[]> objects=baseDao.querySQL(sql);
        return this.getInsFromOb(objects);
    }

    public List<Institution> getAllChanges() {
        String sql="select * from `institution` where changes!=''";
        List<Object[]> objects=baseDao.querySQL(sql);
        return this.getInsFromOb(objects);
    }

    public void approveRegis(int ins_id) {
        String sql="update `institution` set state='已审核' where ins_id="+ins_id;
        baseDao.excuteBySql(sql);
    }

    public void approveInfo(int ins_id) {
        String sql="select changes from `institution` where ins_id="+ins_id;
        String changes=(String)baseDao.querySQL(sql).get(0);
        String[] strings=changes.split("-");
        String sqlq="update `institution` set ins_name='"+strings[0]+"', location='"+strings[1]+"', classrooms="+strings[2]+", changes='' where ins_id="+ins_id;
        baseDao.excuteBySql(sqlq);
    }

    public void disapproveRegis(int ins_id) {
        String sql="update `institution` set state='不通过' where ins_id="+ins_id;
        baseDao.excuteBySql(sql);
    }

    public void disapproveInfo(int ins_id) {
        String sql="update `institution` set changes='' where ins_id="+ins_id;
        baseDao.excuteBySql(sql);
    }

    public int getNextId() {
        return (int) (baseDao.getTotalCount(Manager.class)+1);
    }

    public void save(Manager manager) {
        try{
            baseDao.save(manager);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Manager getManagerByIns(int ins_id) {
        String sql="select * from `manager` where ins_id="+ins_id;
        List<Object[]> list=baseDao.querySQL(sql);
        Manager manager=this.getManage(list).get(0);
        return manager;
    }

    public void update(Manager manager) {
        baseDao.update(manager);
    }

    public List<SumPayVO> getToCal() {
        String sql="select m.ins_id,i.ins_name,i.location,m.ins_allmoney from `institution` i,`manager` m where m.ins_id=i.ins_id and m.ins_allmoney!=0";
        List<Object[]> objects=baseDao.querySQL(sql);
        return this.getSPV(objects);
    }

    public double paySeven(int ins_id) {
        Manager manager=getManagerByIns(ins_id);
        double money=manager.getIns_allmoney();
        manager.setWeb_profit(manager.getWeb_profit()+money*0.3);
        manager.setIns_allmoney(0);
        baseDao.update(manager);
        return money*0.7;
        //没给机构
    }

    public int getAllOrder() {
        String sql="select count(*) from `orders`";
        return Integer.parseInt(String.valueOf(baseDao.querySQL(sql).get(0)));
    }

    public int getAllStudent() {
        String sql="select count(*) from `order_classes`";
        return Integer.parseInt(String.valueOf(baseDao.querySQL(sql).get(0)));
    }

    public double getAllMoney() {
        String sql="select coalesce(sum(money),0) from `orders`";
        return Double.parseDouble(String.valueOf(baseDao.querySQL(sql).get(0)));
    }

    public List<InsStaVO> getInsSta() {
        String sql="select i.ins_id,i.ins_name,i.location,i.classrooms,count(*),sum(o.money) from `institution` i,`orders` o where o.ins_id=i.ins_id group by i.ins_id,i.ins_name,i.location,i.classrooms order by sum(o.money) desc";
        return this.getInsSta(baseDao.querySQL(sql));
    }

    public List<VIPStaVO> getVIPSta() {
        String sql="select v.vipName,v.vipLevel,count(*),sum(money) from `orders` o,`vip` v where v.vipName=o.vip_name and v.vipName<>'非会员' group by v.vipName,v.vipLevel order by sum(money) desc";
        return this.getVIPSta(baseDao.querySQL(sql));
    }

    private  List<InsStaVO> getInsSta(List<Object[]> list){
        List<InsStaVO> insStaVOS=new ArrayList<InsStaVO>();
        for(Object[] objects:list){
            InsStaVO vo=new InsStaVO();
            vo.setIns_id((Integer)objects[0]);
            vo.setIns_name(String.valueOf(objects[1]));
            insList.add(String.valueOf(objects[1]));
            vo.setLocation(String.valueOf(objects[2]));
            vo.setClass_num((Integer)objects[3]);
            vo.setOrder_num(Integer.parseInt(String.valueOf(objects[4])));
            vo.setMoney(Double.parseDouble(String.valueOf(objects[5])));
            insMoneyList.add(String.valueOf(objects[5]));
            insStaVOS.add(vo);
        }
        return insStaVOS;
    }
    private List<VIPStaVO> getVIPSta(List<Object[]> list){
        List<VIPStaVO> vipStaVOS=new ArrayList<VIPStaVO>();
        for(Object[] objects:list){
            VIPStaVO vo=new VIPStaVO();
            vo.setVip_name(String.valueOf(objects[0]));
            vipList.add(String.valueOf(objects[0]));
            vo.setVip_rank(String.valueOf(objects[1]));
            vo.setOrder_num(Integer.parseInt(String.valueOf(objects[2])));
            vo.setAll_money(Double.parseDouble(String.valueOf(objects[3])));
            vipMoneyList.add((Double)objects[3]);
            vipStaVOS.add(vo);
        }
        return vipStaVOS;
    }

    public List getVipMoneyList() {
        List list=new ArrayList();
        List<VIPStaVO> l=getVIPSta();
        for(int i=0;i<l.size();i++){
            list.add("'"+l.get(i).getAll_money()+"'");
        }
        return list;
    }

    public List getVipList() {
        List list=new ArrayList();
        List<VIPStaVO> l=getVIPSta();
        for(int i=0;i<l.size();i++){
            list.add("'"+l.get(i).getVip_name()+"'");
        }
        return list;
    }

    public List getInsList() {
        List list=new ArrayList();
        List<InsStaVO> l=getInsSta();
        for(int i=0;i<l.size();i++){
            list.add("'"+l.get(i).getIns_name()+"'");
        }
        return list;
    }

    public List getInsMoneyList() {
        List list=new ArrayList();
        List<InsStaVO> l=getInsSta();
        for(int i=0;i<l.size();i++){
            list.add("'"+l.get(i).getMoney()+"'");
        }
        return list;
    }

    static int nowMonth=Calendar.MONTH;
    static SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat df=new SimpleDateFormat("yyyy-MM");
    public Map<String, String> averagePrice() {
        Map<String,String> map=new HashMap<String, String>();
        Calendar c=Calendar.getInstance();
        int month=nowMonth;
        for(int i=1;i<=12;i++){
            c.add(month,-1);
            String time=f.format(c.getTime());
            String sql="select count(*),sum(basic_price) from course co where DATE_FORMAT(co.start_time,'%Y-%m-%d')<='"+time+"' and DATE_FORMAT(co.end_time,'%Y-%m-%d')>='"+time+"';";
            DecimalFormat d=new DecimalFormat("0.00");
            Object[] object= (Object[]) baseDao.querySQL(sql).get(0);
            int count=Integer.parseInt(String.valueOf(object[0]));
            int money=0;
            if(object[1]!=null) {
                money = Integer.parseInt(String.valueOf(object[1]));
            }
            if(count==0){
                map.put(time,"0");
            }
            else {
                map.put(time.substring(0,7), d.format((float)money/count));
            }
        }
        return map;
    }

    /**
     * 与地域相关的订单数量，课程销售数量，订单总额，课程平均售价
     * 返回的String类型为:"订单数量-订单总额-课程销售数量-课程平均售价"
     * @return
     */
    public Map<String, String> getAboutLocation() {
        Map<String,String> map=new HashMap<String, String>();
        String orderSQL="select i.location, count(*), sum(o.money) from orders o, institution i where o.ins_id=i.ins_id group by i.location;";
        String courseSQL="select i.location, count(*), sum(cl.price) from order_classes oc, class cl, course co, institution i where oc.class_id=cl.class_id and cl.course_id=co.course_id and co.institution_id=i.ins_id group by i.location;";
        List orderList=baseDao.querySQL(orderSQL);
        List courseList=baseDao.querySQL(courseSQL);
        for(int i=0;i<orderList.size();i++){
            Object[] o=(Object[])orderList.get(i);
            map.put(String.valueOf(o[0]),o[1].toString()+'-'+o[2].toString());
        }
        for(int j=0;j<courseList.size();j++){
            Object[] ob=(Object[]) courseList.get(j);
            map.put(String.valueOf(ob[0]),map.get(ob[0]).toString()+'-'+ob[1].toString()+'-'+ob[2].toString());
        }
//        System.out.println(map);
        return map;
    }

    public Map<String, String> getOkRateChange() {
        Map<String,String> map=new HashMap<String, String>();
        Calendar c=Calendar.getInstance();
        int month=nowMonth;
        for(int i=1;i<=12;i++){
            c.add(month,-1);
            String time=df.format(c.getTime());
            String nosql="select count(*) from order_classes oc, orders o where DATE_FORMAT(o.order_time,'%Y-%m')='"+time+"' and oc.state='已退订' and oc.itorder_id=o.order_id;";
            String allsql="select count(*) from order_classes oc, orders o where DATE_FORMAT(o.order_time,'%Y-%m')='"+time+"' and oc.itorder_id=o.order_id;";
            DecimalFormat d=new DecimalFormat("0.00");
            int no=Integer.parseInt(String.valueOf(baseDao.querySQL(nosql).get(0)));
            int all=Integer.parseInt(String.valueOf(baseDao.querySQL(allsql).get(0)));
            System.out.println(time+"-"+no+"-"+all);
            if(all==0){
                map.put(time,"0");
            }
            else {
                map.put(time.substring(0,7), d.format((float)(all-no)/all));
            }
        }
        System.out.println(map);
        return map;
    }

    public Map<String, String> getAboutClassType() {
        Map<String,String> map=new HashMap<String, String>();
        String sql="select co.type,count(*),sum(co.basic_price) from order_classes oc,class cl, course co where oc.class_id=cl.class_id and cl.course_id=co.course_id group by co.type;";
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            map.put(String.valueOf(object[0]),String.valueOf(object[1])+'-'+String.valueOf(object[2]));
        }
        return map;
    }

    public Map<String, Double> getMoneyChange() {
        Map<String,Double> map=new HashMap<String, Double>();
        Calendar c=Calendar.getInstance();
        int month=nowMonth;
        for(int i=1;i<=12;i++){
            c.add(month,-1);
            String time=df.format(c.getTime());
            String sql="select sum(money) from orders o where DATE_FORMAT(o.order_time,'%Y-%m')='"+time+"';";
            if(baseDao.querySQL(sql).get(0)!=null) {
                map.put(time.substring(0, 7), Double.parseDouble(String.valueOf(baseDao.querySQL(sql).get(0))));
            }else{
                map.put(time.substring(0, 7), 0.00);
            }
        }
        System.out.println(map);
        return map;
    }

    /**
     * 当月机构销售额排名
     * @return
     */
    public List getTop10Money() {
        List<String> result=new ArrayList<String>();
        String sql="select i.ins_name,i.location,sum(o.money) from institution i, orders o where o.ins_id=i.ins_id and  DATE_FORMAT(o.order_time,'%Y-%m')=DATE_FORMAT(curdate(),'%Y-%m') group by i.ins_name,i.location order by sum(o.money) desc limit 10;";
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            result.add(String.valueOf(object[0])+'-'+String.valueOf(object[1])+'-'+String.valueOf(object[2]));
        }
        return result;
    }

    /**
     * 当月机构学员数排名
     * @return
     */
    public List getTop10Num() {
        List<String> result=new ArrayList<String>();
        String sql="select i.ins_name, count(*) from order_classes oc, class cl, course co, institution i where oc.class_id=cl.class_id and cl.course_id=co.course_id and co.institution_id=i.ins_id and DATE_FORMAT(co.start_time,'%Y-%m-%d')<=DATE_FORMAT(curdate(),'%Y-%m-%d') and DATE_FORMAT(co.end_time,'%Y-%m-%d')>=DATE_FORMAT(curdate(),'%Y-%m-%d') and oc.state<>'已退订' group by i.ins_name order by count(*) desc limit 10;";
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            result.add(String.valueOf(object[0])+'-'+String.valueOf(object[1]));
        }
        return result;
    }

    public List getTop10NumAll() {
        List<String> result=new ArrayList<String>();
        String sql="select i.ins_name, count(*) from order_classes oc, class cl, course co, institution i where oc.class_id=cl.class_id and cl.course_id=co.course_id and co.institution_id=i.ins_id and oc.state<>'已退订' group by i.ins_name order by count(*) desc;";
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            result.add(String.valueOf(object[0])+'-'+String.valueOf(object[1]));
        }
        return result;
    }

    public Map<String, Integer> getStudentsChange() {
        Map<String,Integer> map=new HashMap<String, Integer>();
        Calendar c=Calendar.getInstance();
        int month=nowMonth;
        for(int i=1;i<=12;i++){
            c.add(month,-1);
            String time=f.format(c.getTime());
            String sql="select count(*) from vip v where DATE_FORMAT(v.activateDate,'%Y-%m')<='"+time+"';";
            map.put(time.substring(0,7),Integer.parseInt(String.valueOf(baseDao.querySQL(sql).get(0))));
        }
        return map;
    }

    public Map<String, Integer> getInsChange() {
        Map<String,Integer> map=new HashMap<String, Integer>();
        Calendar c=Calendar.getInstance();
        int month=nowMonth;
        for(int i=1;i<=12;i++){
            c.add(month,-1);
            String time=f.format(c.getTime());
            String sql="select count(*) from institution i where DATE_FORMAT(i.time,'%Y-%m')<='"+time+"';";
            map.put(time.substring(0,7),Integer.parseInt(String.valueOf(baseDao.querySQL(sql).get(0))));
        }
        return map;
    }

    public Map<String, Integer> getInsLocation() {
        Map<String,Integer> map=new HashMap<String, Integer>();
        String sql="select i.location, count(*) from institution i group by i.location;";
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            map.put(String.valueOf(object[0]),Integer.parseInt(String.valueOf(object[1])));
        }
        return map;
    }

    public List getTop10MoneyAll() {
        List<String> result=new ArrayList<String>();
        String sql="select i.ins_name,i.location,sum(o.money) from institution i, orders o where o.ins_id=i.ins_id group by i.ins_name,i.location order by sum(o.money) desc;";
        List<Object[]> objects=baseDao.querySQL(sql);
        for(Object[] object:objects){
            result.add(String.valueOf(object[0])+'-'+String.valueOf(object[1])+'-'+String.valueOf(object[2]));
        }
        return result;
    }


    private List<SumPayVO> getSPV(List<Object[]> list){
        List<SumPayVO> sumPayVOList=new ArrayList<SumPayVO>();
        for(Object[] objects:list){
            SumPayVO vo=new SumPayVO();
            vo.setIns_id((Integer)objects[0]);
            vo.setIns_name(String.valueOf(objects[1]));
            vo.setIns_loc(String.valueOf(objects[2]));
            vo.setSum((Double)objects[3]);
            sumPayVOList.add(vo);
        }
        return sumPayVOList;

    }

    private List<Manager> getManage(List<Object[]> list){
        List<Manager> managerList=new ArrayList<Manager>();
        for (Object[] objects:list) {
            Manager manager = new Manager();
            manager.setId((Integer)objects[0]);
            manager.setIns_id((Integer)objects[1]);
            manager.setIns_allmoney((Double)objects[2]);
            manager.setWeb_profit((Double)objects[3]);
            managerList.add(manager);
        }
        return managerList;
    }
    private List<Institution> getInsFromOb(List<Object[]> list){
        List<Institution> institutionList=new ArrayList<Institution>();
        for(Object[] objects:list){
            Institution institution=new Institution();
            institution.setIns_id((Integer)objects[0]);
            institution.setIns_name(String.valueOf(objects[1]));
            institution.setPassword(String.valueOf(objects[2]));
            institution.setLocation(String.valueOf(objects[3]));
            institution.setClassrooms((Integer)objects[4]);
            institution.setState(String.valueOf(objects[5]));
            institution.setChanges(String.valueOf(objects[6]));
            institutionList.add(institution);
        }
        return institutionList;
    }
}
