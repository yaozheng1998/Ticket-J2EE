package dao;

import model.Vip;

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
     * 验证该会员编号是否已经存在
     * @param vipId
     * @return
     */
    public boolean checkExisted(String vipId);

    /**
     * 获取可用的会员编号
     * @return
     */
    public String getId();

    /**
     * 修改会员信息
     * @param vip
     */
    public void update(Vip vip);

    /**
     * 根据会员编号查找会员
     * @param vipId
     * @return
     */
    public Vip find(String vipId);

    /**
     * 验证会员密码是否正确
     * @param vipId
     * @param password
     * @return
     */
    public boolean checkPassword(String vipId, String password);
}
