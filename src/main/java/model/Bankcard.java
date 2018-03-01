package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author YZ
 * @Date 2018/3/1
 */
@Entity
@Table(name = "bankCard")
public class Bankcard {
    @Id
    private String bankCardId;
    private double balance;

    public String getBankCardId(){
        return bankCardId;
    }
    public void setBankCardId(String bankCardId){
        this.bankCardId=bankCardId;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
}
