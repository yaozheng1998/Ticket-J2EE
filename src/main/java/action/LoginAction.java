package action;

import model.Institution;
import model.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.InstitutionService;
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
    @Autowired
    private InstitutionService institutionService;

    @Override
    public String execute(){
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        char first=name.charAt(0);
        if(first=='8'){
            //institution
            int id=Integer.parseInt(name);
            Institution institution=institutionService.getInsById(id);
            if(institutionService.whetherAct(id)){
                if(institutionService.checkPass(id,password)) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("insInfo", institution);
                    session.setAttribute("ins_now", id);
                    return "insLogin";
                }else{
                    return "relogin";
                }
            }else{
                return "relogin";
            }
        }else {
            Vip vip = vipService.findVipByName(name);
            if (vip == null) {
                System.out.println("用户名错误");
                return "relogin";
            } if(vip.getCancelDate()!=null&&vip.getCancelDate().equals("CANCEL")){
                System.out.println("此会员已注销！");
                return "relogin";
            } else{
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
