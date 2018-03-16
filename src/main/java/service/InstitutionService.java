package service;

import model.Course;
import model.Institution;
import model.Order;

import java.util.HashMap;
import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/7
 */
public interface InstitutionService {
    /**
     * 获取所有机构信息
     * @return
     */
    public List<Institution> getAllIns();

    /**
     * 获取所有机构名称
     * @return
     */
    public List<String> getAllInsName();

    /**
     * 获取所有机构地点
     * @return
     */
    public List<String> getAllLocation();

    /**
     * 根据机构id获得机构的信息
     * @param insId
     * @return
     */
    public Institution getInsById(int insId);

    /**
     * 新增机构，还未审核
     * @param institution
     */
    public void addIns(Institution institution);

    /**
     * 系统自动分配可登录ID
     * @return
     */
    public long getNextId();

    /**
     * 判断机构是否已经通过审核
     * @return
     */
    public boolean whetherAct(int insId);

    /**
     * 通过机构Id获得机构的所有信息
     * @param insId
     * @return
     */
    public Institution getInfoById(int insId);

    /**
     * 登录时检查密码是否正确
     * @param id
     * @param password
     * @return
     */
    public boolean checkPass(int id,String password);

    /**
     * 修改机构信息
     * @param institution
     */
    public void update(Institution institution);

    /**
     * 得到一个机构的所有课程信息，不是班级
     * @param insId
     * @return
     */
    public List<Course> getCoursesOfIns(int insId);

    /**
     * 机构申请修改信息
     * @param ins_id
     * @param ins_name
     * @param location
     * @param classrooms
     */
    public void change(int ins_id,String ins_name,String location,int classrooms);

    /**
     * 挣钱
     * @param ins_id
     */
    public void setMoney(int ins_id,double money);

    /**
     * 根据订单的不同状态获得信息
     * @param state
     * @return
     */
    public List<Object[]> getInsOrdersByState(int ins_id,String state);

    /**
     * 机构累计订单数
     * @param ins_id
     * @return
     */
    public int getOrderNum(int ins_id);

    /**
     * 机构累计听课学生人数
     * @param ins_id
     * @return
     */
    public int getStudentNum(int ins_id);

    /**
     * 机构累计分得的金额
     * @param ins_id
     * @return
     */
    public double getMoney(int ins_id);

    /**
     * 根据状态获得机构订单数目
     * @param ins_id
     * @param state
     * @return
     */
    public int getNumByState(int ins_id,String state);

    /**
     * 获得每个老师手下的订单数
     * @param ins_id
     * @return
     */
    public HashMap getNumByTeacher(int ins_id);
}
