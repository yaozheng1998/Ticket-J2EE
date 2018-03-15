package service;

import model.Course;
import model.Institution;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/7
 */
public interface InstitutionService {
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

    /**
     * 修改机构信息
     * @param institution
     */
    public void update(Institution institution);

    /**
     * 得到一个机构的所有课程信息，不是班级
     * @param insId
     * @return
     */
    public List<Course> getCoursesOfIns(int insId);

    /**
     * 机构申请修改信息
     * @param ins_id
     * @param ins_name
     * @param location
     * @param classrooms
     */
    public void change(int ins_id,String ins_name,String location,int classrooms);
}
