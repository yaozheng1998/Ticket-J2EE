package dao.impl;

import dao.BaseDao;
import dao.VipDao;
import model.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author YZ
 * @Date 2018/2/25
 */
@Transactional
@Repository
public class VipDaoImpl implements VipDao {
    @Autowired
    private BaseDao baseDao;

    public void save(Vip vip) {
        try{
            baseDao.save(vip);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean checkExisted(String vipName) {
        if(this.find(vipName)!=null){
            return true;
        }
        return false;
    }

//    public String getId() {
//        long currentId=baseDao.getTotalCount(Vip.class);
//        DecimalFormat df=new DecimalFormat("000000");
//        String newId="V"+df.format(currentId+1);
//        return newId;
//    }

    public void update(Vip vip) {

        baseDao.update(vip);
    }

    public Vip find(String vipName) {
        Vip vip=(Vip)baseDao.load(Vip.class,vipName);
        return vip;
    }

    public boolean checkPassword(String vipName, String password) {
        Vip vip=this.find(vipName);
        if(vip.getVipPassword().equals(password)){
            return true;
        }
        return false;
    }

    public void cancelVIP(String vipName) {
        Vip vip=this.find(vipName);
        vip.setCancelDate("CANCEL");
        baseDao.update(vip);
    }

    public boolean convert(String vipName) {
        Vip vip=this.find(vipName);
        if(vip.getVipPoint()>=100) {
            vip.setVipPoint(vip.getVipPoint() - 100);
            vip.setVipSubMoney(vip.getVipSubMoney() + 10);
            baseDao.update(vip);
            return true;
        }
        else
            return false;
    }

    public int getOrderNum(String vipName) {
        String sql="select count(*) from `orders` where vip_name='"+vipName+"'";
        return Integer.parseInt(String.valueOf(baseDao.querySQL(sql).get(0)));
    }

    public int getStudentNum(String vipName) {
        String sql="select count(*) from `orders` o,`order_classes` oc where oc.itorder_id=o.order_id and o.vip_name='"+vipName+"'";
        return Integer.parseInt(String.valueOf(baseDao.querySQL(sql).get(0)));
    }

    public double getOrderMoney(String vipName) {
        String sql="select coalesce(sum(money),0) from `orders` where vip_name='"+vipName+"'";
        return Double.parseDouble(String.valueOf(baseDao.querySQL(sql).get(0)));
    }

    public int getNumByState(String vipName, String state) {
        String sql="select count(*) from `orders` o,`order_classes` oc where oc.itorder_id=o.order_id and vip_name='"+vipName+"' and oc.state='"+state+"'";
        return Integer.parseInt(String.valueOf(baseDao.querySQL(sql).get(0)));
    }

    public Map<String,Integer> getLatestNum(String vipName) {
        String sql="select DATE_FORMAT(order_time,'%Y-%m'),count(*) count from `orders` o2 where DATE_FORMAT(order_time,'%Y-%m')>DATE_FORMAT(date_sub(curdate(), interval 12 month),'%Y-%m') and vip_name='"+ vipName +"' group by DATE_FORMAT(order_time,'%Y-%m');";
        Map<String,Integer> map=new HashMap();
        List result=baseDao.querySQL(sql);
        for(int i=0;i<result.size();i++){
            Object[] o=(Object[])result.get(i);
            map.put(String.valueOf(o[0]),Integer.valueOf(o[1].toString()));
        }
        System.out.println(map);
        return map;
    }

    public Map<String,Double> getLatestMoney(String vipName) {//maybe线上线下
        String sql="select DATE_FORMAT(order_time,'%Y-%m'),sum(money) s from `orders` o2 where DATE_FORMAT(order_time,'%Y-%m')>DATE_FORMAT(date_sub(curdate(), interval 12 month),'%Y-%m') and vip_name='"+ vipName +"' group by DATE_FORMAT(order_time,'%Y-%m');";
        Map<String,Double> map=new HashMap();
        List result=baseDao.querySQL(sql);
        for(int i=0;i<result.size();i++){
            Object[] o=(Object[])result.get(i);
            map.put(String.valueOf(o[0]),Double.valueOf(o[1].toString()));
        }
        System.out.println(map);
        return map;
    }

    /**
     * 不同课程类型
     * @param vipName
     * @return
     */
    public Map<String, Integer> getOrderType(String vipName) {
        String sql="select co.type,count(*) from orders o,order_classes oc,course co,class c where oc.itorder_id=o.order_id and oc.class_id=c.class_id and c.course_id=co.course_id and o.vip_name='"+vipName+"' group by co.type";
        Map<String,Integer> map=new HashMap();
        List result=baseDao.querySQL(sql);
        for(int i=0;i<result.size();i++){
            Object[] o=(Object[])result.get(i);
            map.put(String.valueOf(o[0]),Integer.valueOf(o[1].toString()));
        }
        return map;
    }

    /**
     * 订单机构地点
     * @param vipName
     * @return
     */
    public Map<String, Integer> getOrderLocation(String vipName) {
        String sql="select ins.location, count(*) from institution ins, orders o where ins.ins_id=o.ins_id and o.vip_name='"+vipName+"' group by ins.location;";
        Map<String,Integer> map=new HashMap<String, Integer>();
        List result=baseDao.querySQL(sql);
        for(int i=0;i<result.size();i++){
            Object[] o=(Object[])result.get(i);
            map.put(String.valueOf(o[0]),Integer.valueOf(o[1].toString()));
        }
        return map;
    }

    public Map<String, Integer> getOrderStatus(String vipName) {
        String sql="select oc.state, count(*) from order_classes oc, orders o where o.order_id=oc.itorder_id and o.vip_name='"+vipName+"' group by oc.state;";
        Map<String,Integer> map=new HashMap<String, Integer>();
        List result=baseDao.querySQL(sql);
        for(int i=0;i<result.size();i++){
            Object[] o=(Object[])result.get(i);
            map.put(String.valueOf(o[0]),Integer.valueOf(o[1].toString()));
        }
        return map;
    }

    public String getOKrate(String vipName) {
        String all_sql="select count(*) from order_classes oc, orders o where o.order_id=oc.itorder_id and o.vip_name='"+vipName+"';";
        String ok_sql="select count(*) from order_classes oc, orders o where o.order_id=oc.itorder_id and oc.state<>'已退订' and o.vip_name='"+vipName+"';";
        int all=Integer.parseInt(baseDao.querySQL(all_sql).get(0).toString());
        int ok=Integer.parseInt(baseDao.querySQL(ok_sql).get(0).toString());
        DecimalFormat df=new DecimalFormat("0.00");
        System.out.println(all+" "+ok);
        return df.format((float)(ok)/all*100);
    }

    public List<Integer> getGrades(String vipName) {
        String sql0_59="select count(*) from order_classes oc, orders o where o.order_id=oc.itorder_id and o.vip_name='"+vipName+"' and oc.grade between 1 and 59;";
        String sql60_74="select count(*) from order_classes oc, orders o where o.order_id=oc.itorder_id and o.vip_name='"+vipName+"' and oc.grade between 60 and 74;";
        String sql75_84="select count(*) from order_classes oc, orders o where o.order_id=oc.itorder_id and o.vip_name='"+vipName+"' and oc.grade between 75 and 84;";
        String sql85_100="select count(*) from order_classes oc, orders o where o.order_id=oc.itorder_id and o.vip_name='"+vipName+"' and oc.grade between 85 and 100;";
        List result=new ArrayList();
        result.add(Integer.parseInt(baseDao.querySQL(sql0_59).get(0).toString()));
        result.add(Integer.parseInt(baseDao.querySQL(sql60_74).get(0).toString()));
        result.add(Integer.parseInt(baseDao.querySQL(sql75_84).get(0).toString()));
        result.add(Integer.parseInt(baseDao.querySQL(sql85_100).get(0).toString()));
        return result;
    }

    public List<Integer> getOrderOnOffline(String vipName) {
        String onsql="select count(*) from orders where vip_name='"+vipName+"' and pay_type='线上';";
        String offsql="select count(*) from orders where vip_name='"+vipName+"' and pay_type='现金';";
        String tosql="select count(*) from orders where vip_name='"+vipName+"' and pay_type='待支付';";
        List result=new ArrayList();
        result.add(Integer.parseInt(baseDao.querySQL(onsql).get(0).toString()));
        result.add(Integer.parseInt(baseDao.querySQL(offsql).get(0).toString()));
        result.add(Integer.parseInt(baseDao.querySQL(tosql).get(0).toString()));
        return result;
    }

}
