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
        baseDao.save(vip);
    }

}
