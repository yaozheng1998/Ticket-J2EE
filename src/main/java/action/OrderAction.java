package action;

import model.Order;
import model.OrderClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ClassService;
import service.OrderClassService;
import service.OrderService;
import service.VipService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author YZ
 * @Date 2018/3/12
 */
@Controller
public class OrderAction extends BaseAction{
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderClassService orderClassService;
    @Autowired
    private ClassService classService;
    @Autowired
    private VipService vipService;

    private String student_name;
    private String class_name;
    private String phone;
    private double money;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    int order_id;

    //class
    public String pay(){
        int oc_id=(int)orderClassService.getNextId();
        OrderClass orderClass=new OrderClass();
        orderClass.setOrderclass_id(oc_id);
        orderClass.setItorder_id(order_id);
        orderClass.setClass_id(classService.getIdFromName(class_name));
        orderClass.setReal_name(student_name);
        orderClass.setPhone(phone);
        orderClass.setState("待开班");
        orderClassService.save(orderClass);
        return "pay_success";
    }

    //order
    public String addOrder(){
        order_id=(int)orderService.getNextNum();
        String vip_name=(String) request.getSession().getAttribute("id");
        int ins_id= (Integer) request.getSession().getAttribute("ins");
        String date_time=sdf.format(new Date());
        String pay_type="线上";
        Order order=new Order();
        order.setOrder_id(order_id);
        order.setVip_name(vip_name);
        order.setIns_id(ins_id);
        order.setOrder_time(date_time);
        System.out.print("shenmejjh"+money);
        order.setMoney(money);
        order.setPay_type(pay_type);
        orderService.save(order);
        return SUCCESS;
    }


}
