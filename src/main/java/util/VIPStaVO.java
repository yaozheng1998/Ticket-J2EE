package util;

/**
 * @Author YZ
 * @Date 2018/3/17
 */
public class VIPStaVO {
    private String vip_name;
    private String vip_rank;
    private int order_num;
    private double all_money;

    public double getAll_money() {
        return all_money;
    }

    public void setAll_money(double all_money) {
        this.all_money = all_money;
    }

    public int getOrder_num() {

        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public String getVip_rank() {

        return vip_rank;
    }

    public void setVip_rank(String vip_rank) {
        this.vip_rank = vip_rank;
    }

    public String getVip_name() {

        return vip_name;
    }

    public void setVip_name(String vip_name) {
        this.vip_name = vip_name;
    }
}
