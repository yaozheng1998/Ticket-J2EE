package action;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.*;
import util.OrderClassVO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/16
 */
@Controller
public class InstitutionCheckAction extends BaseAction{
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private ClassService classService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderClassService orderClassService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

    private int course_id;

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String execute(){
        int ins_id=(Integer)request.getSession().getAttribute("ins_now");
        List<Object[]> openList=institutionService.getInsOrdersByState(ins_id,"待开班") ;
        List<Object[]> goingList=institutionService.getInsOrdersByState(ins_id,"进行中") ;
        List<Object[]> endList=institutionService.getInsOrdersByState(ins_id,"已结束") ;
        List<Object[]> divideList=institutionService.getInsOrdersByState(ins_id,"待分配") ;
        List<Course> courses=institutionService.getCoursesOfIns(ins_id);

        request.setAttribute("coursesINS",courses);
        request.setAttribute("openIO",this.getOrderClasses(openList));
        request.setAttribute("goIO",this.getOrderClasses(goingList));
        request.setAttribute("endIO",this.getOrderClasses(endList));
        request.setAttribute("divideIO",this.getOrderClasses(divideList));

        return "showInsOrd";
    }

    public String offlinePay(){
        int order_id=(int) orderService.getNextNum();
        Order order=new Order();
        order.setOrder_id(order_id);

        //不是会员
        if(request.getParameter("vipName").equals("")){
            order.setVip_name("非会员");
        }else{
            order.setVip_name(request.getParameter("vipName"));
        }
        order.setIns_id((Integer)request.getSession().getAttribute("ins_now"));
        order.setOrder_time(sdf.format(new Date()));

        /**
         * 设置！！
         */
        order.setMoney(0);
        order.setPay_type("现金");
        orderService.save(order);

        int studentCount=Integer.parseInt(request.getParameter("count"));
        for(int i=1;i<=studentCount;i++){
            OrderClass orderClass=new OrderClass();
            orderClass.setOrderclass_id((int) orderClassService.getNextId());
            orderClass.setItorder_id(order_id);
            orderClass.setClass_id(classService.getIdFromName(request.getParameter("c"+i)));
            orderClass.setReal_name(request.getParameter("n"+i));
            orderClass.setPhone(request.getParameter("p"+i));
            orderClass.setGrade(0);
            orderClass.setState("待开班");
            orderClassService.save(orderClass);
        }

        return "offline_pay_success";
    }

    public String getClassFromOne(){
        System.out.print("参数"+course_id);
        List<Classroom> list=classService.getClassOfOneCourse(course_id);
        System.out.println(list.size());
        request.getSession().setAttribute("Ucourses",list);
        return "CO";
    }

    private List<OrderClassVO> getOrderClasses(List<Object[]> objects){
        List<OrderClassVO> orderClassList=new ArrayList<OrderClassVO>();
        for(Object[] object:objects){
            int class_id=(Integer)object[2];
            Classroom classroom=classService.getInfoByClassId(class_id);
            Course course=courseService.getInfoByCourseId(classroom.getCourse_id_id());
            Teacher teacher=teacherService.getTeacherById(classroom.getTeacher_id());

            OrderClassVO orderClassVO=new OrderClassVO();
            orderClassVO.setOrder_id((Integer)object[1]);
            orderClassVO.setOrder_time(String.valueOf(object[9]));
            orderClassVO.setPay_type(String.valueOf(object[11]));
//            orderClassVO.setIns_name();
            orderClassVO.setClass_name(classroom.getClass_name());
            orderClassVO.setBegin_time(course.getStart_time());
            orderClassVO.setEnd_time(course.getEnd_time());
//            orderClassVO.setTeacher_name(classroom.getTeacher_id());
            orderClassVO.setPrice(classroom.getPrice());
            orderClassVO.setStudent_name(String.valueOf(object[3]));
            orderClassVO.setPhone(String.valueOf(object[4]));
            if(object[5]!=null) {
                orderClassVO.setGrade((Double) object[5]);
            }
//            orderClassVO.setState();
            orderClassVO.setRefund_time(String.valueOf(object[6]));
            orderClassVO.setRefund_money((Double)object[7]);
            orderClassVO.setOrder_classId((Integer)object[0]);
            orderClassVO.setVipName(String.valueOf(object[8]));
            orderClassVO.setTeacher_name(teacher.getName());
            orderClassList.add(orderClassVO);
        }
        return orderClassList;
    }

    private int order_id;
    private String name;
    private double grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {

        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getOrder_id() {

        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String loginGrade(){
        orderClassService.setGrade(order_id,name,grade);
        return "grade_success";
    }
}
