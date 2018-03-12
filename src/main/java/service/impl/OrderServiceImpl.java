package service.impl;

import dao.OrderDao;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.OrderService;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/9
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;

    public List<Order> getOrdersFromVIPName(String name) {
        return orderDao.getOrdersFromVIPName(name);
    }

    public Order getInfoByOrderId(int orderId) {
        return orderDao.getInfoByOrderId(orderId);
    }

    public void save(Order order) {
        orderDao.save(order);
    }

    public long getNextNum() {
        return orderDao.getNextNum();
    }
}
