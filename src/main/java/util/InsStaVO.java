package util;

/**
 * @Author YZ
 * @Date 2018/3/17
 */
public class InsStaVO {
    private int ins_id;
    private String ins_name;
    private String location;
    private int class_num;
    private int order_num;
//    private int student_num;
    private double money;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

//    public int getStudent_num() {
//
//        return student_num;
//    }
//
//    public void setStudent_num(int student_num) {
//        this.student_num = student_num;
//    }

    public int getOrder_num() {

        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public int getClass_num() {

        return class_num;
    }

    public void setClass_num(int class_num) {
        this.class_num = class_num;
    }

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIns_name() {

        return ins_name;
    }

    public void setIns_name(String ins_name) {
        this.ins_name = ins_name;
    }

    public int getIns_id() {

        return ins_id;
    }

    public void setIns_id(int ins_id) {
        this.ins_id = ins_id;
    }
}
