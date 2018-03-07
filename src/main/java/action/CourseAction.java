package action;

import model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.CourseService;
import service.InstitutionService;
import util.CourseVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/7
 */
@Controller
public class CourseAction extends BaseAction {
    @Autowired
    private CourseService courseService;
    @Autowired
    private InstitutionService institutionService;

    public String getCourses(){
        List<Course> courseList=courseService.getAllCourse();
        List<CourseVO> courseVOS=this.getVOFromCo(courseList);

        List<String> insList=institutionService.getAllInsName();
        List<String> locList=institutionService.getAllLocation();
        List<String> subList=courseService.getAllSubjects();
        request.setAttribute("allCourse",courseVOS);
        request.setAttribute("allIns",insList);
        request.setAttribute("allLoc",locList);
        request.setAttribute("allSub",subList);
        return "show_course";
    }
    public List<CourseVO> getVOFromCo(List<Course> list){
        List<CourseVO> courseVOS=new ArrayList<CourseVO>();
        for(Course course:list){
            CourseVO newVO=new CourseVO();
            newVO.setCourseId(course.getCourse_id());
            newVO.setInsName(institutionService.getInsById(course.getInstitution_id()).getIns_name());
            newVO.setInsLoc(institutionService.getInsById(course.getInstitution_id()).getLocation());
            newVO.setStartTime(course.getStart_time());
            newVO.setEndTime(course.getEnd_time());
            newVO.setTimes(course.getTimes());
            newVO.setBasicPrice(course.getBasic_price());
            newVO.setSubject(course.getType());
            courseVOS.add(newVO);
        }
        return courseVOS;
    }




}
