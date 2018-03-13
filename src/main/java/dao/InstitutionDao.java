package dao;

import model.Institution;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/4
 */
public interface InstitutionDao {
    /**
     * 获取所有机构信息
     * @return
     */
    public List<Institution> getAllIns();

    /**
     * 获取所有机构名称
     * @return
     */
    public List<String> getAllInsName();

    /**
     * 获取所有机构地点
     * @return
     */
    public List<String> getAllLocation();

    /**
     * 根据机构id获得机构的信息
     * @param insId
     * @return
     */
    public Institution getInsById(int insId);

    /**
     * 新增机构，还未审核
     * @param institution
     */
    public void addIns(Institution institution);

    /**
     * 系统自动分配可登录ID
     * @return
     */
    public long getNextId();

    /**
     * 判断机构是否已经通过审核
     * @return
     */
    public boolean whetherAct(int insId);

    /**
     * 通过机构Id获得机构的所有信息
     * @param insId
     * @return
     */
    public Institution getInfoById(int insId);

    /**
     * 登录时检查密码是否正确
     * @param id
     * @param password
     * @return
     */
    public boolean checkPass(int id,String password);
}
