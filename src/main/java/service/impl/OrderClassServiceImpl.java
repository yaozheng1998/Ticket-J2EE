package service.impl;

import dao.OrderClassDao;
import model.OrderClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.OrderClassService;
import util.OrderClassVO;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/10
 */
@Service
@Transactional
public class OrderClassServiceImpl implements OrderClassService {
    @Autowired
    private OrderClassDao orderClassDao;

    public List<OrderClass> getClassFromVIPName(String name) {
        return orderClassDao.getClassFromVIPName(name);
    }

    public List<OrderClass> getClassByState(String name, String state) {
        return orderClassDao.getClassByState(name,state);
    }

    public void save(OrderClass orderClass) {
        orderClassDao.save(orderClass);
    }

    public long getNextId() {
        return orderClassDao.getNextId();
    }

    public void cancel(int order_classId,double money,String vipName) {
        orderClassDao.cancel(order_classId,money,vipName);
    }

    public void setGrade(int order_id, String name, double grade) {
        orderClassDao.setGrade(order_id, name, grade);
    }
}
