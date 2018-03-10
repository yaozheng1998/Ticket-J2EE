package action;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.*;
import util.OrderClassVO;

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

    private String vipname;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getVipname() {

        return vipname;
    }

    public void setVipname(String vipname) {
        this.vipname = vipname;
    }

    /**
     * 获得用户的所有课程
     * @return
     */
    public String getMyClasses(){
        List<OrderClass> orderClassList=orderClassService.getClassFromVIPName(vipname);
        List<OrderClassVO> orderClassVOS=this.getVOFromMC(orderClassList);
        request.setAttribute("myClasses",orderClassVOS);
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
            Order order=orderService.getInfoByOrderId(orderClass.getOrder_id());
            Institution institution=institutionService.getInsById(order.getIns_id());
            Teacher teacher=teacherService.getTeacherById(classroom.getTeacher_id());
            orderClassVO.setOrder_id(orderClass.getOrder_id());
            orderClassVO.setOrder_time(order.getOrder_time());
            orderClassVO.setPay_type(order.getPay_type());
            orderClassVO.setIns_name(institution.getIns_name());
            orderClassVO.setClass_name(classroom.getClass_name());
            orderClassVO.setTeacher_name(teacher.getName());
            orderClassVO.setPrice(classroom.getPrice());
            orderClassVO.setStudent_name(orderClass.getReal_name());
            orderClassVO.setPhone(orderClass.getPhone());
            orderClassVO.setGrade(orderClass.getGrade());
            orderClassVO.setState(orderClass.getState());
            orderClassVOS.add(orderClassVO);
        }
        return orderClassVOS;
    }
}
