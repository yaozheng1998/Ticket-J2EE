package action;

import model.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.VipService;

import javax.servlet.http.HttpSession;

/**
 * @Author YZ
 * @Date 2018/2/28
 */
@Controller
public class LoginAction extends BaseAction{
    @Autowired
    private VipService vipService;

    @Override
    public String execute(){
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        char first=name.charAt(0);
        if(first=='8'){
            //institution
            return "relogin";
        }else {
            Vip vip = vipService.findVipByName(name);
            if (vip == null) {
                System.out.println("用户名错误");
                return "relogin";
            } else {
                if (vipService.whetherActive(name)) {
                    if (vipService.checkPassword(name, password)) {
                        System.out.println("会员信息准确");
                        HttpSession session = request.getSession(true);
                        session.setAttribute("vipInfo", vip);
                        session.setAttribute("id", name);
                        return "vipLogin";
                    } else {
                        System.out.println("密码错误");
                        return "relogin";
                    }
                } else {
                    System.out.println("请前去邮箱验证");
                    return "relogin";
                }
            }
        }
    }
}
