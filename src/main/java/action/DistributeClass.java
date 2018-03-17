package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ClassService;
import service.OrderClassService;

/**
 * @Author YZ
 * @Date 2018/3/17
 */
@Controller
public class DistributeClass extends BaseAction{
    @Autowired
    private ClassService classService;
    @Autowired
    private OrderClassService orderClassService;

    public String execute(){

        return "distribute_success";

    }
}
