package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author YZ
 * @Date 2018/3/15
 */
public class CalReturnMoney {
    public static final long TWO_WEEK=14*24*60*60*1000;
    public static final long ONE_WEEK=7*24*60*60*1000;

    public static double cal(Date starttime){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long diff=null;
        Date now=new Date();
        try {
            diff=sdf.parse(sdf.format(now)).getTime()-sdf.parse(sdf.format(starttime)).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(diff<=ONE_WEEK){
            return 0.4;
        }else if(ONE_WEEK<diff && diff<=TWO_WEEK){
            return 0.6;
        }else if(diff>TWO_WEEK){
            return 0.8;
        }else{
            return 0;
        }
    }
}
