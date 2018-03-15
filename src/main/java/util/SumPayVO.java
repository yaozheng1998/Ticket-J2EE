package util;

/**
 * @Author YZ
 * @Date 2018/3/16
 */
public class SumPayVO {
    private int ins_id;
    private String ins_name;
    private String ins_loc;
    private double sum;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getIns_loc() {

        return ins_loc;
    }

    public void setIns_loc(String ins_loc) {
        this.ins_loc = ins_loc;
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
