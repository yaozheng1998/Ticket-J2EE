package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author YZ
 * @Date 2018/3/4
 */
@Entity
@Table(name="institution")
public class Institution {
    @Id
    private int ins_id;

    private String password;
    private String location;
    private int classrooms;
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getClassrooms() {

        return classrooms;
    }

    public void setClassrooms(int classrooms) {
        this.classrooms = classrooms;
    }

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIns_id() {

        return ins_id;
    }

    public void setIns_id(int ins_id) {
        this.ins_id = ins_id;
    }
}
