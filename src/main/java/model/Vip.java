package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author YZ
 * @Date 2018/2/24
 */
@Entity
@Table(name="vip")
public class Vip implements Serializable {
    @Id
    private String vipId;

    private String vipName;
    private String mailbox;
    private String vipPassword;
    private String vip_bankCardId;
    private String activateDate;
    private double consumeMoney;
    private double vipPoint;
    private double vipSubMoney;
    private String calcelDate;

    public String getVipName(){
        return vipName;
    }
    public void setVipName(String vipName){
        this.vipName=vipName;
    }

    public String getMailbox(){
        return mailbox;
    }
    public void setMailbox(String mailbox){
        this.mailbox=mailbox;
    }

    public String getVipPassword(){
        return vipPassword;
    }
    public void setVipPassword(String vipPassword){
        this.vipPassword=vipPassword;
    }

    public String getVip_bankCardId(){
        return vip_bankCardId;
    }
    public void setVip_bankCardId(String vip_bankCardId){
        this.vip_bankCardId=vip_bankCardId;
    }

    public String getActivateDate(){
        return activateDate;
    }
    public void setActivateDate(String activateDate){
        this.activateDate=activateDate;
    }

    public double getConsumeMoney(){
        return consumeMoney;
    }
    public void setConsumeMoney(double consumeMoney){
        this.consumeMoney=consumeMoney;
    }

    public double getVipPoint(){
        return vipPoint;
    }
    public void setVipPoint(double vipPoint){
        this.vipPoint=vipPoint;
    }

    public double getVipSubMoney(){
        return vipSubMoney;
    }
    public void setVipSubMoney(double vipSubMoney){
        this.vipSubMoney=vipSubMoney;
    }

    public String getCalcelDate(){
        return calcelDate;
    }
    public void setCalcelDate(String calcelDate){
        this.calcelDate=calcelDate;
    }

}
