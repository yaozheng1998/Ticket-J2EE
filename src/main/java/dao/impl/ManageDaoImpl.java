package dao.impl;

import dao.BaseDao;
import dao.ManageDao;
import model.Institution;
import model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.InsStaVO;
import util.SumPayVO;
import util.VIPStaVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author YZ
 * @Date 2018/3/15
 */
@Repository
public class ManageDaoImpl implements ManageDao{
    @Autowired
    private BaseDao baseDao;

    private List insList=new ArrayList();
    private List insMoneyList=new ArrayList();
    private List vipList=new ArrayList();
    private List vipMoneyList=new ArrayList();

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

    public void disapproveRegis(int ins_id) {
        String sql="update `institution` set state='不通过' where ins_id="+ins_id;
        baseDao.excuteBySql(sql);
    }

    public void disapproveInfo(int ins_id) {
        String sql="update `institution` set changes='' where ins_id="+ins_id;
        baseDao.excuteBySql(sql);
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

    public int getAllOrder() {
        String sql="select count(*) from `orders`";
        return Integer.parseInt(String.valueOf(baseDao.querySQL(sql).get(0)));
    }

    public int getAllStudent() {
        String sql="select count(*) from `order_classes`";
        return Integer.parseInt(String.valueOf(baseDao.querySQL(sql).get(0)));
    }

    public double getAllMoney() {
        String sql="select coalesce(sum(money),0) from `orders`";
        return Double.parseDouble(String.valueOf(baseDao.querySQL(sql).get(0)));
    }

    public List<InsStaVO> getInsSta() {
        String sql="select i.ins_id,i.ins_name,i.location,i.classrooms,count(*),sum(o.money) from `institution` i,`orders` o where o.ins_id=i.ins_id group by i.ins_id,i.ins_name,i.location,i.classrooms order by sum(o.money) desc";
        return this.getInsSta(baseDao.querySQL(sql));
    }

    public List<VIPStaVO> getVIPSta() {
        String sql="select v.vipName,v.vipLevel,count(*),sum(money) from `orders` o,`vip` v where v.vipName=o.vip_name group by v.vipName,v.vipLevel order by sum(money) desc";
        return this.getVIPSta(baseDao.querySQL(sql));
    }

    private  List<InsStaVO> getInsSta(List<Object[]> list){
        List<InsStaVO> insStaVOS=new ArrayList<InsStaVO>();
        for(Object[] objects:list){
            InsStaVO vo=new InsStaVO();
            vo.setIns_id((Integer)objects[0]);
            vo.setIns_name(String.valueOf(objects[1]));
            insList.add(String.valueOf(objects[1]));
            vo.setLocation(String.valueOf(objects[2]));
            vo.setClass_num((Integer)objects[3]);
            vo.setOrder_num(Integer.parseInt(String.valueOf(objects[4])));
            vo.setMoney(Double.parseDouble(String.valueOf(objects[5])));
            insMoneyList.add(String.valueOf(objects[5]));
            insStaVOS.add(vo);
        }
        return insStaVOS;
    }
    private List<VIPStaVO> getVIPSta(List<Object[]> list){
        List<VIPStaVO> vipStaVOS=new ArrayList<VIPStaVO>();
        for(Object[] objects:list){
            VIPStaVO vo=new VIPStaVO();
            vo.setVip_name(String.valueOf(objects[0]));
            vipList.add(String.valueOf(objects[0]));
            vo.setVip_rank(String.valueOf(objects[1]));
            vo.setOrder_num(Integer.parseInt(String.valueOf(objects[2])));
            vo.setAll_money(Double.parseDouble(String.valueOf(objects[3])));
            vipMoneyList.add((Double)objects[3]);
            vipStaVOS.add(vo);
        }
        return vipStaVOS;
    }

    public List getVipMoneyList() {
        List list=new ArrayList();
        List<VIPStaVO> l=getVIPSta();
        for(int i=0;i<l.size();i++){
            list.add("'"+l.get(i).getAll_money()+"'");
        }
        return list;
    }

    public List getVipList() {
        List list=new ArrayList();
        List<VIPStaVO> l=getVIPSta();
        for(int i=0;i<l.size();i++){
            list.add("'"+l.get(i).getVip_name()+"'");
        }
        return list;
    }

    public List getInsList() {
        List list=new ArrayList();
        List<InsStaVO> l=getInsSta();
        for(int i=0;i<l.size();i++){
            list.add("'"+l.get(i).getIns_name()+"'");
        }
        return list;
    }

    public List getInsMoneyList() {
        List list=new ArrayList();
        List<InsStaVO> l=getInsSta();
        for(int i=0;i<l.size();i++){
            list.add("'"+l.get(i).getMoney()+"'");
        }
        return list;
    }

    public double averagePrice() {
        return 0;
    }

    public Map<String, String> getAboutLocation() {
        return null;
    }

    public Map<String, Double> getOkRateChange() {
        return null;
    }

    public Map<String, String> getAboutClassType() {
        return null;
    }

    public Map<String, Double> getMoneyChange() {
        return null;
    }

    public List getTop10Money() {
        return null;
    }

    public List getTop10Num() {
        return null;
    }

    public Map<String, Integer> getStudentsChange() {
        return null;
    }

    public Map<String, Integer> getInsChange() {
        return null;
    }

    public Map<String, Integer> getInsLocation() {
        return null;
    }

    public List getTop10MoneyAll() {
        return null;
    }

    public List getTop10NumAll() {
        return null;
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
