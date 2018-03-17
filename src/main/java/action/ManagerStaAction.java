package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ManageService;
import util.InsStaVO;
import util.VIPStaVO;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/16
 */
@Controller
public class ManagerStaAction extends BaseAction {
    @Autowired
    private ManageService manageService;

    public String execute(){
        List<VIPStaVO> vipStaVOS=manageService.getVIPSta();
        List<InsStaVO> insStaVOS=manageService.getInsSta();
        request.setAttribute("MORDER",manageService.getAllOrder());
        request.setAttribute("MSTUDENT",manageService.getAllStudent());
        request.setAttribute("MMONEY",manageService.getAllMoney());
        request.setAttribute("INSTABLE",insStaVOS);
        request.setAttribute("VIPTABLE",vipStaVOS);
        request.setAttribute("insx",manageService.getInsList());
        request.setAttribute("insy",manageService.getInsMoneyList());
        request.setAttribute("vipx",manageService.getVipList());
        request.setAttribute("vipy",manageService.getVipMoneyList());
        return "manageSta";
    }
}
