package service;

import model.Order;
import util.ToPayOrderVO;

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

    /**
     * 得到用户的所有待支付订单
     * @param name
     * @return
     */
    public List<ToPayOrderVO> getToPayOrders(String name);

    /**
     * 得到数据库中所有的未支付订单
     * @return
     */
    public List<ToPayOrderVO> getAllToPay();

    /**
     * 清除过期的未支付订单
     */
    public void cancelOrders();

    /**
     * 删除某一条订单
     * @param order_id
     */
    public void deleteOrder(int order_id);

    /**
     * 更新order
     * @param order
     */
    public void update(Order order);
}
