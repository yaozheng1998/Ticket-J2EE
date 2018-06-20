package util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/**
 * @Author YZ
 * @Date 2018/6/18
 */
public class LatestMonths {
    static List months=new ArrayList();
    public static List get12(){
        Calendar cal=Calendar.getInstance();
        for(int i=0; i<12; i++){
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1); //逐次往前推1个月
            months.add("'"+cal.get(Calendar.YEAR)+ "-" + fillZero(cal.get(Calendar.MONTH)+1)+"'" );
        }
        Collections.reverse(months);
        return months;
    }
    public static String fillZero(int i){
        if(i<10){
            return "0"+i;
        }
        else return String.valueOf(i);
    }
    public static void main(String[]args){
        System.out.println(LatestMonths.get12());
    }
}
