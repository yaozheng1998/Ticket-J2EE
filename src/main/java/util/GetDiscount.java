package util;

/**
 * @Author YZ
 * @Date 2018/3/12
 */
public class GetDiscount {
    public static double getdis(String vipLevel){
        if(vipLevel.equals("青铜")){
            return 9.5;
        }else if(vipLevel.equals("白银")){
            return 9;
        }else if(vipLevel.equals("黄金")){
            return 8.5;
        } else if(vipLevel.equals("铂金")){
            return 8;
        }else if(vipLevel.equals("钻石")){
            return 7.5;
        }else{
            return 7;
        }
    }
}
