package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.CourseService;

/**
 * @Author YZ
 * @Date 2018/3/7
 */
@Controller
public class CourseAction extends BaseAction {
    @Autowired
    private CourseService courseService;



}
