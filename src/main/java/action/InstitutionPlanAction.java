package action;

import model.Classroom;
import model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ClassService;
import service.CourseService;
import service.TeacherService;

/**
 * @Author YZ
 * @Date 2018/3/15
 */
@Controller
public class InstitutionPlanAction extends BaseAction{
    @Autowired
    CourseService courseService;
    @Autowired
    ClassService classService;
    @Autowired
    TeacherService teacherService;

    public String execute(){
        String course_name=request.getParameter("courseName");
        String start_time=request.getParameter("startTime");
        String end_time=request.getParameter("endTime");
        int times=Integer.parseInt(request.getParameter("times"));
        int price=Integer.parseInt(request.getParameter("bprice"));
        Course course=new Course();
        int id=courseService.getNextId();
        course.setCourse_id(id);
        course.setInstitution_id((Integer)request.getSession().getAttribute("ins_now"));
        course.setStart_time(start_time);
        course.setEnd_time(end_time);
        course.setBasic_price(price);
        course.setTimes(times);
        course.setType(course_name);
        courseService.save(course);

        int classCount=Integer.parseInt(request.getParameter("count"));
        for(int i=1;i<=classCount;i++){
            Classroom classroom=new Classroom();
            classroom.setClass_id(classService.getNextId());
            classroom.setClass_name(request.getParameter("cn"+i));
            classroom.setCourse_id(id);

//            System.out.println(request.getParameter("tn1"));
            classroom.setTeacher_id(teacherService.getIdByName(request.getParameter("tn"+i)));
            classroom.setPrice(Integer.parseInt(request.getParameter("p"+i)));
            classroom.setAll_num(Integer.parseInt(request.getParameter("n"+i)));
            classroom.setNow_num(0);
            classService.save(classroom);
        }

        return "new_plan";
    }


}
