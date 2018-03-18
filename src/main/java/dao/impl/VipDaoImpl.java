package dao.impl;

import dao.BaseDao;
import dao.VipDao;
import model.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.DecimalFormat;

/**
 * @Author YZ
 * @Date 2018/2/25
 */
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

}
