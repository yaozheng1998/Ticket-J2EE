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
}
