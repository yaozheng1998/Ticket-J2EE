package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author YZ
 * @Date 2018/3/4
 */
@Entity
@Table(name="orders")
public class Order {
    @Id
    private int order_id;

    private String vip_name;
    private int ins_id;
    private String order_time;
    private float money;
    private String pay_type;

    public String getPay_type() {

        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public float getMoney() {

        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getOrder_time() {

        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public int getIns_id() {

        return ins_id;
    }

    public void setIns_id(int ins_id) {
        this.ins_id = ins_id;
    }

    public String getVip_name() {
        return vip_name;
    }

    public void setVip_name(String vip_name) {
        this.vip_name = vip_name;
    }

    public int getOrder_id() {

        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
