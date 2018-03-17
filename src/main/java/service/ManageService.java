package service;

import model.Institution;
import model.Manager;
import util.InsStaVO;
import util.SumPayVO;
import util.VIPStaVO;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/15
 */
public interface ManageService {
    /**
     * 得到所有待审核的机构
     * @return
     */
    public List<Institution> getAllIns();

    /**
     * 得到所有修改机构信息的申请
     * @return
     */
    public List<Institution> getAllChanges();

    /**
     * 通过某个机构的审核注册
     */
    public void approveRegis(int ins_id);

    /**
     * 通过某个机构的信息修改申请
     * @param ins_id
     */
    public void approveInfo(int ins_id);
    /**
     * 得到下一个可用的manager ID
     * @return
     */
    public int getNextId();

    /**
     * 机构注册时在此表中保存数据
     * @param manager
     */
    public void save(Manager manager);

    /**
     * 根据机构编号获得信息
     * @param ins_id
     * @return
     */
    public Manager getManagerByIns(int ins_id);

    /**
     * 修改信息
     * @param
     */
    public void update(Manager manager);

    /**
     * 得到支付结算信息
     * @return
     */
    public List<SumPayVO> getToCal();

    /**
     * 将某机构的七成收入结算
     */
    public double paySeven(int ins_id);

    /**
     * 得到网站的总订单数
     * @return
     */
    public int getAllOrder();

    /**
     * 得到网站的总学生数量
     * @return
     */
    public int getAllStudent();

    /**
     * 得到网站流通的总金额
     * @return
     */
    public double getAllMoney();

    /**
     * 得到机构统计信息
     * @return
     */
    public List<InsStaVO> getInsSta();

    /**
     * 得到会员统计信息
     * @return
     */
    public List<VIPStaVO> getVIPSta();

    public List getVipMoneyList();

    public List getVipList();

    public List getInsList() ;

    public List getInsMoneyList();

}
