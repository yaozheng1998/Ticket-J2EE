package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ManageService;

/**
 * @Author YZ
 * @Date 2018/3/16
 */
@Controller
public class ManagerStaAction extends BaseAction {
    @Autowired
    private ManageService manageService;

    public String execute(){
        return "manageSta";
    }
}
