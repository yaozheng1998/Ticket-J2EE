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
        Vip vip=vipService.findVipByName(vipId);
        request.setAttribute("vip",vip);
        return SUCCESS;
    }

    public String cancelVIP(){
        String vipId=String.valueOf(request.getSession().getAttribute("id"));
        vipService.cancelVIP(vipId);
        return "cancel";
    }

    public String convertVIP(){
        String vipId=String.valueOf(request.getSession().getAttribute("id"));
        if(vipService.convert(vipId)){
//            System.out.println("zxxx");
            Vip vip=vipService.findVipByName(vipId);
            request.setAttribute("vip",vip);
            return "convert";
        }else{
            return "fail";
        }
    }

    public String modifyVIP(){
        String vipId=String.valueOf(request.getSession().getAttribute("id"));
        String newBankcard=request.getParameter("bankCardId");
        Vip vip=vipService.findVipByName(vipId);
        vip.setVip_bankCardId(newBankcard);
        vipService.update(vip);
        request.setAttribute("vip",vip);
        return "modify";
    }
}
