package action;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.*;
import util.OrderClassVO;
import util.ToPayOrderVO;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/10
 */
@Controller
public class VIPClassAction extends BaseAction{
    @Autowired
    private OrderClassService orderClassService;
    @Autowired
    private ClassService classService;
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CourseService courseService;

//    private String vipname;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private int order_classId;

    public int getOrder_classId() {
        return order_classId;
    }

    public void setOrder_classId(int order_classId) {
        this.order_classId = order_classId;
    }

    private double money;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    private String vipName;

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    /**
     * 获得用户的所有课程
     * @return
     */
    @Override
    public String execute(){
        HttpSession session = request.getSession(true);
        List<OrderClass> orderClassList=orderClassService.getClassFromVIPName("'"+(String)session.getAttribute("id")+"'");
        List<OrderClassVO> orderClassVOS=this.getVOFromMC(orderClassList);
        request.setAttribute("myClasses",orderClassVOS);

        List<OrderClass> todo=orderClassService.getClassByState("'"+(String)session.getAttribute("id")+"'","'待开班'");
        List<OrderClassVO> todoVOS=this.getVOFromMC(todo);
        request.setAttribute("todoClass",todoVOS);

        List<OrderClass> going=orderClassService.getClassByState("'"+(String)session.getAttribute("id")+"'","'进行中'");
        List<OrderClassVO> goingVOS=this.getVOFromMC(going);
        request.setAttribute("goingClass",goingVOS);

        List<OrderClass> refund=orderClassService.getClassByState("'"+(String)session.getAttribute("id")+"'","'已退订'");
        List<OrderClassVO> refundVOS=this.getVOFromMC(refund);
        request.setAttribute("refundClass",refundVOS);

        List<OrderClass> end=orderClassService.getClassByState("'"+(String)session.getAttribute("id")+"'","'已结束'");
        List<OrderClassVO> endVOS=this.getVOFromMC(end);
        request.setAttribute("endClass",endVOS);

        List<OrderClass> divide=orderClassService.getClassByState("'"+(String)session.getAttribute("id")+"'","'待分配'");
        List<OrderClassVO> divideVOS=this.getVOFromMC(divide);
        request.setAttribute("divideClass",divideVOS);

        List<ToPayOrderVO> toPayOrderVOList=orderService.getToPayOrders("'"+(String)session.getAttribute("id")+"'");
        request.setAttribute("topay",toPayOrderVOList);
        session.setAttribute("session_topay",toPayOrderVOList);

        return "show_my_classes";
    }

    /**
     * 为了获得其他表的信息
     * @param list
     * @return
     */
    public List<OrderClassVO> getVOFromMC(List<OrderClass> list){
        List<OrderClassVO> orderClassVOS=new ArrayList<OrderClassVO>();
        for(OrderClass orderClass:list){
            OrderClassVO orderClassVO=new OrderClassVO();
            Classroom classroom=classService.getInfoByClassId(orderClass.getClass_id());
            Order order=orderService.getInfoByOrderId(orderClass.getItorder_id());
            Institution institution=institutionService.getInsById(order.getIns_id());
            Teacher teacher=teacherService.getTeacherById(classroom.getTeacher_id());
            Course course=courseService.getInfoByCourseId(classroom.getCourse_id_id());
            orderClassVO.setOrder_id(orderClass.getItorder_id());
            orderClassVO.setOrder_time(order.getOrder_time());
            orderClassVO.setPay_type(order.getPay_type());
            orderClassVO.setIns_name(institution.getIns_name());
            orderClassVO.setClass_name(classroom.getClass_name());
            orderClassVO.setBegin_time(course.getStart_time());
            orderClassVO.setEnd_time(course.getEnd_time());
            orderClassVO.setTeacher_name(teacher.getName());
            orderClassVO.setPrice(classroom.getPrice());
            orderClassVO.setStudent_name(orderClass.getReal_name());
            orderClassVO.setPhone(orderClass.getPhone());
            orderClassVO.setGrade(orderClass.getGrade());
            orderClassVO.setState(orderClass.getState());
            orderClassVO.setRefund_time(orderClass.getRefund_time());
            orderClassVO.setRefund_money(orderClass.getRefund_money());
            orderClassVO.setOrder_classId(orderClass.getOrderclass_id());
            orderClassVOS.add(orderClassVO);
        }
        return orderClassVOS;
    }

    public String cancelClass(){
        //退订，积分下降，退款
        orderClassService.addNum(order_classId);
        System.out.println(order_classId+"  "+money+"  "+vipName);
        orderClassService.cancel(order_classId,money,vipName);
        return "cancelSuccess";
    }


    private int order_id;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    //取消未支付订单
    public String retClass(){
        orderService.deleteOrder(order_id);
        return "del_success";
    }

}
