package dao;

import model.Classroom;
import util.CourseClassVO;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/4
 */
public interface ClassDao {
    /**
     * 获得某个课程下的所有班级
     * @return
     */
    public List<Classroom> getClassOfOneCourse(int course_id);

    /**
     * 根据class id获得信息
     * @param class_id
     * @return
     */
    public Classroom getInfoByClassId(int class_id);

    /**
     * 新增一个班级
     * @param classroom
     */
    public void save(Classroom classroom);

    /**
     * 根据班级名获得班级id
     * @param name
     * @return
     */
    public int getIdFromName(String name);

    /**
     * 根据班级名获得价格
     * @param name
     * @return
     */
    public double getMoneyFromName(String name);

    /**
     * 得到一个机构的所有班级
     * @param insId
     * @return
     */
    public List<CourseClassVO> getClassOfIns(int insId);
}
