package service;

import model.Institution;
import model.Manager;
import util.InsStaVO;
import util.SumPayVO;
import util.VIPStaVO;

import java.util.List;
import java.util.Map;

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
     * 不通过某个机构的审核注册
     */
    public void disapproveRegis(int ins_id);

    /**
     * 不通过某个机构的信息修改申请
     * @param ins_id
     */
    public void disapproveInfo(int ins_id);

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

    /**
     * 网站运营状况分析-------------统计网站的销售情况，管理机构
     */

    /**
     * Training College课程平均售价=网站总销售额 / 课程销售总数随时间的变化
     * @return
     */
    public Map<String,String> averagePrice();

    /**
     * 网站课程销售量、销售额以及课程平均售价与地域的关系
     * @return
     */
    public Map<String,String> getAboutLocation();

    /**
     * 网站的成交率【=1-课程退订数/课程销售总数】随时间的变化
     * @return
     */
    public Map<String,String> getOkRateChange();

    /**
     * 网站课程销售数/销售额与课程类型之间的关系
     * @return
     */
    public Map<String,String> getAboutClassType();

    /**
     * 财务状况分析 --------------- 预测网站下一期财务状况
     * 1. 销售额增长率=(本月或季度营业额/上一期同期营业额-1)*100%
     * 2. 某月/季度已注册机构销售额与总学员数排行
     * 3. 网站结算所得总额增长率
     */

    /**
     * 销售额随时间变化
     * @return
     */
    public Map<String,Double> getMoneyChange();

    /**
     * 得到某月前10名销售额的机构
     * @return
     */
    public List getTop10Money();

    /**
     * 得到某月前10名学员数的机构
     * @return
     */
    public List getTop10Num();


    /**
     * 学员状况分析 --------------- 帮助经理分析网站的学员情况
     * 1. 网站学员总数，月/季度新增(流失)学员数
     */

    /**
     * 学员总数与时间的变化关系
     * @return
     */
    public Map<String,Integer> getStudentsChange();

    /**
     * 机构状况分析 --------------- 帮助经理分析已注册机构情况
     * 1. 网站已注册机构总数，月/季度新增(流失)机构数
     * 2. 已注册机构数与地域之间的关系
     * 3. 机构总销售量及销售额排行
     */

    /**
     * 机构总数与时间的变化关系
     * @return
     */
    public Map<String,Integer> getInsChange();

    /**
     * 机构总数与地域之间的关系
     * @return
     */
    public Map<String,Integer> getInsLocation();

    /**
     * 得到总时间销售额的机构
     * @return
     */
    public List getTop10MoneyAll();

    /**
     * 得到总时间学员数的机构
     * @return
     */
    public List getTop10NumAll();

}
