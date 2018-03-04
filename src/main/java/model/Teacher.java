package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author YZ
 * @Date 2018/3/4
 */
@Entity
@Table(name="teacher")
public class Teacher {
    @Id
    private int teacher_id;

    private int ins_id;
    private String name;
    private String rank;

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIns_id() {

        return ins_id;
    }

    public void setIns_id(int ins_id) {
        this.ins_id = ins_id;
    }

    public int getTeacher_id() {

        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }
}
