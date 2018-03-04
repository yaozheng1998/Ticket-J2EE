package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author YZ
 * @Date 2018/3/4
 */
@Entity
@Table(name="class")
public class Class {
    @Id
    private int class_id;

    private int course_id;
    private int teacher_id;
    private int price;
    private int all_num;
    private int now_num;

    public int getClass_id(){return class_id;}
    public void setClass_id(int class_id){this.class_id=class_id;}

    public int getCourse_id_id(){return course_id;}
    public void setCourse_id(int course_id){this.course_id=course_id;}
    public int getTeacher_id(){return teacher_id;}
    public void setTeacher_id(int teacher_id){this.teacher_id=teacher_id;}
    public int getPrice(){return price;}
    public void setPrice(int price){this.price=price;}
    public int getAll_num(){return all_num;}
    public void setAll_num(int all_num){this.all_num=all_num;}
    public int getNow_num(){return now_num;}
    public void setNow_num(int now_num){this.now_num=now_num;}


}
