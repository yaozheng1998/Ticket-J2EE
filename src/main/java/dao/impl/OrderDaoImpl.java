package dao.impl;

import dao.BaseDao;
import dao.OrderDao;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.ToPayOrderVO;

import java.util.ArrayList;
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

    public long getNextNum() {
//        long current=baseDao.getTotalCount(Order.class);
////        System.out.print(current);
//        return current+1;
        String sql="select coalesce(max(`order_id`),0) from `orders`";
        return Integer.parseInt(String.valueOf(baseDao.querySQL(sql).get(0)))+1;
    }

    public List<ToPayOrderVO> getToPayOrders(String name) {
        String sql="select o.order_id,o.order_time,i.ins_name,i.location,o.money from `orders` o,`institution` i where o.ins_id=i.ins_id and o.pay_type='待支付' and o.vip_name="+name;
        List<Object[]> list=baseDao.querySQL(sql);
        return this.getTPO(list);
    }

    public List<ToPayOrderVO> getAllToPay() {
        String sql="select o.order_id,o.order_time,i.ins_name,i.location,o.money from `orders` o,`institution` i where o.ins_id=i.ins_id and o.pay_type='待支付' order by o.order_time asc";
        List<Object[]> list=baseDao.querySQL(sql);
        return this.getTPO(list);
    }

    public void removeOrder(int order_id) {
        String sql="delete from `orders` where order_id="+order_id;
        String sql2="delete from `order_classes` where itorder_id="+order_id;
        baseDao.excuteBySql(sql2);
        baseDao.excuteBySql(sql);

    }

    public void update(Order order) {
        baseDao.update(order);
    }

    private List<ToPayOrderVO> getTPO(List<Object[]> list){
        List<ToPayOrderVO> toPayOrderVOList=new ArrayList<ToPayOrderVO>();
        for(Object[] objects:list){
            ToPayOrderVO vo=new ToPayOrderVO();
            vo.setOrder_id((Integer) objects[0]);
            vo.setOrder_time(String.valueOf(objects[1]));
            vo.setIns_name(String.valueOf(objects[2]));
            vo.setIns_location(String.valueOf(objects[3]));
            vo.setMoney((Double)objects[4]);
            toPayOrderVOList.add(vo);
        }
        return toPayOrderVOList;

    }
}
