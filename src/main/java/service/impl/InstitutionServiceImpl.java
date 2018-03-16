package service.impl;

import dao.InstitutionDao;
import model.Course;
import model.Institution;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.InstitutionService;

import java.util.HashMap;
import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/7
 */
@Service
@Transactional
public class InstitutionServiceImpl implements InstitutionService{
    @Autowired
    private InstitutionDao institutionDao;


    public List<Institution> getAllIns() {
        return institutionDao.getAllIns();
    }

    public List<String> getAllInsName() {
        return institutionDao.getAllInsName();
    }

    public List<String> getAllLocation() {
        return institutionDao.getAllLocation();
    }

    public Institution getInsById(int insId) {
        return institutionDao.getInsById(insId);
    }

    public void addIns(Institution institution) {
        institutionDao.addIns(institution);
    }

    public long getNextId() {
        return institutionDao.getNextId();
    }

    public boolean whetherAct(int insId) {
        return institutionDao.whetherAct(insId);
    }

    public Institution getInfoById(int insId) {
        return institutionDao.getInfoById(insId);
    }

    public boolean checkPass(int id, String password) {
        return institutionDao.checkPass(id,password);
    }

    public void update(Institution institution) {

    }

    public List<Course> getCoursesOfIns(int insId) {
        return institutionDao.getCoursesOfIns(insId);
    }

    public void change(int ins_id, String ins_name, String location, int classrooms) {
        institutionDao.change(ins_id, ins_name, location, classrooms);
    }

    public void setMoney(int ins_id,double money) {
        institutionDao.setMoney(ins_id, money);
    }

    public List<Object[]> getInsOrdersByState(int ins_id,String state) {
        return institutionDao.getInsOrdersByState(ins_id,state);
    }

    public int getOrderNum(int ins_id) {
        return institutionDao.getOrderNum(ins_id);
    }

    public int getStudentNum(int ins_id) {
        return institutionDao.getStudentNum(ins_id);
    }

    public double getMoney(int ins_id) {
        return institutionDao.getMoney(ins_id);
    }

    public int getNumByState(int ins_id, String state) {
        return institutionDao.getNumByState(ins_id, state);
    }

    public HashMap getNumByTeacher(int ins_id) {
        return institutionDao.getNumByTeacher(ins_id);
    }
}
