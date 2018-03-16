package dao.impl;

import dao.BaseDao;
import dao.ManageDao;
import model.Institution;
import model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.SumPayVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/15
 */
@Repository
public class ManageDaoImpl implements ManageDao{
    @Autowired
    private BaseDao baseDao;

    public List<Institution> getAllIns() {
        String sql="select * from `institution` where state='未审核'";
        List<Object[]> objects=baseDao.querySQL(sql);
        return this.getInsFromOb(objects);
    }

    public List<Institution> getAllChanges() {
        String sql="select * from `institution` where changes!=''";
        List<Object[]> objects=baseDao.querySQL(sql);
        return this.getInsFromOb(objects);
    }

    public void approveRegis(int ins_id) {
        String sql="update `institution` set state='已审核' where ins_id="+ins_id;
        baseDao.excuteBySql(sql);
    }

    public void approveInfo(int ins_id) {
        String sql="select changes from `institution` where ins_id="+ins_id;
        String changes=(String)baseDao.querySQL(sql).get(0);
        String[] strings=changes.split("-");
        String sqlq="update `institution` set ins_name='"+strings[0]+"', location='"+strings[1]+"', classrooms="+strings[2]+", changes='' where ins_id="+ins_id;
        baseDao.excuteBySql(sqlq);
    }

    public int getNextId() {
        return (int) (baseDao.getTotalCount(Manager.class)+1);
    }

    public void save(Manager manager) {
        try{
            baseDao.save(manager);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Manager getManagerByIns(int ins_id) {
        String sql="select * from `manager` where ins_id="+ins_id;
        List<Object[]> list=baseDao.querySQL(sql);
        Manager manager=this.getManage(list).get(0);
        return manager;
    }

    public void update(Manager manager) {
        baseDao.update(manager);
    }

    public List<SumPayVO> getToCal() {
        String sql="select m.ins_id,i.ins_name,i.location,m.ins_allmoney from `institution` i,`manager` m where m.ins_id=i.ins_id and m.ins_allmoney!=0";
        List<Object[]> objects=baseDao.querySQL(sql);
        return this.getSPV(objects);
    }

    public double paySeven(int ins_id) {
        Manager manager=getManagerByIns(ins_id);
        double money=manager.getIns_allmoney();
        manager.setWeb_profit(manager.getWeb_profit()+money*0.3);
        manager.setIns_allmoney(0);
        baseDao.update(manager);
        return money*0.7;
        //没给机构
    }


    private List<SumPayVO> getSPV(List<Object[]> list){
        List<SumPayVO> sumPayVOList=new ArrayList<SumPayVO>();
        for(Object[] objects:list){
            SumPayVO vo=new SumPayVO();
            vo.setIns_id((Integer)objects[0]);
            vo.setIns_name(String.valueOf(objects[1]));
            vo.setIns_loc(String.valueOf(objects[2]));
            vo.setSum((Double)objects[3]);
            sumPayVOList.add(vo);
        }
        return sumPayVOList;

    }

    private List<Manager> getManage(List<Object[]> list){
        List<Manager> managerList=new ArrayList<Manager>();
        for (Object[] objects:list) {
            Manager manager = new Manager();
            manager.setId((Integer)objects[0]);
            manager.setIns_id((Integer)objects[1]);
            manager.setIns_allmoney((Double)objects[2]);
            manager.setWeb_profit((Double)objects[3]);
            managerList.add(manager);
        }
        return managerList;
    }
    private List<Institution> getInsFromOb(List<Object[]> list){
        List<Institution> institutionList=new ArrayList<Institution>();
        for(Object[] objects:list){
            Institution institution=new Institution();
            institution.setIns_id((Integer)objects[0]);
            institution.setIns_name(String.valueOf(objects[1]));
            institution.setPassword(String.valueOf(objects[2]));
            institution.setLocation(String.valueOf(objects[3]));
            institution.setClassrooms((Integer)objects[4]);
            institution.setState(String.valueOf(objects[5]));
            institution.setChanges(String.valueOf(objects[6]));
            institutionList.add(institution);
        }
        return institutionList;
    }
}
