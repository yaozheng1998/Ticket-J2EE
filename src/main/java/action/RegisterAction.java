package action;

import model.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.VipService;
import util.Sendmail;
import util.VipLevelEnum;

/**
 * @Author YZ
 * @Date 2018/3/5
 */
@Controller
public class RegisterAction extends BaseAction{
    @Autowired
    VipService vipService;

    @Override
    public String execute(){
        return "register";
    }


    /**
     * 发送验证码后与所填写验证码相比较
     * @return
     */
    public String sendValidate(){
        String rname=request.getParameter("r_name");
        String rpassword=request.getParameter("r_password");
        String rmail=request.getParameter("r_mailbox");
        System.out.println(rname);
        System.out.println(rmail);
//        String rvalid=request.getParameter("r_validate");
        String rbank=request.getParameter("r_bankcardId");
        String captha= Sendmail.send(rmail);

        Vip vip=new Vip();
        vip.setVipId(vipService.getVipId());
        vip.setVipName(rname);
        vip.setMailbox(rmail);
        vip.setVipPassword(rpassword);
        vip.setVip_bankCardId(rbank);
        vip.setConsumeMoney(0);
        vip.setVipPoint(0);
        vip.setVipLevel(VipLevelEnum.BRONZE.toString());
        vip.setCode(captha);

        request.getSession().setAttribute("id",vip.getVipId());
        return "sent";
    }

    public String compare(){
        String rvalid=request.getParameter("r_validate");
        String correct_code=(String)request.getSession().getAttribute("id");

        if(rvalid.equals(correct_code)){
            return "register_success";
        }else{
            request.getSession().setAttribute("id",null);
            return "register_error";//验证码错误
        }

    }
}
