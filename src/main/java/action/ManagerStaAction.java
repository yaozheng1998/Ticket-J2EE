package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ManageService;
import util.InsStaVO;
import util.LatestMonths;
import util.VIPStaVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author YZ
 * @Date 2018/3/16
 */
@Controller
public class ManagerStaAction extends BaseAction {
    @Autowired
    private ManageService manageService;

    public String execute(){
        List<String> months= LatestMonths.get12();
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

        request.setAttribute("M",months);

        Map<String,String> averagePrice=manageService.averagePrice();
        List list=new ArrayList();
        for(int i=0;i<12;i++){
            if(averagePrice.containsKey(months.get(i).substring(1,8))){
                list.add(Double.parseDouble(averagePrice.get(months.get(i).substring(1,8))));
            }
            else{
                list.add(0);
            }
        }
        request.setAttribute("AVERAGE", list);

        Map<String,String> ok=manageService.getOkRateChange();
        List oklist=new ArrayList();
        for(int i=0;i<12;i++){
            if(ok.containsKey(months.get(i).substring(1,8))){
                oklist.add(Double.parseDouble(ok.get(months.get(i).substring(1,8))));
            }
            else{
                oklist.add(0);
            }
        }
        request.setAttribute("OK", oklist);

        Map<String,String> location=manageService.getAboutLocation();
        request.setAttribute("LOCATION1",location);

        List topMoneyMonth=manageService.getTop10Money();
        request.setAttribute("tm",topMoneyMonth);
        List topNumMonth=manageService.getTop10Num();
        request.setAttribute("tn",topNumMonth);
        List topMoneyAll=manageService.getTop10MoneyAll();
        request.setAttribute("tma",topMoneyAll);
        List topNumAll=manageService.getTop10NumAll();
        request.setAttribute("tna",topNumAll);

        Map<String,String> classType=manageService.getAboutClassType();
        request.setAttribute("TYPE",classType);
        List<String> classes=new ArrayList<String>(classType.keySet());
        List<String> courses=new ArrayList<String>();
        for(int i=0;i<classes.size();i++){
            courses.add("\""+classes.get(i)+"\"");
        }
        List<String> values=new ArrayList<String>(classType.values());
        List nums=new ArrayList();
        List moneys=new ArrayList();
        for(int i=0;i<values.size();i++){
            String[] s=values.get(i).split("-");
            nums.add(Integer.parseInt(s[0]));
            moneys.add(Double.parseDouble(s[1]));
        }
//        request.setAttribute("TYPE",courses);
        request.setAttribute("TYPENUM",nums);
        request.setAttribute("TYPEMONEY",moneys);

        Map<String,Integer> sc=manageService.getStudentsChange();
        List listsc=new ArrayList();
        for(int i=0;i<12;i++){
            if(sc.containsKey(months.get(i).substring(1,8))){
                listsc.add(sc.get(months.get(i).substring(1,8)));
            }
            else{
                listsc.add(0);
            }
        }
        request.setAttribute("STUDENT", listsc);

        Map<String,Integer> ic=manageService.getInsChange();
        List listic=new ArrayList();
        for(int i=0;i<12;i++){
            if(ic.containsKey(months.get(i).substring(1,8))){
                listic.add(ic.get(months.get(i).substring(1,8)));
            }
            else{
                listic.add(0);
            }
        }
        request.setAttribute("INS", listic);

        Map<String,Double> mc=manageService.getMoneyChange();
        List listmc=new ArrayList();
        for(int i=0;i<12;i++){
            if(mc.containsKey(months.get(i).substring(1,8))){
                listmc.add(mc.get(months.get(i).substring(1,8)));
            }
            else{
                listmc.add(0);
            }
        }
        request.setAttribute("MC", listmc);

        Map<String,Integer> insLo=manageService.getInsLocation();
        request.setAttribute("insLO",insLo);

        return "manageSta";
    }
}
