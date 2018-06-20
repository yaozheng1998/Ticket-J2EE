package service.impl;

import dao.VipDao;
import model.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.VipService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author YZ
 * @Date 2018/2/25
 */
@Service
@Transactional
public class VipServiceImpl implements VipService{
    @Autowired
    private VipDao vipDao;

    public boolean whetherActive(String vipName) {
        if(findVipByName(vipName).getActivateDate()==null){
            return false;
        }
        return true;
    }

    public boolean isExist(String vipName) {
        return vipDao.checkExisted(vipName);
    }

    public void registerVip(Vip vip) {
        //这里还要添加银行卡信息
//        String bankCardId=vip.getVip_bankCardId();
//        Bankcard bankcard=new Bankcard();
//        bankcard.setBankCardId(bankCardId);
//        bankcard.setBalance(10000);
//        bankcardDao.save(bankcard);
        vipDao.save(vip);
    }

    public boolean checkPassword(String vipName, String password) {
        return vipDao.checkPassword(vipName,password);
    }

    public void updateVip(Vip vip) {
        vipDao.update(vip);
        //更新银行卡信息
    }

    public Vip findVipByName(String vipName) {
        return vipDao.find(vipName);
    }

//    public boolean cancelVip(String vipName) {
//        Vip vip=vipDao.find(vipName);
//        //需要设置状态ENUM为Cancel
//        return false;
//    }

    public void setActive(String name) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Vip vip=findVipByName(name);
        vip.setActivateDate(sdf.format(new Date()));
        vipDao.update(vip);
    }

    public void cancelVIP(String vipName) {
        vipDao.cancelVIP(vipName);
    }

    public boolean convert(String vipName) {
        if(vipDao.convert(vipName)){
            return true;
        }
        else{
            return false;
        }
    }

    public void update(Vip vip) {
        vipDao.update(vip);
    }

    public int getOrderNum(String vipName) {
        return vipDao.getOrderNum(vipName);
    }

    public int getStudentNum(String vipName) {
        return vipDao.getStudentNum(vipName);
    }

    public double getOrderMoney(String vipName) {
        return vipDao.getOrderMoney(vipName);
    }

    public int getNumByState(String vipName, String state) {
        return vipDao.getNumByState(vipName, state);
    }

    public Map<String, Integer> getLatestNum(String vipName) {
        return vipDao.getLatestNum(vipName);
    }

    public Map<String, Double> getLatestMoney(String vipName) {
        return vipDao.getLatestMoney(vipName);
    }

    public Map<String, Integer> getOrderType(String vipName) {
        return vipDao.getOrderType(vipName);
    }

    public Map<String, Integer> getOrderLocation(String vipName) {
        return vipDao.getOrderLocation(vipName);
    }

    public Map<String, Integer> getOrderStatus(String vipName) {
        return vipDao.getOrderStatus(vipName);
    }

    public String getOKrate(String vipName) {
        return vipDao.getOKrate(vipName);
    }

    public List<Integer> getGrades(String vipName) {
        return vipDao.getGrades(vipName);
    }

    public List<Integer> getOrderOnOffline(String vipName) {
        return vipDao.getOrderOnOffline(vipName);
    }
}
