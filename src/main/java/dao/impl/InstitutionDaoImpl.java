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

    public Institution getInsById(int insId) {
        return (Institution) baseDao.load(Institution.class,insId);
    }

    public void addIns(Institution institution) {
        try{
            baseDao.save(institution);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public long getNextId() {
        return baseDao.getTotalCount(Institution.class)+8000001;
    }

    public boolean whetherAct(int insId) {
        Institution institution=getInfoById(insId);
        if(institution.getState().equals("待审核")){
            return false;
        }
        return true;
    }

    public Institution getInfoById(int insId) {
        return (Institution)baseDao.load(Institution.class,insId);
    }

    public boolean checkPass(int id, String password) {
        Institution institution=getInfoById(id);
        if(institution.getPassword().equals(password)){
            return true;
        }
        return false;
    }
}