package service;

import model.OrderClass;
import util.OrderClassVO;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/10
 */
public interface OrderClassService {
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
}