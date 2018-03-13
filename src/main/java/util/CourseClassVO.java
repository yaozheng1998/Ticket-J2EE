package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author YZ
 * @Date 2018/3/13
 */
public class CourseClassVO {
    int course_id;
    String start_time;
    String end_time;
    String course_name;
    String class_name;
    String teacher_name;
    double price;
    int all_num;
    int now_num;
    int times;

    DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getNow_num() {

        return now_num;
    }

    public void setNow_num(int now_num) {
        this.now_num = now_num;
    }

    public int getAll_num() {

        return all_num;
    }

    public void setAll_num(int all_num) {
        this.all_num = all_num;
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

    public String getCourse_name() {

        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Date getEnd_time() throws ParseException{
        return sdf.parse(end_time);

    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public Date getStart_time() throws ParseException {

        return sdf.parse(start_time);
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public int getCourse_id() {

        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}
