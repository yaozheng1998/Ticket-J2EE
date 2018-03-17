package service.impl;

import dao.ManageDao;
import model.Institution;
import model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ManageService;
import util.InsStaVO;
import util.SumPayVO;
import util.VIPStaVO;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/15
 */
@Service
@Transactional
public class ManageServiceImpl implements ManageService {
    @Autowired
    private ManageDao manageDao;

    public List<Institution> getAllIns() {
        return manageDao.getAllIns();
    }

    public List<Institution> getAllChanges() {
        return manageDao.getAllChanges();
    }

    public void approveRegis(int ins_id) {
        manageDao.approveRegis(ins_id);
    }

    public void approveInfo(int ins_id) {
        manageDao.approveInfo(ins_id);
    }

    public int getNextId() {
        return manageDao.getNextId();
    }

    public void save(Manager manager) {
        manageDao.save(manager);
    }

    public Manager getManagerByIns(int ins_id) {
        return manageDao.getManagerByIns(ins_id);
    }

    public void update(Manager manager) {
        manageDao.update(manager);
    }

    public List<SumPayVO> getToCal() {
        return manageDao.getToCal();
    }

    public double paySeven(int ins_id) {
        return manageDao.paySeven(ins_id);

    }

    public int getAllOrder() {
        return manageDao.getAllOrder();
    }

    public int getAllStudent() {
        return manageDao.getAllStudent();
    }

    public double getAllMoney() {
        return manageDao.getAllMoney();
    }

    public List<InsStaVO> getInsSta() {
        return manageDao.getInsSta();
    }

    public List<VIPStaVO> getVIPSta() {
        return manageDao.getVIPSta();
    }

    public List getVipMoneyList() {
        return manageDao.getVipMoneyList();
    }

    public List getVipList() {
        return manageDao.getVipList();
    }

    public List getInsList() {
        return manageDao.getInsList();
    }

    public List getInsMoneyList() {
        return manageDao.getInsMoneyList();
    }
}
