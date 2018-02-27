package action;

import org.springframework.stereotype.Controller;

/**
 * @Author YZ
 * @Date 2018/2/28
 */
@Controller
public class MainAction extends BaseAction{
    public String execute(){
        return "main";
    }
}
