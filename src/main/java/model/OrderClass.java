package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author YZ
 * @Date 2018/3/4
 */

@Entity
@Table(name="order_classes")
public class OrderClass {
    @Id
    private int orderclass_id;

    public int getItorder_id() {
        return itorder_id;
    }

    public void setItorder_id(int itorder_id) {
        this.itorder_id = itorder_id;
    }

    private int itorder_id;
    private int class_id;
    private String real_name;
    private String phone;
    private double grade;
    private String state;
    private String refund_time;
    private double refund_money;

    public String getRefund_time() {
        return refund_time;
    }

    public double getRefund_money() {
        return refund_money;
    }

    public void setRefund_money(double refund_money) {
        this.refund_money = refund_money;
    }

    public void setRefund_time(String refund_time) {
        this.refund_time = refund_time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReal_name() {

        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public int getClass_id() {

        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getOrderclass_id() {
        return orderclass_id;

    }

    public void setOrderclass_id(int orderclass_id) {
        this.orderclass_id = orderclass_id;
    }
}
