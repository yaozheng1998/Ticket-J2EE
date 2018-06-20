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
import java.util.Map;

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

    public void disapproveRegis(int ins_id) {
        manageDao.disapproveRegis(ins_id);
    }

    public void disapproveInfo(int ins_id) {
        manageDao.disapproveInfo(ins_id);
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

    public Map<String, String> averagePrice() {
        return manageDao.averagePrice();
    }

    public Map<String, String> getAboutLocation() {
        return manageDao.getAboutLocation();
    }

    public Map<String, String> getOkRateChange() {
        return manageDao.getOkRateChange();
    }

    public Map<String, String> getAboutClassType() {
        return manageDao.getAboutClassType();
    }

    public Map<String, Double> getMoneyChange() {
        return manageDao.getMoneyChange();
    }

    public List getTop10Money() {
        return manageDao.getTop10Money();
    }

    public List getTop10Num() {
        return manageDao.getTop10Num();
    }

    public Map<String, Integer> getStudentsChange() {
        return manageDao.getStudentsChange();
    }

    public Map<String, Integer> getInsChange() {
        return manageDao.getInsChange();
    }

    public Map<String, Integer> getInsLocation() {
        return manageDao.getInsLocation();
    }

    public List getTop10MoneyAll() {
        return manageDao.getTop10MoneyAll();
    }

    public List getTop10NumAll() {
        return manageDao.getTop10NumAll();
    }
}
