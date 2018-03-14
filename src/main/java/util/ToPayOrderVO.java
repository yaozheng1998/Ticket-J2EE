package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author YZ
 * @Date 2018/3/14
 */
public class ToPayOrderVO {
    private int order_id;
    private String order_time;
    private String ins_name;
    private String ins_location;
    private double money;

    DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getIns_location() {

        return ins_location;
    }

    public void setIns_location(String ins_location) {
        this.ins_location = ins_location;
    }

    public String getIns_name() {

        return ins_name;
    }

    public void setIns_name(String ins_name) {
        this.ins_name = ins_name;
    }

    public Date getOrder_time() throws ParseException {

        return sdf.parse(order_time);
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public int getOrder_id() {

        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
