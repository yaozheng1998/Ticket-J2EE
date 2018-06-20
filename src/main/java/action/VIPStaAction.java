package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.VipService;
import util.LatestMonths;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author YZ
 * @Date 2018/3/16
 */
@Controller
public class VIPStaAction extends BaseAction {
    @Autowired
    private VipService vipService;

    public String execute(){
        List<String> months=LatestMonths.get12();
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

        request.setAttribute("OKRATE",vipService.getOKrate(vipId));
        request.setAttribute("MM", months);
        System.out.println(request.getAttribute("MM"));

        Map<String,Integer> numMap=vipService.getLatestNum(vipId);
        List numList=new ArrayList();
        for(int i=0;i<12;i++){
            if(numMap.containsKey(months.get(i).substring(1,8))){
                numList.add(numMap.get(months.get(i).substring(1,8)));
            }
            else{
                numList.add(0);
            }
        }
        System.out.println(numList);
        request.setAttribute("NUMLIST", numList);


        Map<String,Double> moneyMap=vipService.getLatestMoney(vipId);
        List moneyList=new ArrayList();
        for(int i=0;i<12;i++){
            if(moneyMap.containsKey(months.get(i).substring(1,8))){
                moneyList.add(moneyMap.get(months.get(i).substring(1,8)));
            }
            else{
                moneyList.add(0);
            }
        }
        request.setAttribute("MONEYLIST", moneyList);

        /**
         * 课程类型分析
         */
        Map<String,Integer> courseType=vipService.getOrderType(vipId);
        List<String> courses1=new ArrayList<String>(courseType.keySet());
        List<String> courses=new ArrayList<String>();
        for(int i=0;i<courses1.size();i++){
            courses.add("\""+courses1.get(i)+"\"");
        }
        List<Integer> courseNum=new ArrayList<Integer>(courseType.values());
        request.setAttribute("TYPE",courses);
        request.setAttribute("TYPENUM",courseNum);

        /**
         * 地域偏好分析
         */
        Map<String,Integer> location=vipService.getOrderLocation(vipId);
        request.setAttribute("LOCATION",location);

        /**
         * 已结束课程成绩比例分析
         */
        List<Integer> grades=vipService.getGrades(vipId);
        request.setAttribute("g1",grades.get(0));
        request.setAttribute("g2",grades.get(1));
        request.setAttribute("g3",grades.get(2));
        request.setAttribute("g4",grades.get(3));


        return "vipSta";
    }
}
