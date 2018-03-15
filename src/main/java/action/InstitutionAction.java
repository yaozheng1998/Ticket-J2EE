package action;

import model.Institution;
import model.Teacher;
import model.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ClassService;
import service.InstitutionService;
import service.TeacherService;
import util.CourseClassVO;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/13
 */
@Controller
public class InstitutionAction extends BaseAction {
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ClassService classService;

    String teacherName;
    String rank;
    String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRank() {

        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTeacherName() {

        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }


    String insName;
    String insPassword;
    String insLoc;
    String insClass;

    public String getInsClass() {
        return insClass;
    }

    public void setInsClass(String insClass) {
        this.insClass = insClass;
    }

    public String getInsLoc() {

        return insLoc;
    }

    public void setInsLoc(String insLoc) {
        this.insLoc = insLoc;
    }

    public String getInsPassword() {

        return insPassword;
    }

    public void setInsPassword(String insPassword) {
        this.insPassword = insPassword;
    }

    public String getInsName() {
        return insName;

    }

    public void setInsName(String insName) {
        this.insName = insName;
    }

    public String addIns(){
        int insId=(int)institutionService.getNextId();
        HttpSession session=request.getSession(true);
        session.setAttribute("insId",insId);
        Institution institution=new Institution();
//        String insName=request.getParameter("ins_name");
//        String insPassword=request.getParameter("ins_password");
//        String insLoc=request.getParameter("ins_location");
//        String insClass=request.getParameter("ins_classnum");

        institution.setIns_id(insId);
        institution.setIns_name(insName);
        institution.setPassword(insPassword);
        institution.setLocation(insLoc);
        institution.setClassrooms(Integer.parseInt(insClass));
        institution.setState("未审核");
        institutionService.addIns(institution);

        return "addIns_success";
    }

    public String addTeachersIntoDB(){
        Teacher teacher=new Teacher();
        teacher.setIns_id((Integer)request.getSession().getAttribute("insId"));
        teacher.setTeacher_id((int)teacherService.getNextId());
        teacher.setName(teacherName);
        teacher.setRank(rank);
        teacher.setSubject(subject);
        teacherService.addTeacher(teacher);
        return "addTeacher_success";
    }

    public String showBasicInfo(){
        int id=(Integer) (request.getSession().getAttribute("ins_now"));
        //没有实质性内容
        List<Teacher> teacherList=teacherService.getTeachers(id);
        request.setAttribute("teachers",teacherList);
        return "basicinfo";
    }

    public String modifyIns(){
        String name=request.getParameter("insName");
        String loc=request.getParameter("insLocation");
        String num=request.getParameter("insNum");
        Institution institution=institutionService.getInfoById((Integer) request.getSession().getAttribute("ins_now"));
        institution.setIns_name(name);
        institution.setLocation(loc);
        institution.setClassrooms(Integer.parseInt(num));
        institutionService.update(institution);
        return "modifyIns_success";
    }

    /**
     * 得到机构的所有class
     * @return
     */
    public String showAllClasses(){
        int insId=(Integer) request.getSession().getAttribute("ins_now");
        List<CourseClassVO> courseClassVOList=classService.getClassOfIns(insId);
        List<Teacher> teacherList=teacherService.getTeachers(insId);
        request.setAttribute("insClasses",courseClassVOList);
        request.setAttribute("insTeachers",teacherList);

        return "showAllClass";
    }

}


