package dao;

import model.Classroom;

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
}
