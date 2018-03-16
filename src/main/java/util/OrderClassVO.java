package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    String begin_time;
    String end_time;
    String teacher_name;
    double price;
    String student_name;
    String phone;
    double grade;
    String state;
    String refund_time;
    double refund_money;
    int order_classId;
    String vipName;

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public int getOrder_classId() {
        return order_classId;
    }

    public void setOrder_classId(int order_classId) {
        this.order_classId = order_classId;
    }

    public double getRefund_money() {
        return refund_money;
    }

    public void setRefund_money(double refund_money) {
        this.refund_money = refund_money;
    }

//    public Date getRefund_time() throws ParseException {
//        if(refund_time!=null&&refund_time.length()!=0) {
//            return sdf.parse(refund_time);
//        }else{
//            return null;
//        }
//    }


    public String getRefund_time() {
        return refund_time;
    }

    public void setRefund_time(String refund_time) {
        this.refund_time = refund_time;
    }

    DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    public Date getBegin_time() throws ParseException {
        return sdf.parse(begin_time);
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public Date getEnd_time() throws ParseException {
        return sdf.parse(end_time);
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
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

    public Date getOrder_time() throws ParseException {

        return sdf.parse(order_time);
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
