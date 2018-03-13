package action;

import model.Order;
import model.OrderClass;
import model.Vip;
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

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
    int order_id;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public double getMoney() {

        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClass_name() {

        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getStudent_name() {

        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    //class
    public String pay(){
//        System.out.println("就一次吗");
        int oc_id=(int)orderClassService.getNextId();
        OrderClass orderClass=new OrderClass();
        orderClass.setOrderclass_id(oc_id);
        orderClass.setItorder_id((int)orderService.getNextNum()-1);
//        if(class_name==null||class_name.equals("")){
//            orderClass.setClass_id(-1);
//        }else {
            orderClass.setClass_id(classService.getIdFromName(class_name));
//        }
        orderClass.setReal_name(student_name);
        orderClass.setPhone(phone);
        orderClass.setState("待开班");
        orderClassService.save(orderClass);
        return "pay_success";
    }

    public String notChooseAddIntoClass(){
        int oc_id=(int)orderClassService.getNextId();
        OrderClass orderClass=new OrderClass();
        orderClass.setOrderclass_id(oc_id);
        orderClass.setItorder_id((int)orderService.getNextNum()-1);
        orderClass.setClass_id(classService.getIdFromName(class_name));
        orderClass.setReal_name(student_name);
        orderClass.setPhone(phone);
        orderClass.setState("待分配");
        orderClassService.save(orderClass);
        return "add_success";
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
        order.setMoney(money);
        order.setPay_type(pay_type);
        orderService.save(order);

        //bankcard
        Vip vip=vipService.findVipByName(vip_name);
        if(vip.getBalance()<money){
            return "fail";
        }
        vip.setBalance(vip.getBalance()-money);
        vipService.update(vip);

        return "order_success";
    }

    public String addtopayOrder(){
        order_id=(int)orderService.getNextNum();
        String vip_name=(String) request.getSession().getAttribute("id");
        int ins_id= (Integer) request.getSession().getAttribute("ins");
        String date_time=sdf.format(new Date());
        String pay_type="待支付";
        Order order=new Order();
        order.setOrder_id(order_id);
        order.setVip_name(vip_name);
        order.setIns_id(ins_id);
        order.setOrder_time(date_time);
        order.setMoney(money);
        order.setPay_type(pay_type);
        orderService.save(order);
        return "topayorder_success";
    }


}
