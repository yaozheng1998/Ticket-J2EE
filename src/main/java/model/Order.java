package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author YZ
 * @Date 2018/3/4
 */
@Entity
@Table(name="order")
public class Order {
    @Id
    private int order_id;

    private String vip_id;
    private int ins_id;
    private String order_time;
    private float money;
    private int pay_type;
    private String refund_time;
    private float refund_money;

    public float getRefund_money() {
        return refund_money;
    }

    public void setRefund_money(float refund_money) {
        this.refund_money = refund_money;
    }

    public String getRefund_time() {

        return refund_time;
    }

    public void setRefund_time(String refund_time) {
        this.refund_time = refund_time;
    }

    public int getPay_type() {

        return pay_type;
    }

    public void setPay_type(int pay_type) {
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

    public String getVip_id() {

        return vip_id;
    }

    public void setVip_id(String vip_id) {
        this.vip_id = vip_id;
    }

    public int getOrder_id() {

        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
