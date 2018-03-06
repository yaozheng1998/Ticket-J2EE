package service.impl;

import dao.BankcardDao;
import dao.VipDao;
import model.Bankcard;
import model.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.VipService;

/**
 * @Author YZ
 * @Date 2018/2/25
 */
@Service
public class VipServiceImpl implements VipService{
    @Autowired
    private VipDao vipDao;
    @Autowired
    private BankcardDao bankcardDao;


    public boolean isExist(String vipId) {
        return vipDao.checkExisted(vipId);
    }

    public void registerVip(Vip vip) {
        vipDao.save(vip);
        //这里还要添加银行卡信息
        String bankCardId=vip.getVip_bankCardId();
        Bankcard bankcard=new Bankcard();
        bankcard.setBankCardId(bankCardId);
        bankcard.setBalance(10000);
        bankcardDao.save(bankcard);
    }

    public String getVipId() {
        return vipDao.getId();
    }

    public boolean checkPassword(String vipId, String password) {
        return vipDao.checkPassword(vipId,password);
    }

    public void updateVip(Vip vip) {
        vipDao.update(vip);
        //更新银行卡信息
    }

    public Vip findVipById(String vipId) {
        return vipDao.find(vipId);
    }

    public boolean cancelVip(String vipId) {
        Vip vip=vipDao.find(vipId);
        //需要设置状态ENUM为Cancel
        return false;
    }
}
