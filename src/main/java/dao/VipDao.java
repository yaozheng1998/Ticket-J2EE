package dao;

import model.Vip;

import java.util.List;
import java.util.Map;

/**
 * @Author YZ
 * @Date 2018/2/25
 */
public interface VipDao {
    /**
     * 新增会员，利用邮箱注册
     * @param vip
     */
    public void save(Vip vip);

    /**
     * 验证该会员名是否已经存在
     * @param vipName
     * @return
     */
    public boolean checkExisted(String vipName);

    /**
     * 修改会员信息
     * @param vip
     */
    public void update(Vip vip);

    /**
     * 根据会员名查找会员
     * @param vipName
     * @return
     */
    public Vip find(String vipName);

    /**
     * 验证会员密码是否正确
     * @param vipName
     * @param password
     * @return
     */
    public boolean checkPassword(String vipName, String password);

    /**
     * 注销会员
     * @param vipName
     */
    public void cancelVIP(String vipName);

    /**
     * 兑换优惠券10元
     * @param vipName
     */
    public boolean convert(String vipName);

    /**
     * 总单数
     * @param vipName
     * @return
     */
    public int getOrderNum(String vipName);

    /**
     * 上课总人数
     * @param vipName
     * @return
     */
    public int getStudentNum(String vipName);

    /**
     * 总支出
     * @param vipName
     * @return
     */
    public double getOrderMoney(String vipName);

    /**
     * 根据订单状态获得饼状图数据
     * @param vipName
     * @param state
     * @return
     */
    public int getNumByState(String vipName,String state);

    /**
     * 获取近12个月每个月订单总数的变化
     * @param vipName
     * @return
     */
    public List<Integer> getLatestNum(String vipName);

    /**
     * 获取最近12个月每个月订单总金额的变化
     * @param vipName
     * @return
     */
    public List<Double> getLatestMoney(String vipName);

    /**
     * 学员订单课程类型分析
     * @param vipName
     * @return
     */
    public Map<String,Integer> getOrderType(String vipName);

    /**
     * 学员订单地域分析
     * @param vipName
     * @return
     */
    public Map<String,Integer> getOrderLocation(String vipName);

    /**
     * 学员订单状态比例分析
     * @param vipName
     * @return
     */
    public Map<String,Integer> getOrderStatus(String vipName);

    /**
     * 学员订单的成交率
     * @param vipName
     * @return
     */
    public double getOKrate(String vipName);

    /**
     * 学员已结束课程成绩比例分析
     * @param vipName
     * @return
     */
    public List<Integer> getGrades(String vipName);
}
