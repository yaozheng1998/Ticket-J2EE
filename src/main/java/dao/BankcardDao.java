package dao;

import model.Bankcard;

/**
 * @Author YZ
 * @Date 2018/3/1
 */
public interface BankcardDao {
    /**
     * 保存银行卡信息
     * @param bankcard
     */
    public void save(Bankcard bankcard);

    /**
     * 修改银行卡余额
     * @param bankcard
     */
    public void update(Bankcard bankcard);

    /**
     * 根据Id查询余额信息
     * @param bankcardId
     * @return
     */
    public Bankcard find(String bankcardId);
}
