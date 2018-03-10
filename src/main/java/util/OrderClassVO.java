package util;

/**
 * @Author YZ
 * @Date 2018/3/10
 */
public class OrderClassVO {
    int order_id;
    String order_time;
    String pay_type;
    String ins_name;
    String class_name;
    String teacher_name;
    double price;
    String student_name;
    String phone;
    double grade;
    String state;

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

    public String getStudent_name() {

        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTeacher_name() {

        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getClass_name() {

        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getPay_type() {

        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getOrder_time() {

        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public int getOrder_id() {

        return order_id;
    }

    public String getIns_name() {
        return ins_name;
    }

    public void setIns_name(String ins_name) {
        this.ins_name = ins_name;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}
