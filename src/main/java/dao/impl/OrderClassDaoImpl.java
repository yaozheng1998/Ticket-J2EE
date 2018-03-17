package dao.impl;

import dao.BaseDao;
import dao.OrderClassDao;
import model.OrderClass;
import model.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.OrderClassVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/10
 */
@Repository
public class OrderClassDaoImpl implements OrderClassDao {
    @Autowired
    private BaseDao baseDao;

    public List<OrderClass> getClassFromVIPName(String name) {
        String sql="select oc.orderclass_id,oc.itorder_id,oc.class_id,oc.real_name,oc.phone,oc.grade,oc.state,oc.refund_time,oc.refund_money from `order_classes` oc,`orders` o where o.order_id=oc.itorder_id and o.pay_type!='待支付' and o.vip_name="+name;
        List<Object[]> classes=baseDao.querySQL(sql);
        return this.getOrderClasses(classes);
    }

    public List<OrderClass> getClassByState(String name,String state) {
        String sql="select oc.orderclass_id,oc.itorder_id,oc.class_id,oc.real_name,oc.phone,oc.grade,oc.state,oc.refund_time,oc.refund_money from `order_classes` oc,`orders` o where o.order_id=oc.itorder_id and o.pay_type!='待支付' and o.vip_name="+name+" and oc.state="+state;
        List<Object[]> classes=baseDao.querySQL(sql);
        return this.getOrderClasses(classes);
    }

    public void save(OrderClass orderClass) {
        System.out.println(orderClass.getItorder_id()+"dsfghc");
        baseDao.save(orderClass);
    }

    public long getNextId() {
        String sql="select max(`orderclass_id`) from `order_classes`";
//        long current=baseDao.getTotalCount(OrderClass.class);
//        System.out.print("逻辑层的"+current);
        return (Integer)baseDao.querySQL(sql).get(0)+1;
    }

    public void cancel(int order_classId,double money,String vipName) {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d=sdf.format(date);
        String sql="update `order_classes` set state='已退订',refund_time='"+d+"',refund_money="+money+" where orderclass_id="+order_classId;
        baseDao.excuteBySql(sql);

        Vip vip=(Vip)baseDao.load(Vip.class,vipName);
        vip.setBalance(vip.getBalance()+money);
        vip.setVipPoint(vip.getVipPoint()-money);
        vip.setConsumeMoney(vip.getConsumeMoney()-money);
        baseDao.update(vip);

//        baseDao.delete(OrderClass.class,order_classId);

    }

    public void setGrade(int order_id, String name, double grade) {
        String sql="update `order_classes` set grade="+grade+" where itorder_id="+order_id+" and real_name='"+name+"'";
        baseDao.excuteBySql(sql);
    }

    private List<OrderClass> getOrderClasses(List<Object[]> objects){
        List<OrderClass> orderClassList=new ArrayList<OrderClass>();
        for(Object[] object:objects){
            OrderClass orderClass=new OrderClass();
            orderClass.setOrderclass_id((Integer)object[0]);
            orderClass.setItorder_id((Integer)object[1]);
            orderClass.setClass_id((Integer)object[2]);
            orderClass.setReal_name(String.valueOf(object[3]));
            orderClass.setPhone(String.valueOf(object[4]));
            if(object[5]!=null){
                orderClass.setGrade((Double)object[5]);
            }
            orderClass.setState(String.valueOf(object[6]));
            orderClass.setRefund_time(String.valueOf(object[7]));
            orderClass.setRefund_money((Double)object[8]);
            orderClassList.add(orderClass);
        }
        return orderClassList;
    }
}
