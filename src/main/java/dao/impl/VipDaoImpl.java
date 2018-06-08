package dao.impl;

import dao.BaseDao;
import dao.VipDao;
import model.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
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

    public List<Integer> getLatestNum(String vipName) {
        String sql="select distinct DATE_FORMAT(order_time,'%Y-%m'),ifnull(A.count,0) from `orders` o1 left join (select count(*) count,DATE_FORMAT(order_time,'%Y-%m') from `orders` o2 where DATE_FORMAT(order_time,'%Y-%m')>DATE_FORMAT(date_sub(curdate(), interval 12 month),'%Y-%m') group by DATE_FORMAT(order_time,'%Y-%m')) as A on DATE_FORMAT(o1.order_time,'%Y-%m')=DATE_FORMAT(order_time,'%Y-%m')";
        System.out.println(baseDao.querySQL(sql));
        return null;
    }

    public List<Double> getLatestMoney(String vipName) {
        return null;
    }

    public Map<String, Integer> getOrderType(String vipName) {
        return null;
    }

    public Map<String, Integer> getOrderLocation(String vipName) {
        return null;
    }

    public Map<String, Integer> getOrderStatus(String vipName) {
        return null;
    }

    public double getOKrate(String vipName) {
        return 0;
    }

    public List<Integer> getGrades(String vipName) {
        return null;
    }

}
