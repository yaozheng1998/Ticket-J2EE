package dao.impl;

import dao.BankcardDao;
import dao.BaseDao;
import model.Bankcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author YZ
 * @Date 2018/3/1
 */
@Repository
public class BankcardDaoImpl implements BankcardDao{
    @Autowired
    private BaseDao baseDao;

    public void save(Bankcard bankcard) {
        baseDao.save(bankcard);
    }

    public void update(Bankcard bankcard) {
        baseDao.update(bankcard);
    }

    public Bankcard find(String bankcardId) {
        Bankcard bankcard=(Bankcard)baseDao.load(Bankcard.class,bankcardId);
        return bankcard;
    }
}
