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
}
