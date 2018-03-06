package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.VipService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author YZ
 * @Date 2018/3/6
 */
@Controller
public class CheckMailAction extends BaseAction{
    @Autowired
    private VipService vipService;

    @Override
    public String execute(){
        String name=request.getParameter("id");
        String token=request.getParameter("token");

        if(token.equals(vipService.findVipByName(name).getCode())) {
            vipService.setActive(name);
            return "succ";
        }
        return "fail";
    }
}