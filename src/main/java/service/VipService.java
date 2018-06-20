package service;

import model.Vip;

import java.util.List;
import java.util.Map;

/**
 * @Author YZ
 * @Date 2018/2/25
 */
public interface VipService {
    /**
     * 判断该帐号是否激活
     * @return
     */
    public boolean whetherActive(String vipName);
    /**
     * 验证该会员编号是否存在
     * @param vipName
     * @return
     */
    public boolean isExist(String vipName);

    /**
     * 注册会员
     * @param vip
     */
    public void registerVip(Vip vip);

    /**
     * 验证会员密码输入是否正确
     * @param vipName
     * @param password
     * @return
     */
    public boolean checkPassword(String vipName, String password);

    /**
     * 修改会员信息
     * @param vip
     */
    public void updateVip(Vip vip);

    /**
     * 根据会员编号查找会员
     * @param vipName
     * @return
     */
    public Vip findVipByName(String vipName);

//    /**
//     * 会员主动取消会员资格，删除会员卡，但不删除数据
//     * @param vipName
//     * @return
//     */
//    public boolean cancelVip(String vipName);

    /**
     * 激活
     * @param name
     */
    public void setActive(String name);

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
     * 修改会员信息
     * @param vip
     */
    public void update(Vip vip);

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
    public Map<String,Integer> getLatestNum(String vipName);

    /**
     * 获取最近12个月每个月订单总金额的变化
     * @param vipName
     * @return
     */
    public Map<String,Double> getLatestMoney(String vipName);

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
    public String getOKrate(String vipName);

    /**
     * 学员已结束课程成绩比例分析
     * @param vipName
     * @return
     */
    public List<Integer> getGrades(String vipName);

    /**
     * 学员线上或线下预订课程订单数量
     * @param vipName
     * @return
     */
    public List<Integer> getOrderOnOffline(String vipName);
}
