package service.impl;

import dao.ClassDao;
import model.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.ClassService;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/8
 */
@Service
@Transactional
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassDao classDao;

    public List<Classroom> getClassOfOneCourse(int course_id) {
        return classDao.getClassOfOneCourse(course_id);
    }

    public Classroom getInfoByClassId(int class_id) {
        return classDao.getInfoByClassId(class_id);
    }

    public void save(Classroom classroom) {
        classDao.save(classroom);
    }
}
