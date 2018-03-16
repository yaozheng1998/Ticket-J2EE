package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.InstitutionService;

/**
 * @Author YZ
 * @Date 2018/3/16
 */
@Controller
public class InsStaAction extends BaseAction {
    @Autowired
    private InstitutionService institutionService;

    public String execute(){
        return "insSta";
    }
}
