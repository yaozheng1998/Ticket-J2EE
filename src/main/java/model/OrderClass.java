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

    private int order_id;
    private int class_id;
    private String real_name;
    private String phone;
    private float grade;

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
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

    public int getOrder_id() {

        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getOrderclass_id() {
        return orderclass_id;

    }

    public void setOrderclass_id(int orderclass_id) {
        this.orderclass_id = orderclass_id;
    }
}
