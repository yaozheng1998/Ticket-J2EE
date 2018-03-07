package dao.impl;

import dao.BaseDao;
import dao.InstitutionDao;
import model.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/7
 */
@Repository
public class InstitutionDaoImpl implements InstitutionDao {
    @Autowired
    private BaseDao baseDao;


    public List<Institution> getAllIns() {
        return baseDao.getAllList(Institution.class);
    }

    public List<String> getAllInsName() {
        String sql = "select distinct ins_name from `institution`";
        List<String> list = baseDao.querySQL(sql);
        return list;
    }

    public List<String> getAllLocation() {
        String sql = "select distinct location from `institution`";
        List<String> list = baseDao.querySQL(sql);
        return list;
    }
}