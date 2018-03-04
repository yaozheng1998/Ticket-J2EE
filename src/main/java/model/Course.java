package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author YZ
 * @Date 2018/3/4
 */

@Entity
@Table(name="course")
public class Course {
    @Id
    private int course_id;

    public int getInstitution_id() {
        return institution_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setInstitution_id(int institution_id) {
        this.institution_id = institution_id;
    }

    private int institution_id;
    private String start_time;

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    private String end_time;

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    private int basic_price;
    private int times;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTimes() {

        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getBasic_price() {

        return basic_price;
    }

    public void setBasic_price(int basic_price) {
        this.basic_price = basic_price;
    }
}
