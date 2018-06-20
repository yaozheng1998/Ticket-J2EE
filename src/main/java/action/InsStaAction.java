package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.InstitutionService;
import util.LatestMonths;

import java.util.*;

/**
 * @Author YZ
 * @Date 2018/3/16
 */
@Controller
public class InsStaAction extends BaseAction {
    @Autowired
    private InstitutionService institutionService;

    public String execute(){
        List<String> months= LatestMonths.get12();
        int ins_id=(Integer)request.getSession().getAttribute("ins_now");
        request.setAttribute("ins_ORDERNUM",institutionService.getOrderNum(ins_id));
        request.setAttribute("ins_STUDENTNUM",institutionService.getStudentNum(ins_id));
        request.setAttribute("ins_MONEY",institutionService.getMoney(ins_id));
        request.setAttribute("ins_DI",institutionService.getNumByState(ins_id,"待分配"));
        request.setAttribute("ins_OP",institutionService.getNumByState(ins_id,"待开班"));
        request.setAttribute("ins_GO",institutionService.getNumByState(ins_id,"进行中"));
        request.setAttribute("ins_RE",institutionService.getNumByState(ins_id,"已退订"));
        request.setAttribute("ins_EN",institutionService.getNumByState(ins_id,"已结束"));
        request.setAttribute("ins_TP",institutionService.getNumByState(ins_id,"待支付"));

        HashMap map=institutionService.getNumByTeacher(ins_id);
        List t=new ArrayList<String>();
        List n=new ArrayList<Integer>();
        Set set=map.keySet();
        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            String key=it.next();
            t.add("'"+key+"'");
            n.add(map.get(key));
        }
//        String[] tarray=new String[t.size()];
//        int[] narray=new int[n.size()];
//        String[] too= (String[]) t.toArray(tarray);
//        for(int j=0;j<n.size();j++){
//            narray[j]= (Integer) n.get(j);
//        }
        request.setAttribute("barx",t);
        request.setAttribute("bary",n);

        request.setAttribute("months",months);

        Map<String,Integer> map1=institutionService.getOrderNumChange(ins_id);
        Map<String,Double> map2=institutionService.getOrderMoneyChange(ins_id);
        Map<String,Integer> map3=institutionService.getStudentNumChange(ins_id);
        Map<String,String> map4=institutionService.getOKRateChange(ins_id);
        Map<String,String> map5=institutionService.getAveragePrice(ins_id);
        Map<String,String> map6=institutionService.getBuyMethod(ins_id);
        List o1=new ArrayList();
        List o2=new ArrayList();
        List o3=new ArrayList();
        List o4=new ArrayList();
        List o5=new ArrayList();
        List o6=new ArrayList();
        for(int i=0;i<12;i++){
            if(map1.containsKey(months.get(i).substring(1,8))){
                o1.add(map1.get(months.get(i).substring(1,8)));
            }
            else{
                o1.add(0);
            }
            if(map2.containsKey(months.get(i).substring(1,8))){
                o2.add(map2.get(months.get(i).substring(1,8)));
            }
            else{
                o2.add(0);
            }
            if(map3.containsKey(months.get(i).substring(1,8))){
                o3.add(map3.get(months.get(i).substring(1,8)));
            }
            else{
                o3.add(0);
            }
            if(map4.containsKey(months.get(i).substring(1,8))){
                o4.add(map4.get(months.get(i).substring(1,8)));
            }
            else{
                o4.add(0);
            }
            if(map5.containsKey(months.get(i).substring(1,8))){
                o5.add(map5.get(months.get(i).substring(1,8)));
            }
            else{
                o5.add(0);
            }
            if(map6.containsKey(months.get(i).substring(1,8))){
                o6.add(map6.get(months.get(i).substring(1,8)));
            }
            else{
                o6.add(0);
            }
        }
        request.setAttribute("O1", o1);
        request.setAttribute("O2", o2);
        request.setAttribute("O3", o3);
        request.setAttribute("O4", o4);
        request.setAttribute("O5", o5);
        request.setAttribute("O6", o6);

        List topCourseMonth=institutionService.getTopCourseMonth(ins_id);
        request.setAttribute("cm",topCourseMonth);
        List topCourse=institutionService.getTopCourseAll(ins_id);
        request.setAttribute("ca",topCourse);
        List topClassMonth=institutionService.getTopClassMonth(ins_id);
        request.setAttribute("tc",topClassMonth);
        List topClass=institutionService.getTopClassAll(ins_id);
        request.setAttribute("tca",topClass);

        Map<String,Integer> classType=institutionService.getClassType(ins_id);
        request.setAttribute("ct",classType);
        Map<String,Integer> classStatus=institutionService.getClassStatus(ins_id);
        request.setAttribute("cs",classStatus);
        Map<String,Integer> classGrades=institutionService.getClassGrades(ins_id);
        request.setAttribute("cg",classGrades);
        List top5=institutionService.getTop5(ins_id);
        request.setAttribute("t5",top5);

        return "insSta";
    }
}
