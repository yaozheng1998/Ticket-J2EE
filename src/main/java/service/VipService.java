package service;

import model.Vip;

/**
 * @Author YZ
 * @Date 2018/2/25
 */
public interface VipService {
    /**
     * 验证该会员编号是否存在
     * @param vipId
     * @return
     */
    public boolean isExist(String vipId);

    /**
     * 注册会员
     * @param vip
     */
    public void registerVip(Vip vip);

    /**
     * 获取可用的会员编号
     * @return
     */
    public String getVipId();

    /**
     * 验证会员密码输入是否正确
     * @param vipId
     * @param password
     * @return
     */
    public boolean checkPassword(String vipId, String password);

    /**
     * 修改会员信息
     * @param vip
     */
    public void updateVip(Vip vip);

    /**
     * 根据会员编号查找会员
     * @param vipId
     * @return
     */
    public Vip findVipById(String vipId);

    /**
     * 会员主动取消会员资格，删除会员卡，但不删除数据
     * @param vipId
     * @return
     */
    public boolean cancelVip(String vipId);
}
