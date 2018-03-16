package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author YZ
 * @Date 2018/3/15
 */
@Entity
@Table(name="manager")
public class Manager {
    @Id
    private int id;
    private double web_profit;

    public double getWeb_profit() {
        return web_profit;
    }

    public void setWeb_profit(double web_profit) {
        this.web_profit = web_profit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int ins_id;
    private double ins_allmoney;

    public double getIns_allmoney() {
        return ins_allmoney;
    }

    public void setIns_allmoney(double ins_allmoney) {
        this.ins_allmoney = ins_allmoney;
    }

    public int getIns_id() {

        return ins_id;
    }

    public void setIns_id(int ins_id) {
        this.ins_id = ins_id;
    }
}
