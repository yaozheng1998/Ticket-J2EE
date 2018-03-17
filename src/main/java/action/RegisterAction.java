package action;

import model.Vip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.VipService;
import util.Sendmail;
import util.VipLevelEnum;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author YZ
 * @Date 2018/3/5
 */
@Controller
public class RegisterAction extends BaseAction{
    @Autowired
    private VipService vipService;

    //直接注册，然后点击邮件链接以完成验证
    @Override
    public String execute(){
        return "showregister";
    }

    public String register_submit(){
        String rname=request.getParameter("r_name");
        String rpassword=request.getParameter("r_password");
        String rmail=request.getParameter("r_mailbox");
        String rbank=request.getParameter("r_bankcardId");

        //产生10位验证码
        Random r = new Random();
        StringBuffer captcha1 = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            captcha1.append(r.nextInt(9)+"");
        }
        String captcha = new String(captcha1);

        Vip vip=new Vip();
        vip.setVipName(rname);
        vip.setMailbox(rmail);
        vip.setVipPassword(rpassword);
        vip.setVip_bankCardId(rbank);
        vip.setConsumeMoney(0);
        vip.setVipPoint(0);
        vip.setVipLevel("青铜");
        vip.setBalance(10000);
        vip.setCode(captcha);

        vipService.registerVip(vip);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        StringBuffer sb=new StringBuffer("<div style=\"padding:24px 20px;\">您好，"+rmail+"<br/><br/>Training是一款\"课程购买\"产品<br/><br/>请点击下面链接激活账号，链接只能使用一次，请尽快激活！</br>");
        sb.append("<a href=\"http://localhost:8880/emailcheck.action?op=activate&id=");
        sb.append(rname);
        sb.append("&token=");
        sb.append(captcha);
        sb.append("\">http://localhost:8880/emailcheck.action?op=activate&id=");
        sb.append(rname);
        sb.append("&token=");
        sb.append(captcha);
        sb.append("</a>"+"<br/>如果以上链接无法点击，请把上面网页地址复制到浏览器地址栏中打开<br/>"+sdf.format(new Date())+ "</div></div>" );

        Sendmail.send(rmail,sb.toString());
        return "register_done";
    }
}
