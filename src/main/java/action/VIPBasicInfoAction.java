package action;

import model.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.VipService;

/**
 * @Author YZ
 * @Date 2018/2/28
 */
@Controller
public class VIPBasicInfoAction extends BaseAction{
    @Autowired
    VipService vipService;

    public String showBasicInfo(){
        String vipId=String.valueOf(request.getSession().getAttribute("id"));
        Vip vip=vipService.findVipById(vipId);
        request.setAttribute("vip",vip);
        return SUCCESS;
    }
}
