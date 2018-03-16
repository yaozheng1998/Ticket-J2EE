package action;

import model.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.InstitutionService;
import service.ManageService;
import util.ChangeVO;
import util.SumPayVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/15
 */
@Controller
public class ManageAction extends BaseAction{
    @Autowired
    private ManageService manageService;
    @Autowired
    private InstitutionService institutionService;

    private int ins_id;

    public int getIns_id() {
        return ins_id;
    }

    public void setIns_id(int ins_id) {
        this.ins_id = ins_id;
    }

    public String execute(){
        List<Institution> rigis=manageService.getAllIns();
        List<Institution> info=manageService.getAllChanges();
        System.out.print(info);
        request.setAttribute("infos",this.getCC(info));
        request.setAttribute("regis",rigis);
        return "showApproval";
    }

    private List<ChangeVO> getCC(List<Institution> info){
        List<ChangeVO> vos=new ArrayList<ChangeVO>();
        for(Institution institution:info){
            String oldName=institution.getIns_name();
            String oldLoc=institution.getLocation();
            String oldNum=String.valueOf(institution.getClassrooms());
            ChangeVO vo=new ChangeVO(oldName,oldLoc,oldNum);
            vo=ChangeVO.getALL(institution.getIns_id(),oldName,oldLoc,oldNum,institution.getChanges());
            vos.add(vo);
        }
        return vos;
    }

    public String approveRegis(){
        manageService.approveRegis(ins_id);
        return "app_regis";
    }

    public String approveInfo(){
        manageService.approveInfo(ins_id);
        return "app_info";
    }

    public String CalPay(){
        List<SumPayVO> list=manageService.getToCal();
        request.setAttribute("sumpay",list);
        return "sumpay";
    }

    public String sevenPay(){
        double i=manageService.paySeven(ins_id);
        institutionService.setMoney(ins_id,i);
        return "seven";
    }

}
