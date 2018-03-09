package service;

import model.Order;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/9
 */
public interface OrderService {
    /**
     * 根据用户名获得我的订单信息
     * @param name
     * @return
     */
    public List<Order> getOrdersFromVIPName(String name);
}
