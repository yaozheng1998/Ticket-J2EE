package dao;

import model.OrderClass;
import util.OrderClassVO;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/4
 */
public interface OrderClassDao {
    /**
     * 根据用户名得到名下所有课程对应班级；直接显示班级
     * @param name
     * @return
     */
    public List<OrderClass> getClassFromVIPName(String name);

    /**
     * 根据状态筛选出对应的班级信息
     * @param state
     * @return
     */
    public List<OrderClass> getClassByState(String name,String state);

    /**
     * 新增一条学生信息
     * @param orderClass
     */
    public void save(OrderClass orderClass);

    /**
     * 得到下一个可用的oc编号
     * @return
     */
    public long getNextId();

    /**
     * 退订某一个订单
     */
    public void cancel(int order_classId,double money,String vipName);

    /**
     * 登分
     * @param order_id
     * @param name
     * @param grade
     */
    public void setGrade(int order_id,String name,double grade);


}
