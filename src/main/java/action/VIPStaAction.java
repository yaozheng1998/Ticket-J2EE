package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.VipService;

/**
 * @Author YZ
 * @Date 2018/3/16
 */
@Controller
public class VIPStaAction extends BaseAction {
    @Autowired
    private VipService vipService;

    public String execute(){
        String vipId=String.valueOf(request.getSession().getAttribute("id"));
        request.setAttribute("ORDERNUM",vipService.getOrderNum(vipId));
        request.setAttribute("STUDENTNUM",vipService.getStudentNum(vipId));
        request.setAttribute("MONEY",vipService.getOrderMoney(vipId));
        request.setAttribute("DI",vipService.getNumByState(vipId,"待分配"));
        request.setAttribute("OP",vipService.getNumByState(vipId,"待开班"));
        request.setAttribute("GO",vipService.getNumByState(vipId,"进行中"));
        request.setAttribute("RE",vipService.getNumByState(vipId,"已退订"));
        request.setAttribute("EN",vipService.getNumByState(vipId,"已结束"));
        request.setAttribute("TP",vipService.getNumByState(vipId,"待支付"));
        return "vipSta";
    }
}
