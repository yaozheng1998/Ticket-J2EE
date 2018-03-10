package dao.impl;

import dao.BaseDao;
import dao.OrderDao;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/9
 */
@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private BaseDao baseDao;


    public List<Order> getOrdersFromVIPName(String name) {
        return null;
    }

    public Order getInfoByOrderId(int orderId) {
        return (Order)baseDao.load(Order.class,orderId);
    }

    public void save(Order order) {
        baseDao.save(order);
    }
}
