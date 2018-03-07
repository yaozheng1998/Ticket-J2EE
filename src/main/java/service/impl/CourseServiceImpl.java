package service.impl;

import dao.CourseDao;
import model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.CourseService;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/7
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseDao courseDao;

    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    public List<Course> getCourseByIns(List<String> inses) {
        return courseDao.getCourseByIns(inses);
    }

    public List<Course> getCourseByLocation(List<String> locs) {
        return courseDao.getCourseByLocation(locs);
    }

    public List<Course> getCourseBySubject(List<String> subs) {
        return courseDao.getCourseBySubject(subs);
    }
}
