package dao;

import model.Order;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/4
 */
public interface OrderDao {
    /**
     * 根据用户名获得我的订单信息
     * @param name
     * @return
     */
    public List<Order> getOrdersFromVIPName(String name);

    /**
     * 根据订单编号获得信息
     * @param orderId
     * @return
     */
    public Order getInfoByOrderId(int orderId);

    /**
     * 新增一条订单
     * @param order
     */
    public void save(Order order);

    /**
     * 获得下一个订单编号
     * @return
     */
    public long getNextNum();
}
