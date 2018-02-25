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
        baseDao.save(vip);
    }

    public boolean checkExisted(String vipId) {
        if(this.find(vipId)!=null){
            return true;
        }
        return false;
    }

    public String getId() {
        long currentId=baseDao.getTotalCount(Vip.class);
        DecimalFormat df=new DecimalFormat("000000");
        String newId="V"+df.format(currentId+1);
        return newId;
    }

    public void update(Vip vip) {
        baseDao.update(vip);
    }

    public Vip find(String vipId) {
        Vip vip=(Vip)baseDao.load(Vip.class,vipId);
        return vip;
    }

    public boolean checkPassword(String vipId, String password) {
        Vip vip=this.find(vipId);
        if(vip.getVipPassword().equals(password)){
            return true;
        }
        return false;
    }
}
