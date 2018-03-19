package action;

import model.Manager;
import model.Order;
import model.OrderClass;
import model.Vip;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.*;
import util.StudentClassVO;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private ManageService manageService;

    private String thedata;
    private String student_name;
    private String class_name;
    private String phone;
    private double money;
    private int sub;

    public int getSub() {
        return sub;
    }

    public void setSub(int sub) {
        this.sub = sub;
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//    int order_id;
//
//    public int getOrder_id() {
//        return order_id;
//    }
//
//    public void setOrder_id(int order_id) {
//        this.order_id = order_id;
//    }

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

    public Object getThedata() {
        return thedata;
    }

    public void setThedata(String thedata) {
        this.thedata = thedata;
    }

    private String thedata2;

    public String getThedata2() {
        return thedata2;
    }

    public void setThedata2(String thedata2) {
        this.thedata2 = thedata2;
    }

    //class选择班级 而已
    public String chooseOrderIntoClass(){

//        System.out.println("就一次吗");
        /**
         * 先增加班级，外键约束
         */
        int order_id=(int)orderService.getNextNum();
        Order order=new Order();
        order.setOrder_id(order_id);
        orderService.save(order);

        //取到object，转成list；加到。。
        System.out.println("对象"+thedata);

        List<StudentClassVO> voList=new ArrayList<StudentClassVO>();
        JSONArray jsonArray=JSONArray.fromObject(thedata);
        for(int j=0;j<jsonArray.size();j++){
            StudentClassVO vo=new StudentClassVO();
            JSONObject jsonObject=jsonArray.getJSONObject(j);
            String student_name=jsonObject.getString("student_name");
            String class_name=jsonObject.getString("class_name");
            String phone=jsonObject.getString("phone");
            vo.setStudent_name(student_name);
            vo.setClass_name(class_name);
            vo.setPhone(phone);
            voList.add(vo);
        }

        for(int i=0;i<voList.size();i++) {
            StudentClassVO vo=voList.get(i);
            int oc_id = (int) orderClassService.getNextId();
            OrderClass orderClass = new OrderClass();
            orderClass.setOrderclass_id(oc_id);
            orderClass.setItorder_id(order_id);
//        if(class_name==null||class_name.equals("")){
//            orderClass.setClass_id(-1);
//        }else {
            int class_id = classService.getIdFromName(vo.getClass_name());
            orderClass.setClass_id(class_id);
//        }
            classService.minus(class_id);
            orderClass.setReal_name(vo.getStudent_name());
            orderClass.setPhone(vo.getPhone());
            orderClass.setState("待开班");
            orderClassService.save(orderClass);
        }
        return "choose_success";

    }

    public String notChooseAddIntoClass(){
        /**
         * 这里不选班级，随机分配；先全部分配到第一个班，之后与数量相比较，再移入之后的班级；
         */
        int order_id=(int)orderService.getNextNum();
        Order order=new Order();
        order.setOrder_id(order_id);
        orderService.save(order);


        List<StudentClassVO> voList2=new ArrayList<StudentClassVO>();
        JSONArray jsonArray2=JSONArray.fromObject(thedata2);
        for(int j=0;j<jsonArray2.size();j++){
            StudentClassVO vo2=new StudentClassVO();
            JSONObject jsonObject=jsonArray2.getJSONObject(j);
            String student_name=jsonObject.getString("student_name");
            String class_name=jsonObject.getString("class_name");
            String phone=jsonObject.getString("phone");
            vo2.setStudent_name(student_name);
            vo2.setClass_name(class_name);
            vo2.setPhone(phone);
            voList2.add(vo2);
        }

        for(int k=0;k<voList2.size();k++){
            StudentClassVO vo=voList2.get(k);
            int oc_id=(int)orderClassService.getNextId();
            OrderClass orderClass=new OrderClass();
            orderClass.setOrderclass_id(oc_id);
            orderClass.setItorder_id(order_id);
            int class_id=classService.getIdFromName(vo.getClass_name());
            orderClass.setClass_id(class_id);
            orderClass.setReal_name(vo.getStudent_name());
            orderClass.setPhone(vo.getPhone());
            orderClass.setState("待分配");
            orderClassService.save(orderClass);
        }
        return "add_success";
    }

    //order付款
    public String pay(){
        int order_id=(int)orderService.getNextNum();
        String vip_name=(String) request.getSession().getAttribute("id");
        int ins_id= (Integer) request.getSession().getAttribute("ins");
        String date_time=sdf.format(new Date());
        String pay_type="线上";
//        Order order=new Order();
        Order order=orderService.getInfoByOrderId(order_id-1);
//        order.setOrder_id(order_id);
        order.setVip_name(vip_name);
        order.setIns_id(ins_id);
        order.setOrder_time(date_time);
        order.setMoney(money);
        order.setPay_type(pay_type);
        orderService.update(order);

        //bankcard
        Vip vip=vipService.findVipByName(vip_name);
        if(vip.getBalance()<money){
            return "fail";
        }
        vip.setBalance(vip.getBalance()-money);
        if(sub!=0){
            vip.setVipSubMoney(vip.getVipSubMoney()-sub);
        }
        vip.setVipPoint(vip.getVipPoint()+money);
        vip.setConsumeMoney(vip.getConsumeMoney()+money);
        vipService.update(vip);

        Manager manager=manageService.getManagerByIns(ins_id);
        manager.setIns_allmoney(manager.getIns_allmoney()+money);
        manageService.update(manager);

        return "pay_success";
    }

    /**
     * 下单未支付，设置15分钟的触发执行
     * @return
     */
    public String addtopayOrder(){
        int order_id=(int)orderService.getNextNum();
        String vip_name=(String) request.getSession().getAttribute("id");
        int ins_id= (Integer) request.getSession().getAttribute("ins");
        String date_time=sdf.format(new Date());
        String pay_type="待支付";
        Order order=orderService.getInfoByOrderId(order_id-1);
//        order.setOrder_id(order_id);
        order.setVip_name(vip_name);
        order.setIns_id(ins_id);
        order.setOrder_time(date_time);
        order.setMoney(money);
        order.setPay_type(pay_type);
        orderService.update(order);
        return "topayorder_success";
    }


}
