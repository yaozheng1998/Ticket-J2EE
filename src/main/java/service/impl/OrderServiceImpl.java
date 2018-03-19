package service.impl;

import dao.OrderDao;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.OrderService;
import util.ToPayOrderVO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author YZ
 * @Date 2018/3/9
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;

    public static final long EFFTIVE_TIME=4*60*1000;
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

    public List<ToPayOrderVO> getToPayOrders(String name) {
        return orderDao.getToPayOrders(name);
    }

    public List<ToPayOrderVO> getAllToPay() {
        return orderDao.getAllToPay();
    }

    public void cancelOrders() {
        List<ToPayOrderVO> list=orderDao.getAllToPay();
//        Queue<ToPayOrderVO> queue=new LinkedList<ToPayOrderVO>();
//        if(!list.isEmpty()){
//            for(ToPayOrderVO vo:list){
//                queue.offer(vo);
//            }
//        }
//        ToPayOrderVO pvo=queue.peek();
//        while(pvo!=null){
//            Long diff= null;
//            try {
//                diff = checkOrder(pvo);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            if(diff!=null&&diff>=EFFTIVE_TIME){
//                queue.poll();
//                pvo=queue.peek();
//            }else if(diff<EFFTIVE_TIME){
//                try {
//                    Thread.sleep(EFFTIVE_TIME-diff);
//                } catch (InterruptedException e) {
//                    System.out.println("CancelOrderJob.checkOrder定时任务出现问题");
//                    e.printStackTrace();
//                }
//            }
//
//        }
        for(int i=0;i<list.size();i++){
            try {
                if(checkOrder(list.get(i))>=EFFTIVE_TIME){
                    orderDao.removeOrder(list.get(i).getOrder_id());
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteOrder(int order_id) {
        orderDao.removeOrder(order_id);
    }

    public void update(Order order) {
        orderDao.update(order);
    }

    /**
     * 获取某个订单下单时间和现在的时间差
     * @param vo
     * @return
     * @throws ParseException
     */
    public Long checkOrder(ToPayOrderVO vo) throws ParseException {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long diff=null;
        if(vo!=null){
            Date createTime=vo.getOrder_time();
            diff=sdf.parse(sdf.format(date)).getTime()-createTime.getTime();
        }
        return diff;
    }
}
