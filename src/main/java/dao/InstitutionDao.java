package dao;

import model.Course;
import model.Institution;
import model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author YZ
 * @Date 2018/3/4
 */
public interface InstitutionDao {
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

    /**
     * 某个机构销售状况及变化分析，按月份
     */

    /**
     * 机构总订单数随时间的变化
     * @param ins_id
     * @return
     */
    public Map<String,Integer> getOrderNumChange(int ins_id);

    /**
     * 机构总金额随时间的变化
     * @param ins_id
     * @return
     */
    public Map<String,Double> getOrderMoneyChange(int ins_id);

    /**
     * 机构总学员数随时间的变化
     * @param ins_id
     * @return
     */
    public Map<String,Integer> getStudentNumChange(int ins_id);

    /**
     * 机构成交率随时间的变化
     * @param ins_id
     * @return
     */
    public Map<String,Double> getOKRateChange(int ins_id);

    /**
     * 机构平均订单价格随时间的变化
     * @param ins_id
     * @return
     */
    public Map<String,Double> getAveragePrice(int ins_id);

    /**
     * 机构线上订单比例随时间的变化
     * @param ins_id
     * @return
     */
    public Map<String,Double> getBuyMethod(int ins_id);

    /**
     * 某个机构热门分析按月以及总时间
     */

    /**
     * 当月机构热门课程榜单
     * @param ins_id
     * @return
     */
    public List getTopCourseMonth(int ins_id);

    /**
     * 总时间内的热门课程榜单
     * @param ins_id
     * @return
     */
    public List getTopCourseAll(int ins_id);

    /**
     * 当月机构热门班级／教师榜单
     * @param ins_id
     * @return
     */
    public List getTopClassMonth(int ins_id);

    /**
     * 总时间内的热门班级／教师榜单
     * @param ins_id
     * @return
     */
    public List getTopClassAll(int ins_id);

    /**
     * 活跃学员特征分析
     * 1. 学员消费总额与会员等级关系
     * 2. 学员购买课程类型
     * 3. 学员课程状态比例分析
     * 4. 学员听课率随时间变化
     * 5. 已结束课程中学员成绩比例分析
     */

    /**
     * 该机构内不同课程类型销量统计
     * @param ins_id
     * @return
     */
    public Map<String,Integer> getClassType(int ins_id);

    /**
     * 该机构内不同课程状态统计
     * @param ins_id
     * @return
     */
    public Map<String,Integer> getClassStatus(int ins_id);

    /**
     * 该机构内已结束课程学员成绩比例分析
     * @param ins_id
     * @return
     */
    public Map<String,Integer> getClassGrades(int ins_id);

    /**
     * 该机构内消费最高的5名会员；名字后加上会员等级
     * @param ins_id
     * @return
     */
    public Map<String,Double> getTop5(int ins_id);


}
