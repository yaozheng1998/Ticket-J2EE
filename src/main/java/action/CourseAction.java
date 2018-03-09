package action;

import model.Classroom;
import model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ClassService;
import service.CourseService;
import service.InstitutionService;
import service.TeacherService;
import util.ClassroomVO;
import util.CourseVO;

import javax.servlet.http.HttpSession;
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
    private ClassService classService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private InstitutionService institutionService;

    //courseId需要前端传进来
    private int courseId;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * 获得课程展示页面的信息
     * @return
     */
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

    /**
     * 为了获得ins name等信息
     * @param list
     * @return
     */
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

    /**
     * 展示某个课程的分班信息
     */
    public String getClassFromOneCourse(){
        List<Classroom> classroomList=classService.getClassOfOneCourse(courseId);
        List<ClassroomVO> classroomVOS=this.getVOFromCl(classroomList);
//        System.out.println("logic"+classroomVOS.size());
        HttpSession session = request.getSession(true);
        session.setAttribute("allClass",classroomVOS);
        return "show_class";
    }

    public List<ClassroomVO> getVOFromCl(List<Classroom> list){
        List<ClassroomVO> classroomVOS=new ArrayList<ClassroomVO>();
        for(Classroom classroom:list){
            ClassroomVO newVO=new ClassroomVO();
            newVO.setClassId(classroom.getClass_id());
            newVO.setAllNum(classroom.getAll_num());
            newVO.setName(classroom.getClass_name());
            newVO.setPrice(classroom.getPrice());
            newVO.setTeacherName(teacherService.getTeacherById(classroom.getTeacher_id()).getName());
            newVO.setTeacherRank(teacherService.getTeacherById(classroom.getTeacher_id()).getRank());
            classroomVOS.add(newVO);
        }
        return classroomVOS;
    }




}
