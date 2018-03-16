package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.InstitutionService;

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
        List t=new ArrayList();
        List n=new ArrayList();
        Set set=map.keySet();
        Iterator<String> it=set.iterator();
        while(it.hasNext()){
            String key=it.next();
            t.add(key);
            n.add(map.get(key));
        }
        String[] tarray=new String[t.size()];
        int[] narray=new int[n.size()];
        String[] too= (String[]) t.toArray(tarray);
        for(int j=0;j<n.size();j++){
            narray[j]= (Integer) n.get(j);
        }
        request.setAttribute("barx",too);
        request.setAttribute("bary",narray);
        return "insSta";
    }
}
